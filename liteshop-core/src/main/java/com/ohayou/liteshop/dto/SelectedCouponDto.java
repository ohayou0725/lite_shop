package com.ohayou.liteshop.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liyan
 * @date 2021/2/21 上午10:22
 */
public class SelectedCouponDto {

    @Max(value = Long.MAX_VALUE,message = "非法ID")
    @Min(value = 0,message = "非法ID")
    @NotNull
    private Long couponId;


    @NotBlank
    @Length(min = 15,max = 15,message = "订单号有误")
    private String orderSn;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
}
