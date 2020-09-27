package com.ohayou.liteshop.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/9/24 下午9:20
 */
public class OrderAfterSaleDto {
    private Long orderId;

    private String orderSn;

    private String userMobile;

    private BigDecimal refundAmount;

    private Integer refundType;

    private String refundMessage;

    private LocalDateTime applyAfterSaleTime;

    private Integer afterSaleStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public String getRefundMessage() {
        return refundMessage;
    }

    public void setRefundMessage(String refundMessage) {
        this.refundMessage = refundMessage;
    }

    public LocalDateTime getApplyAfterSaleTime() {
        return applyAfterSaleTime;
    }

    public void setApplyAfterSaleTime(LocalDateTime applyAfterSaleTime) {
        this.applyAfterSaleTime = applyAfterSaleTime;
    }

    public Integer getAfterSaleStatus() {
        return afterSaleStatus;
    }

    public void setAfterSaleStatus(Integer afterSaleStatus) {
        this.afterSaleStatus = afterSaleStatus;
    }
}
