package com.ohayou.liteshop.vo;

import javax.validation.constraints.NotNull;

/**
 * @author liyan
 * @date 2021/3/30 下午9:51
 */
public class CancelOrderVo {

    @NotNull(message = "参数错误")
    private Long orderId;

    private String message;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
