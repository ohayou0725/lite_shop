package com.ohayou.liteshop.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.ohayou.liteshop.annotation.Idempotent;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.cache.cachekey.RequestTokenKey;
import com.ohayou.liteshop.dto.SelectedCouponDto;

import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.payment.PayService;
import com.ohayou.liteshop.payment.wechat.WechatPayConfig;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.MemberUserDetails;
import com.ohayou.liteshop.security.SecurityUtil;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author liyan
 * @date 2021/2/16 上午10:21
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    MallOrderService orderService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    WechatPayConfig payConfig;

    @Autowired
    PayService payService;

    @ApiDesc("获取订单确认信息")
    @PostMapping("/confirm")
    public Result getConfirm(@RequestBody List<OrderConfirmItemVo> orderConfirmItems, Authentication authentication) {
        if (CollectionUtil.isEmpty(orderConfirmItems)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        MemberUserDetails user = (MemberUserDetails)authentication.getPrincipal();
        OrderConfirmVo orderConfirmVo = orderService.getOrderConfirm(orderConfirmItems,user.getId());
        return Result.success("data",orderConfirmVo);
    }

    @ApiDesc("使用优惠券")
    @PostMapping("/selectCoupon")
    public Result selectCoupon(@RequestBody @Valid SelectedCouponDto selectedCouponDto,Authentication authentication) {
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        BigDecimal amount = orderService.useCoupon(selectedCouponDto.getOrderSn(),selectedCouponDto.getCouponId(),memberUser.getId());
        return Result.success("payablePrice",amount);
    }

    @ApiDesc("获取订单请求令牌")
    @GetMapping("/getToken")
    public Result getOrderToken(Authentication authentication) {
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        String requestToken = UUID.randomUUID().toString().replace("-","");
        RequestTokenKey requestTokenKey = new RequestTokenKey(requestToken,600);
        redisTemplate.opsForValue().set(requestTokenKey.getPrefix(), String.valueOf(memberUser.getId()));
        return Result.success("token",requestToken);
    }

    @ApiDesc("提交订单")
    @Idempotent
    @PostMapping("/settle")
    public Result settleOrder(@RequestBody @Valid SettleOrderFormVo settleOrderFormVo, Authentication authentication, HttpServletResponse response) throws IOException {
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        String orderSn = orderService.settleOrder(settleOrderFormVo.getOrderSn(),settleOrderFormVo.getAddressId(),memberUser.getId());
        return Result.success("orderSn",orderSn);
    }

    @ApiDesc("获取订单详情")
    @GetMapping("/detail")
    public Result getOrderDetail(@RequestParam("orderSn") String orderSn,Authentication authentication) {
        if (StringUtils.isBlank(orderSn)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        OrderDetailVo orderDetailVo = orderService.getOrderDetailByOrderSn(orderSn,memberUser.getId());
        return Result.success("detail",orderDetailVo);
    }

    @ApiDesc("获取订单支付剩余时间")
    @GetMapping("/remainingTime")
    public Result getRemainingTime(@RequestParam("orderSn") String orderSn, Authentication authentication) {
        if (StringUtils.isBlank(orderSn)) {
            throw new GlobalException(ErrorCodeMsg.ORDER_NOT_EXIST);
        }
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        Long remainingTime = orderService.getRemainingTime(orderSn,memberUser.getId());
        return Result.success("expireTime",remainingTime);
    }

    @ApiDesc("获取订单类别数量")
    @GetMapping("/count")
    public Result getOrderCount(Authentication authentication) {
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        OrderCountVo orderCountVo = orderService.getOrderCount(memberUser.getId());
        return Result.success("count",orderCountVo);
    }

    @ApiDesc("订单支付")
    @PostMapping("/pay")
    public Result payment(@RequestBody Map<String,String> payParams,Authentication authentication) {
        if (null == payParams) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        String orderSn = "";
        Integer payType = 0;
        try {
            orderSn = payParams.get("orderSn");
            payType = Integer.parseInt(payParams.get("payType"));
        } catch (Exception e) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        if (StringUtils.isBlank(orderSn) || payType < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);

        String url = orderService.doPay(orderSn,payType,memberUser.getId());
        return Result.success("url",url);
    }

    @ApiDesc("用户取消订单")
    @PostMapping("/cancelOrder")
    public Result cancelOrder(@RequestParam("orderSn") String orderSn, Authentication authentication) {
        if (StringUtils.isBlank(orderSn)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        boolean result = orderService.cancelOrder(orderSn,memberUser.getId());
        return result ? Result.success() : Result.error(ErrorCodeMsg.ORDER_ERROR);
    }


    @ApiDesc("查询订单列表")
    @GetMapping("/list")
    public Result getOrderList(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               @RequestParam(value = "status" ,defaultValue = "-1") int status,
                               Authentication authentication) {

        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        List<OrderListItemVo> list = orderService.queryOrderList(page,size,status,memberUser.getId());
        return Result.success("list",list);
    }

    @ApiDesc("删除订单")
    @DeleteMapping("/{orderId}")
    public Result deleteOrder(@PathVariable("orderId") Long orderId,Authentication authentication) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        boolean result = orderService.deleteByMember(orderId,memberUser.getId());
        return result ? Result.success() : Result.error(ErrorCodeMsg.ORDER_NOT_DELETE);
    }

    @ApiDesc("获取订单轨迹")
    @GetMapping("/trace/{orderId}")
    public Result orderTrace(@PathVariable("orderId") Long orderId,Authentication authentication) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);

        ShipTraceVo shipTraceVo = orderService.getOrderTrace(orderId,memberUser.getId());
        return Result.success("trace",shipTraceVo);
    }

}
