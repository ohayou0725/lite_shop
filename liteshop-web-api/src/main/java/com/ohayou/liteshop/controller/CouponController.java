package com.ohayou.liteshop.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.MemberUserDetails;
import com.ohayou.liteshop.service.MallCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyan
 * @date 2021/1/26 下午9:34
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    MallCouponService couponService;

    @ApiDesc("领取优惠券")
    @PostMapping("/receive")
    public Result receiveCoupon(@RequestParam("couponId") Long couponId,Authentication authentication) {
        if (null == couponId || couponId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails = (MemberUserDetails) authentication.getPrincipal();
        Boolean result = couponService.receive(couponId, memberUserDetails.getId());
        return result ? Result.success() : Result.error(ErrorCodeMsg.COUPON_RECEIVE_ERROR);
    }

    @ApiDesc("查询已经领取优惠券列表")
    @GetMapping("/alreadyReceived")
    public Result ReceivedCoupon(@RequestParam("couponIds") List<Long> coupons, Authentication authentication) {
        if (CollectionUtil.isEmpty(coupons)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails = (MemberUserDetails) authentication.getPrincipal();
        List<Long> result = couponService.hasReceived(coupons,memberUserDetails.getId());
        return Result.success("list",result);
    }
}
