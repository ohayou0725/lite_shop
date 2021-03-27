package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.ConfirmOrderKey;
import com.ohayou.liteshop.cache.cachekey.GoodsLockKey;
import com.ohayou.liteshop.cache.cachekey.GoodsStockKey;
import com.ohayou.liteshop.constant.*;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.*;
import com.ohayou.liteshop.dao.MallOrderMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.mq.exchange.OrderTopicExchangeConfig;
import com.ohayou.liteshop.payment.PayService;
import com.ohayou.liteshop.payment.wechat.NotifyDTO;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.OrderSnUtil;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品订单表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallOrderServiceImpl extends ServiceImpl<MallOrderMapper, MallOrder> implements MallOrderService {

    @Autowired
    MemUserService userService;

    @Autowired
    MallOrderGoodsService orderGoodsService;

    @Autowired
    MallGoodsSkuService skuService;

    @Autowired
    @Qualifier("expressTrackServiceImpl")
    ExpressTrackService expressTrackService;

    @Autowired
    MallGoodsSpuService spuService;

    @Autowired
    SysFreightConfigService sysFreightConfigService;

    @Autowired
    MallCouponService couponService;

    @Autowired
    RedisService redisService;

    @Autowired
    PayService payService;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    MemAddressService addressService;

    @Autowired
    MallUserCouponService userCouponService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SysOrderConfigService sysOrderConfigService;

    @Autowired
    MallGoodsCommentService commentService;



    /**
     * 根据查询查询订单列表
     *
     * @param orderDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(OrderDto orderDto, IPage<MallOrder> page) {
        LambdaQueryWrapper<MallOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(orderDto.getOrderSn()), MallOrder::getOrderSn, orderDto.getOrderSn());
        queryWrapper.eq(null != orderDto.getStatus(), MallOrder::getStatus, orderDto.getStatus());

        if (StringUtils.isNotBlank(orderDto.getUserMobile())) {
            MemUser user = userService.getUserByMobile(orderDto.getUserMobile());
            if (null == user) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MallOrder::getUserId, user.getId());
        }
        queryWrapper.between(null != orderDto.getStartTime() && null != orderDto.getEndTime(),
                MallOrder::getCreateTime, orderDto.getStartTime(), orderDto.getEndTime());

        this.page(page, queryWrapper);

        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<OrderDto> collect = page.getRecords().stream()
                    .map(mallOrder -> {
                        OrderDto newOrderDto = new OrderDto();
                        BeanUtils.copyProperties(mallOrder, newOrderDto);
                        newOrderDto.setOrderId(mallOrder.getId());
                        Long userId = mallOrder.getUserId();
                        MemUser user = userService.getById(userId);
                        if (null != user) {
                            newOrderDto.setUserMobile(user.getMobile());
                        }
                        return newOrderDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 根据订单ID查询订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDetailDto getOrderDetail(Long orderId) {
        MallOrder order = this.getById(orderId);
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        BeanUtils.copyProperties(order, orderDetailDto);
        orderDetailDto.setOrderId(orderId);
        MemUser user = userService.getById(order.getUserId());
        orderDetailDto.setNickName(user.getNickname());

        if (null != OrderStatus.getStatus(order.getStatus())) {
            orderDetailDto.setStatus(OrderStatus.getStatus(order.getStatus()).getDescription());
        }

        if (null != PayType.getPayType(order.getPayType())) {
            orderDetailDto.setPayType(PayType.getPayType(order.getPayType()).getDescription());
        }

        //查询订单商品
        List<MallOrderGoods> goodsList = orderGoodsService.list(new LambdaQueryWrapper<MallOrderGoods>().eq(MallOrderGoods::getOrderId, orderId));

        if (CollectionUtil.isNotEmpty(goodsList)) {
            List<OrderItemDto> collect = goodsList.stream()
                    .map(mallOrderGoods -> {
                        OrderItemDto orderItemDto = new OrderItemDto();
                        BeanUtils.copyProperties(mallOrderGoods, orderItemDto);
                        orderItemDto.setSpecAndValue(skuService.getSpecAndValue(mallOrderGoods.getGoodsSpecSn()));
                        return orderItemDto;
                    }).collect(Collectors.toList());
            orderDetailDto.setOrderItemList(collect);
        }

        return orderDetailDto;
    }

    /**
     * 订单发货
     *
     * @param orderDetailDto@return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean ship(OrderDetailDto orderDetailDto) {
        MallOrder order = this.getById(orderDetailDto.getOrderId());
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        //判断状态是否是已付款
        Integer status = order.getStatus();
        if (!status.equals(OrderStatus.PAID.getStatus())) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }

        order.setShipChannel(orderDetailDto.getShipChannel());
        order.setShipSn(orderDetailDto.getShipSn());
        order.setShipTime(LocalDateTime.now());
        order.setStatus(OrderStatus.SHIPPED.getStatus());

        return this.updateById(order);
    }

    /**
     * 删除订单，只能删除已关闭订单
     *
     * @param orderId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteOrder(Long orderId) {
        MallOrder order = this.getById(orderId);
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }

        Integer status = order.getStatus();
        if (status < OrderStatus.COMPLETED.getStatus() || status > OrderStatus.CLOSED.getStatus() ) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }
        return this.removeById(orderId);
    }

    /**
     * 查询物流
     *
     * @param orderId
     * @return
     */

    @Override
    public List<Map<String, String>> queryExpressTrack(Long orderId) {
        MallOrder order = this.getById(orderId);
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        if (order.getStatus() < OrderStatus.SHIPPED.getStatus()) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }
        ShipChannelCode shipChannelCode = ShipChannelCode.getShipChannelCode(order.getShipChannel());
        if (null == shipChannelCode) {
            throw new GlobalException(ErrorCodeMsg.QUERY_TRACK_ERROR);
        }
        String mobile = "";
        String shipCode = shipChannelCode.getCode();
        String shipSn = order.getShipSn();
        if (shipChannelCode.getCode().equals(ShipChannelCode.SF.getCode())) {
            mobile = order.getMobile();
        }

        List<Map<String,String>> trace = null;
        try {
            ExpressResultDTO track = expressTrackService.getTrack(shipCode, shipSn, mobile);
            if (null != track) {
                trace = track.getList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trace;
    }

    /**
     * 条件查询申请售后订单
     *
     * @param afterSaleDto
     * @param page
     * @return
     */
    @Override
    public PageUtils afterSalePage(OrderAfterSaleDto afterSaleDto, IPage<MallOrder> page) {
        LambdaQueryWrapper<MallOrder> wrapper = new LambdaQueryWrapper<>();
        //如果查询条件里有售后状态则根据状态条件查询，没有则默认查询已申请售后订单
        if (null != afterSaleDto.getAfterSaleStatus()) {
            wrapper.eq(MallOrder::getAftersaleStatus, afterSaleDto.getAfterSaleStatus());
        } else {
            wrapper.gt(MallOrder::getAftersaleStatus, AfterSaleStatus.CAN_APPLY.getStatus());
        }
        wrapper.eq(afterSaleDto.getOrderSn() != null, MallOrder::getOrderSn, afterSaleDto.getOrderSn());
        if (afterSaleDto.getApplyAfterSaleTime() != null) {
            wrapper.between(
                    MallOrder::getApplyAfterSaleTime,
                    afterSaleDto.getApplyAfterSaleTime().toLocalDate().minusDays(1L).atTime(0, 0, 0),
                    afterSaleDto.getApplyAfterSaleTime().toLocalDate().plusDays(1L).atTime(23, 59, 59)
            );
        }

        this.page(page, wrapper);
        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<OrderAfterSaleDto> collect = page.getRecords().stream()
                    .map(mallOrder -> {
                        OrderAfterSaleDto orderAfterSaleDto = new OrderAfterSaleDto();
                        orderAfterSaleDto.setOrderId(mallOrder.getId());
                        orderAfterSaleDto.setOrderSn(mallOrder.getOrderSn());
                        orderAfterSaleDto.setAfterSaleStatus(mallOrder.getAftersaleStatus());
                        orderAfterSaleDto.setApplyAfterSaleTime(mallOrder.getApplyAfterSaleTime());
                        orderAfterSaleDto.setRefundAmount(mallOrder.getRefundAmount());
                        orderAfterSaleDto.setRefundMessage(mallOrder.getRefundMessage());
                        orderAfterSaleDto.setRefundType(mallOrder.getRefundType());
                        Long userId = mallOrder.getUserId();
                        MemUser user = userService.getById(userId);
                        if (null != user) {
                            orderAfterSaleDto.setUserMobile(user.getMobile());
                        }
                        return orderAfterSaleDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 查询已申请售后订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public AfterSaleDetailDto afterSaleDetail(Long orderId) {
        //获取申请售后订单
        MallOrder order = this.getById(orderId);
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        if (order.getAftersaleStatus() < AfterSaleStatus.ALREADY_APPLIED.getStatus()) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_APPLY_AFTER_SALE);
        }
        AfterSaleDetailDto afterSaleDetailDto = new AfterSaleDetailDto();
        afterSaleDetailDto.setOrderId(orderId);
        BeanUtils.copyProperties(order, afterSaleDetailDto);
        afterSaleDetailDto.setStatus(order.getAftersaleStatus());
        MemUser user = userService.getById(order.getUserId());
        afterSaleDetailDto.setNickName(user.getNickname());
        afterSaleDetailDto.setUserMobile(user.getMobile());

        List<MallOrderGoods> orderGoodsList = orderGoodsService.list(
                new LambdaQueryWrapper<MallOrderGoods>().eq(MallOrderGoods::getOrderId, orderId)
                        .eq(MallOrderGoods::getApplyRefund, 1));
        if (CollectionUtil.isEmpty(orderGoodsList)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_APPLY_AFTER_SALE);
        }

        List<OrderItemDto> collect = orderGoodsList.stream()
                .map(mallOrderGoods -> {
                    OrderItemDto orderItemDto = new OrderItemDto();
                    BeanUtils.copyProperties(mallOrderGoods, orderItemDto);
                    orderItemDto.setSpecAndValue(skuService.getSpecAndValue(mallOrderGoods.getGoodsSpecSn()));
                    return orderItemDto;
                }).collect(Collectors.toList());
        afterSaleDetailDto.setOrderItemList(collect);
        return afterSaleDetailDto;
    }

    /**
     * 退货申请审核通过
     *
     * @param orderId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean approvedOrder(Long orderId) {
        MallOrder order = this.getById(orderId);
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        Integer aftersaleStatus = order.getAftersaleStatus();
        if (!aftersaleStatus.equals(AfterSaleStatus.ALREADY_APPLIED.getStatus())) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }
        order.setAftersaleStatus(AfterSaleStatus.ADMIN_PASSED.getStatus());
        return this.updateById(order);
    }

    /**
     * 拒绝退货申请
     *
     * @param orderId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean refuseOrder(Long orderId) {
        MallOrder order = this.getById(orderId);
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        Integer aftersaleStatus = order.getAftersaleStatus();
        if (!aftersaleStatus.equals(AfterSaleStatus.ALREADY_APPLIED.getStatus())) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }
        order.setAftersaleStatus(AfterSaleStatus.UN_PASSED.getStatus());
        return this.updateById(order);
    }

    @Override
    public List<OrderStatisticsDto> getOrderStatistics(LocalDate startTime, LocalDate endTime) {
        LambdaQueryWrapper<MallOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(MallOrder::getCreateTime,startTime,endTime);

        List<MallOrder> orders = this.list(wrapper);

        Map<LocalDate,List<MallOrder>> orderMap = orders.stream()
                .collect(Collectors.groupingBy(order->{
                    return order.getCreateTime().toLocalDate();
                }));
        List<OrderStatisticsDto> orderStatisticsDtos = new ArrayList<>();
        orderMap.forEach((data,orderList)->{
            OrderStatisticsDto orderStatisticsDto = new OrderStatisticsDto();
            orderStatisticsDto.setCount(orderList.size());
            orderStatisticsDto.setOrderDate(data);
            Optional<BigDecimal> totalPrice = orderList.parallelStream()
                    .map(MallOrder::getOrderPrice)
                    .reduce(BigDecimal::add);
            totalPrice.ifPresent(orderStatisticsDto::setAmount);
            orderStatisticsDtos.add(orderStatisticsDto);
        });

        return orderStatisticsDtos.stream()
                .sorted(Comparator.comparing(OrderStatisticsDto::getOrderDate)).collect(Collectors.toList());


    }

    /**
     * 获取订单确认信息
     * @param orderConfirmItems
     * @return
     */
    @Override
    public OrderConfirmVo getOrderConfirm(List<OrderConfirmItemVo> orderConfirmItems,Long userId) {
        OrderConfirmVo orderConfirmVo = new OrderConfirmVo();
        orderConfirmVo.setTotal(0);
        orderConfirmVo.setAmount(BigDecimal.ZERO);
        orderConfirmVo.setTotalWeight(BigDecimal.ZERO);
        List<UserCouponVo> userCouponVoList = couponService.getCouponByUserId(userId);
        orderConfirmItems.forEach(orderConfirmItemVo -> {
            if (orderConfirmItemVo.getSkuId() == null || orderConfirmItemVo.getNum() == null
                    || orderConfirmItemVo.getSkuId() < 1 || orderConfirmItemVo.getNum() < 1
            ) {
                throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
            }
            MallGoodsSku sku = skuService.getById(orderConfirmItemVo.getSkuId());
            if (null == sku) {
                throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
            }
//            if (sku.getStock() - orderConfirmItemVo.getNum() < 0) {
//                throw new GlobalException(ErrorCodeMsg.GOODS_INVENTORY_SHORTAGE);
//            }
            MallGoodsSpu spu = spuService.getById(sku.getGoodsId());
            if (null == spu || spu.getStatus().equals(GoodsStatus.NOT_IN_STOCK.getStatus())) {
                throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
            }
            orderConfirmItemVo.setImg(sku.getImg());
            orderConfirmItemVo.setPrice(sku.getPrice());
            orderConfirmItemVo.setSpecs(skuService.getSpecAndValue(sku.getSpecSn()));
            orderConfirmItemVo.setTitle(spu.getTitle());
            orderConfirmItemVo.setGoodsSn(spu.getGoodsSn());
            orderConfirmItemVo.setWeight(spu.getWeight().multiply(new BigDecimal(String.valueOf(orderConfirmItemVo.getNum()))).stripTrailingZeros().toPlainString());
            orderConfirmVo.setTotalWeight(orderConfirmVo.getTotalWeight().add(new BigDecimal(orderConfirmItemVo.getWeight())));
            orderConfirmVo.setTotal(orderConfirmVo.getTotal() + orderConfirmItemVo.getNum());
            orderConfirmVo.setAmount(orderConfirmVo.getAmount().add(orderConfirmItemVo.getPrice().multiply(new BigDecimal(String.valueOf(orderConfirmItemVo.getNum())))));
            orderConfirmVo.setPayablePrice(orderConfirmVo.getAmount());
            if (CollectionUtil.isNotEmpty(userCouponVoList)) {
                List<UserCouponVo> couponVos = couponService.getApplicableCoupon(userCouponVoList,spu);
                orderConfirmVo.setCouponList(couponVos);
            }
        });

        orderConfirmVo.setOrderList(orderConfirmItems);
        //计算运费，获取可用优惠券信息
        BigDecimal amount = orderConfirmVo.getAmount();
        SysFreightConfig sysFreightConfig = sysFreightConfigService.list().get(0);
        if (amount.compareTo(sysFreightConfig.getReliefAmount()) < 1){
            //如果当前商品总价小于包邮价格则计算运费，否则运费为0
            BigDecimal total = orderConfirmItems.stream()
                    .map(orderConfirmItemVo -> {
                        return new BigDecimal(orderConfirmItemVo.getWeight());
                    })
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            //商品总重小于1KG
            if (total.compareTo(new BigDecimal(1)) < 1) {
                orderConfirmVo.setFreightPrice(sysFreightConfig.getFreightPrice());
            } else {
                total = total.subtract(BigDecimal.ONE);
                BigDecimal excessWeight = total.setScale(0, BigDecimal.ROUND_DOWN);
                orderConfirmVo.setFreightPrice(sysFreightConfig.getFreightPrice().add(excessWeight.multiply(sysFreightConfig.getContinuedWeightFreight())));
            }
            orderConfirmVo.setPayablePrice(orderConfirmVo.getAmount().add(orderConfirmVo.getFreightPrice()));
        } else {
            orderConfirmVo.setFreightPrice(BigDecimal.ZERO);
        }

        orderConfirmVo.setOrderSn(OrderSnUtil.generateOrderSn());

        //将确认订单信息存入到redis
        ConfirmOrderKey confirmOrderKey = new ConfirmOrderKey(String.valueOf(userId));
        redisService.hset(confirmOrderKey.getPrefix(),orderConfirmVo.getOrderSn(),orderConfirmVo);
        return orderConfirmVo;
    }

    /**
     * 订单使用优惠券
     * @param orderSn 订单号
     * @param couponId 所要使用的优惠券ID,如果id为0则表示不使用优惠券
     * @param id 当前用户ID
     * @return 订单总价
     */
    @Override
    public BigDecimal useCoupon(String orderSn, Long couponId, Long id) {
        //redis里取出当前用户的订单，判断是否存在该订单
        ConfirmOrderKey confirmOrderKey = new ConfirmOrderKey(String.valueOf(id));
        if (!redisService.hasKey(confirmOrderKey.getPrefix()) ) {
            throw new GlobalException(ErrorCodeMsg.CONFIRM_ORDER_NOT_EXIST);
        }
        Object object = redisService.hget(confirmOrderKey.getPrefix(), orderSn);
        if (null == object) {
            throw new GlobalException(ErrorCodeMsg.CONFIRM_ORDER_NOT_EXIST);
        }
        OrderConfirmVo orderConfirmVo = (OrderConfirmVo)object;
        List<UserCouponVo> couponList = orderConfirmVo.getCouponList();

        //如果couponId为0，查询是否有已选中优惠券， 没有则返回当前订单总价，有则加上优惠券金额
        if (couponId == 0) {
            Optional<UserCouponVo> first = couponList.stream()
                    .filter(UserCouponVo::isSelected)
                    .findFirst();
            if (!first.isPresent()) {
                return orderConfirmVo.getPayablePrice();
            }
            orderConfirmVo.setPayablePrice(orderConfirmVo.getPayablePrice().add(new BigDecimal(first.get().getValue())));
            first.get().setSelected(false);
            redisService.hset(confirmOrderKey.getPrefix(), orderSn, orderConfirmVo);
            return orderConfirmVo.getPayablePrice();
        }
        if (CollectionUtil.isEmpty(couponList)) {
            return orderConfirmVo.getPayablePrice();
        }


        Optional<UserCouponVo> first = couponList.stream()
                .filter(userCouponVo -> {
                    return userCouponVo.getCouponId().equals(couponId);
                })
                .findFirst();
        if (!first.isPresent()){
            throw new GlobalException(ErrorCodeMsg.COUPON_NOT_EXIST);
        }

        UserCouponVo userCouponVo = first.get();
        //判断所选优惠券是否已经过期
        Long startAt = userCouponVo.getStartAt();
        Long endAt = userCouponVo.getEndAt();
        Long current = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        if (current > endAt || current < startAt) {
            throw new GlobalException(ErrorCodeMsg.COUPON_EXPIRED);
        }
        userCouponVo.setSelected(true);
        for (UserCouponVo couponVo : couponList) {
            if (userCouponVo.getCouponId().equals(couponVo.getCouponId())) {
                couponVo.setSelected(true);
            } else {
                couponVo.setSelected(false);
            }
        }

        BigDecimal discountPrice = new BigDecimal(userCouponVo.getValue());
        orderConfirmVo.setPayablePrice(orderConfirmVo.getAmount().subtract(discountPrice));
        orderConfirmVo.setCouponList(couponList);
        boolean result = redisService.hset(confirmOrderKey.getPrefix(), orderSn, orderConfirmVo);
        return result ? orderConfirmVo.getPayablePrice() : orderConfirmVo.getAmount();
    }

    /**
     * 用户下单
     * @param orderSn 订单号
     * @param addressId 收货地址Id
     * @param userId 用户ID
     * @return 支付url
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String settleOrder(String orderSn, Long addressId, Long userId){
        ConfirmOrderKey confirmOrderKey = new ConfirmOrderKey(String.valueOf(userId));
        //redis里获取该订单信息
        Object o = redisService.hget(confirmOrderKey.getPrefix(),orderSn);
        if (null == o) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        OrderConfirmVo orderConfirmVo =  (OrderConfirmVo)o;
        List<OrderConfirmItemVo> orderList = orderConfirmVo.getOrderList();
        MemAddress address = addressService.getById(addressId);
        if (null == address) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        //判断优惠券是否过期,是否还有足够优惠券
        Optional<UserCouponVo> first = orderConfirmVo.getCouponList().stream().filter(UserCouponVo::isSelected).findFirst();
        MallUserCoupon mallUserCoupon = null;
        UserCouponVo userCouponVo = first.orElse(null);

        if (null != userCouponVo) {
            Long startAt = userCouponVo.getStartAt();
            Long endAt = userCouponVo.getEndAt();
            Long current = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
            if (current > endAt || current < startAt) {
                throw new GlobalException(ErrorCodeMsg.COUPON_EXPIRED);
            }
            Integer number = userCouponVo.getNumber();
            mallUserCoupon = userCouponService.getById(userCouponVo.getUserCouponId());
            if (mallUserCoupon.getNumber() < number) {
                throw new GlobalException(ErrorCodeMsg.COUPON_INSUFFICIENT_QUANTITY);
            }
            mallUserCoupon.setNumber(mallUserCoupon.getNumber()-number);
        }
        orderList.forEach(order->{
            //获取订单后检查商品库存是否足够
            //redisson实现分布式锁
            Long skuId = order.getSkuId();
            String key = new GoodsLockKey(String.valueOf(skuId)).getPrefix();
            RLock lock = redissonClient.getLock(key);
            try {
                lock.lock(2, TimeUnit.SECONDS);
                //如果按到锁，则查询剩余库存，如果库存不足，则返回信息，反之修改库存数
                MallGoodsSku sku = skuService.getById(skuId);
                int stock = sku.getStock();
                if (stock - order.getNum() < 0) {
                    throw new GlobalException(ErrorCodeMsg.GOODS_INVENTORY_SHORTAGE);
                }
                stock = stock - order.getNum();
                boolean result = skuService.decreaseStock(skuId,stock);

                if (!result) {
                    throw new GlobalException(ErrorCodeMsg.SETTLE_ORDER_ERROR);
                }
            } catch (IllegalStateException e) {
                log.error("获取锁超时",e);
                throw new GlobalException(ErrorCodeMsg.SETTLE_ORDER_ERROR);
            } finally {
                lock.unlock();
            }
        });

        MallOrder mallOrder = new MallOrder();
        mallOrder.setOrderSn(orderConfirmVo.getOrderSn());
        mallOrder.setUserId(userId);
        mallOrder.setStatus(OrderStatus.UNPAID.getStatus());
        mallOrder.setAftersaleStatus(AfterSaleStatus.CAN_APPLY.getStatus());
        mallOrder.setActualPayment(orderConfirmVo.getPayablePrice());//实付金额
        mallOrder.setFreightPrice(orderConfirmVo.getFreightPrice());//运费
        mallOrder.setOrderPrice(orderConfirmVo.getAmount().add(orderConfirmVo.getFreightPrice()));//订单总价
        if (null != userCouponVo) {
            mallOrder.setCouponPrice(new BigDecimal(userCouponVo.getValue()));
        }
        mallOrder.setGoodsPrice(orderConfirmVo.getAmount());
        mallOrder.setReceiver(address.getReceiver());
        mallOrder.setMobile(address.getReceiverMobile());
        mallOrder.setAddress(address.getAddress());
        boolean save = this.save(mallOrder);
        if (!save) {
            throw new GlobalException(ErrorCodeMsg.SETTLE_ORDER_ERROR);
        }
        //订单保存商品信息
        List<MallOrderGoods> collect = orderList.stream()
                .map(orderConfirmItemVo -> {
                    MallOrderGoods mallOrderGoods = new MallOrderGoods();
                    mallOrderGoods.setOrderId(mallOrder.getId());
                    mallOrderGoods.setSkuId(orderConfirmItemVo.getSkuId());
                    mallOrderGoods.setGoodsSn(orderConfirmItemVo.getGoodsSn());
                    mallOrderGoods.setGoodsName(orderConfirmItemVo.getTitle());
                    mallOrderGoods.setNumber(orderConfirmItemVo.getNum());
                    mallOrderGoods.setPrice(orderConfirmItemVo.getPrice());
                    mallOrderGoods.setSubtotal(orderConfirmItemVo.getPrice().multiply(new BigDecimal(orderConfirmItemVo.getNum())));
                    mallOrderGoods.setGoodsImg(orderConfirmItemVo.getImg());
                    mallOrderGoods.setGoodsSpecSn(skuService.getById(orderConfirmItemVo.getSkuId()).getSpecSn());
                    return mallOrderGoods;
                }).collect(Collectors.toList());
        boolean orderGoodsSave = orderGoodsService.saveBatch(collect);
        if (!orderGoodsSave) {
            throw new GlobalException(ErrorCodeMsg.SETTLE_ORDER_ERROR);
        }
        //消耗优惠券
        if (null != mallUserCoupon) {
            mallUserCoupon.setOrderId(mallOrder.getId());
            if (!userCouponService.updateById(mallUserCoupon)) {
                throw new GlobalException(ErrorCodeMsg.SETTLE_ORDER_ERROR);
            }
        }
        //保存数据库后向消息队列发送消息
        try {
            rabbitTemplate.convertAndSend(OrderTopicExchangeConfig.ORDER_EXCHANGE_NAME,
                    "order.info",
                    objectMapper.writeValueAsString(orderConfirmVo));
        } catch (Exception e) {
            throw new GlobalException(ErrorCodeMsg.SETTLE_ORDER_ERROR);
        }

        return mallOrder.getOrderSn();
    }

    /**
     * 系统取消订单
     * @param ordersn
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean cancelOrder(String orderSn) {
        MallOrder order = this.getOne(new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getOrderSn, orderSn));
        if (null == order) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        if (order.getStatus() > OrderStatus.UNPAID.getStatus()) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }
        //如果订单未支付,释放库存，返还优惠券,修改订单状态,取消订单
        order.setStatus(OrderStatus.CLOSED.getStatus());
        boolean update = this.updateById(order);
        if (update) {
            List<MallOrderGoods> list = orderGoodsService.list(new LambdaQueryWrapper<MallOrderGoods>().eq(MallOrderGoods::getOrderId, order.getId()));
            list.forEach(orderGoods -> {
                MallGoodsSku sku = skuService.getOne(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getSpecSn, orderGoods.getGoodsSpecSn()));
                sku.setStock(sku.getStock() + orderGoods.getNumber());
                boolean update1 = skuService.updateById(sku);
                if (update1) {
                    GoodsStockKey goodsStockKey = new GoodsStockKey();
                    redisService.hset(goodsStockKey.getPrefix(), String.valueOf(sku.getId()), sku.getStock() + orderGoods.getNumber());
                }
            });
            //如果使用了优惠券返还优惠券
            //先获取该订单使用的优惠券
            MallUserCoupon userCoupon = userCouponService.getOne(new LambdaQueryWrapper<MallUserCoupon>().eq(MallUserCoupon::getOrderId, order.getId()));

            if (null != userCoupon ) {
                Integer number = userCoupon.getNumber() + 1;
                MallUserCoupon coupon = userCouponService.getById(userCoupon);
                coupon.setNumber(number);
                coupon.setOrderId(0L);
                return userCouponService.updateById(coupon);
            }
            return true;
        }
        return false;
    }

    /**
     * 根据订单编号获取订单详情
     * @param orderSn 订单号
     * @return 订单详情
     */
    @Override
    public OrderDetailVo getOrderDetailByOrderSn(String orderSn, Long userId) {
        MallOrder order = this.getOne(new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getOrderSn, orderSn));
        if (null == order || !order.getUserId().equals(userId)) {
            //判断是否为当前用户订单，防止横向越权
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }

        MemberAddressVo memberAddressVo = new MemberAddressVo();
        memberAddressVo.setAddress(order.getAddress());
        memberAddressVo.setArea(order.getAddress());
        memberAddressVo.setReceiver(order.getReceiver());
        memberAddressVo.setReceiverMobile(order.getMobile());

        OrderDetailVo orderDetailVo = new OrderDetailVo();
        orderDetailVo.setAddressVo(memberAddressVo);
        orderDetailVo.setOrderSn(orderSn);
        orderDetailVo.setCreateTime(order.getCreateTime());
        orderDetailVo.setDiscountPrice(order.getCouponPrice());
        orderDetailVo.setAmount(order.getGoodsPrice());
        orderDetailVo.setFreightPrice(order.getFreightPrice());
        orderDetailVo.setPayablePrice(order.getActualPayment());
        orderDetailVo.setPaymentTime(order.getPayTime());
        orderDetailVo.setPayType(PayType.getPayType(order.getPayType()).getDescription());

        List<MallOrderGoods> orderGoodsList = orderGoodsService.list(new LambdaQueryWrapper<MallOrderGoods>().eq(MallOrderGoods::getOrderId, order.getId()));
        List<OrderItemVo> collect = orderGoodsList.stream()
                .map(orderGoods -> {
                    OrderItemVo orderItemVo = new OrderItemVo();
                    orderItemVo.setGoodsSn(orderGoods.getGoodsSn());
                    orderItemVo.setImg(orderGoods.getGoodsImg());
                    orderItemVo.setNum(orderGoods.getNumber());
                    orderItemVo.setTitle(orderGoods.getGoodsName());
                    orderItemVo.setPrice(orderGoods.getPrice());
                    orderItemVo.setSkuId(orderGoods.getSkuId());
                    orderItemVo.setSpecs(skuService.getSpecAndValue(orderGoods.getGoodsSpecSn()));
                    return orderItemVo;
                })
                .collect(Collectors.toList());
        orderDetailVo.setOrderList(collect);
        return orderDetailVo;
    }

    /**
     * 获取订单剩余时间
     * @param orderSn
     * @param userId
     * @return
     */
    @Override
    public Long getRemainingTime(String orderSn, Long userId) {
        MallOrder order = this.getOne(new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getOrderSn, orderSn));

        if (null == order || !order.getUserId().equals(userId)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        if (!order.getStatus().equals(OrderStatus.UNPAID.getStatus())) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }

        SysOrderConfig orderConfig = sysOrderConfigService.list().get(0);
        LocalDateTime createTime = order.getCreateTime();
        LocalDateTime expireTime = createTime.plusMinutes(orderConfig.getExpireTime());
        long expire = expireTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long current = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return expire - current;
    }

    /**
     * 支付订单
     * @param orderSn
     * @param payType
     * @param userId
     * @return
     */
    @Override
    public String doPay(String orderSn, Integer payType, Long userId) {
        MallOrder order = this.getOne(new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getOrderSn, orderSn));
        if (null == order || !order.getUserId().equals(userId)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        if ( order.getStatus() > OrderStatus.UNPAID.getStatus()) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }

        PayType payType1 = PayType.getPayType(payType);

        return payService.pay(order.getActualPayment(),orderSn,payType1);
    }

    /**
     * 订单已支付，修改订单状态
     *
     * @param notifyDTO@return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean doPayed(NotifyDTO notifyDTO) {
        String orderSn = notifyDTO.getOut_trade_no();
        MallOrder order = this.getOne(new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getOrderSn, orderSn));
        if (null != order) {
            if (order.getStatus().equals(OrderStatus.UNPAID.getStatus())) {
                order.setStatus(OrderStatus.PAID.getStatus());
                order.setPayId(notifyDTO.getPayjs_order_id());
                order.setPayType(PayType.WECHAT.getType());
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                order.setPayTime(LocalDateTime.parse(notifyDTO.getTime_end(),dateTimeFormatter));
                return this.updateById(order);
            }
        }
        return false;
    }

    /**
     * 用户未付款取消订单
     * @param orderSn
     * @param userId
     * @return
     */
    @Override
    public boolean cancelOrder(String orderSn, Long userId) {
        LambdaQueryWrapper<MallOrder> wrapper = new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getOrderSn, orderSn).eq(MallOrder::getUserId, userId);
        if (this.count(wrapper) < 1) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        return this.cancelOrder(orderSn);
    }

    /**
     * 分页查询订单列表
     * @param page 当前页数
     * @param size 数量
     * @param status 订单状态
     * @return 订单
     */
    @Override
    public List<OrderListItemVo> queryOrderList(int page, int size,int  status,Long userId) {
        LambdaQueryWrapper<MallOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(status > -1 , MallOrder::getStatus,status);
        wrapper.eq(MallOrder::getUserId,userId);
        wrapper.orderByDesc(MallOrder::getCreateTime);

        IPage<MallOrder> iPage = new Page<>(page,size);
        IPage<MallOrder> pageList = this.page(iPage, wrapper);

        if (CollectionUtil.isNotEmpty(pageList.getRecords())) {
            List<MallOrder> records = pageList.getRecords();
            List<OrderListItemVo> collect1 = records.stream()
                    .map(order -> {
                        OrderListItemVo orderListItemVo = new OrderListItemVo();
                        orderListItemVo.setOrderId(order.getId());
                        orderListItemVo.setDiscount(order.getCouponPrice());
                        orderListItemVo.setPaymentPrice(order.getActualPayment());
                        orderListItemVo.setOrderSn(order.getOrderSn());
                        orderListItemVo.setTotalPrice(order.getOrderPrice());
                        orderListItemVo.setFreightPrice(order.getFreightPrice());
                        orderListItemVo.setStatus(order.getStatus());
                        orderListItemVo.setComments(order.getComments());
                        List<MallOrderGoods> orderGoodsList = orderGoodsService.list(new LambdaQueryWrapper<MallOrderGoods>().eq(MallOrderGoods::getOrderId, order.getId()));
                        List<OrderItemVo> collect = orderGoodsList.stream()
                                .map(orderGoods -> {
                                    OrderItemVo orderItemVo = new OrderItemVo();
                                    orderItemVo.setImg(orderGoods.getGoodsImg());
                                    orderItemVo.setSpecs(skuService.getSpecAndValue(orderGoods.getGoodsSpecSn()));
                                    orderItemVo.setPrice(orderGoods.getPrice());
                                    orderItemVo.setTitle(orderGoods.getGoodsName());
                                    orderItemVo.setNum(orderGoods.getNumber());
                                    orderItemVo.setSkuId(orderGoods.getSkuId());

                                    return orderItemVo;
                                }).collect(Collectors.toList());

                        orderListItemVo.setItemList(collect);

                        return orderListItemVo;
                    }).collect(Collectors.toList());
            return collect1;
        }
        return ListUtil.empty();
    }

    /**
     * 用户删除订单
     * @param orderId
     * @param id
     * @return
     */
    @Override
    public boolean deleteByMember(Long orderId, Long userId) {
        MallOrder order = this.getById(orderId);
        if (null == order || !order.getUserId().equals(userId)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }

        return this.deleteOrder(orderId);
    }

    /**
     * 获取订单分类数量
     * @param userId
     * @return
     */
    @Override
    public OrderCountVo getOrderCount(Long userId) {
        OrderCountVo orderCountVo = new OrderCountVo();

        LambdaQueryWrapper<MallOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MallOrder::getUserId,userId);

        List<MallOrder> list = this.list(wrapper);
        Map<Integer, List<MallOrder>> collect = list.stream()
                .collect(Collectors.groupingBy((MallOrder::getStatus)));

        if (null != collect.get(OrderStatus.UNPAID.getStatus())){
            orderCountVo.setUnPaidOrderCount(OrderStatus.UNPAID.getStatus());
        }

        if (null != collect.get(OrderStatus.PAID.getStatus())) {
            orderCountVo.setPaidOrderCount(collect.get(OrderStatus.PAID.getStatus()).size());
        }

        if (null != collect.get(OrderStatus.SHIPPED.getStatus())) {
            orderCountVo.setShippedOrderCount(collect.get(OrderStatus.SHIPPED.getStatus()).size());
        }

        Integer afterSaleCount = Integer.valueOf(String.valueOf(list.stream().filter(order -> {
            return order.getAftersaleStatus().equals(AfterSaleStatus.ALREADY_APPLIED.getStatus());
        }).count()));
        orderCountVo.setAfterSaleOrderCount(afterSaleCount);
        if (null != collect.get(OrderStatus.COMPLETED.getStatus())) {
            List<MallOrder> mallOrders = collect.get(OrderStatus.COMPLETED.getStatus());
            Integer reduce = mallOrders.stream()
                    .map(MallOrder::getComments)
                    .reduce(0, Integer::sum);
            orderCountVo.setUnCommentOrderCount(reduce);
        }

        return orderCountVo;
    }

    /**
     * 查询订单物流轨迹
     * @param orderId 订单Id
     * @param userId 用户ID
     * @return
     */
    @Override
    public ShipTraceVo getOrderTrace(Long orderId, Long userId) {
        MallOrder order = this.getById(orderId);
        if (null == order || !order.getUserId().equals(userId)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }

        //判断当前订单是否已发货
        if (!(order.getStatus() >= OrderStatus.SHIPPED.getStatus() && order.getStatus() < OrderStatus.CLOSED.getStatus())) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }


        ShipChannelCode shipChannelCode = ShipChannelCode.getShipChannelCode(order.getShipChannel());
        if (null == shipChannelCode) {
            throw new GlobalException(ErrorCodeMsg.QUERY_TRACK_ERROR);
        }
        String shipCode = shipChannelCode.getCode();
        String shipSn = order.getShipSn();
        String mobile = "";
        if (shipChannelCode.getCode().equals(ShipChannelCode.SF.getCode())) {
            mobile = order.getMobile();
        }
        ExpressResultDTO  expressResultDTO = new ExpressResultDTO();
        ShipTraceVo shipTraceVo = new ShipTraceVo();
        try {
            expressResultDTO = expressTrackService.getTrack(shipCode, shipSn, mobile);
            if (null != expressResultDTO ) {
                shipTraceVo.setAddress(order.getAddress());
                shipTraceVo.setMobile(order.getMobile());
                shipTraceVo.setReceiver(order.getReceiver());
                shipTraceVo.setShipChannel(order.getShipChannel());
                shipTraceVo.setShipSn(order.getShipSn());
                shipTraceVo.setLogo(expressResultDTO.getLogo());
                shipTraceVo.setContent(expressResultDTO.getList());
            }
        } catch (Exception e) {
            throw new GlobalException(ErrorCodeMsg.QUERY_TRACK_ERROR);
        }


        return shipTraceVo;
    }


}
