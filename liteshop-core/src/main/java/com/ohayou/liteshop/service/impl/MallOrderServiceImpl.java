package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.constant.OrderStatus;
import com.ohayou.liteshop.constant.PayType;
import com.ohayou.liteshop.constant.ShipChannelCode;
import com.ohayou.liteshop.dto.OrderDetailDto;
import com.ohayou.liteshop.dto.OrderDto;
import com.ohayou.liteshop.dto.OrderItemDto;
import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.dao.MallOrderMapper;
import com.ohayou.liteshop.entity.MallOrderGoods;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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
    ExpressTrackService expressTrackService;
    /**
     * 根据查询查询订单列表
     * @param orderDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(OrderDto orderDto, IPage<MallOrder> page) {
        LambdaQueryWrapper<MallOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(orderDto.getOrderSn()),MallOrder::getOrderSn,orderDto.getOrderSn());
        queryWrapper.eq(null != orderDto.getStatus(),MallOrder::getStatus,orderDto.getStatus());

        if (StringUtils.isNotBlank(orderDto.getUserMobile())) {
            MemUser user = userService.getUserByMobile(orderDto.getUserMobile());
            if (null == user) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MallOrder::getUserId,user.getId());
        }
        queryWrapper.between(null != orderDto.getStartTime() && null != orderDto.getEndTime(),
                            MallOrder::getCreateTime,orderDto.getStartTime(),orderDto.getEndTime());

        this.page(page,queryWrapper);

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
        BeanUtils.copyProperties(order,orderDetailDto);
        orderDetailDto.setOrderId(orderId);
        MemUser user = userService.getById(order.getUserId());
        orderDetailDto.setNickName(user.getNickname());

        if (null != OrderStatus.getStatus(order.getStatus())) {
            orderDetailDto.setStatus(OrderStatus.getStatus(order.getStatus()).getDescription());
        }

        if (null !=PayType.getPayType(order.getPayType()) ) {
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
        if (!OrderStatus.CLOSED.getStatus().equals(status)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_STATUS_ERROR);
        }
        return this.removeById(orderId);
    }

    /**
     * 查询物流
     * @param orderId
     * @return
     */

    @Override
    public Map<String, Object> queryExpressTrack(Long orderId) {
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
        String shipCode = shipChannelCode.getCode();
        String shipSn = order.getShipSn();
        try {
            return expressTrackService.getTrack(shipCode,shipSn);
        } catch (Exception e) {
            throw new GlobalException(ErrorCodeMsg.QUERY_TRACK_ERROR);
        }
    }
}
