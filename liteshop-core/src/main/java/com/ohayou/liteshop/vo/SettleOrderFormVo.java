package com.ohayou.liteshop.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liyan
 * @date 2021/2/23 下午9:33
 */
public class SettleOrderFormVo {

    @NotBlank(message = "订单号不能为空")
    private String orderSn;

    @NotNull(message = "缺少收货地址")
    private Long addressId;





    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
