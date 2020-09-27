package com.ohayou.liteshop.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/9/26 下午10:12
 */
public class AfterSaleDetailDto {

    private Long orderId;

    private String orderSn;

    private Integer status;

    private LocalDateTime applyAfterSaleTime;

    private String nickName;

    private String userMobile;

    private String refundMessage;

    private BigDecimal refundAmount;

    private List<OrderItemDto> orderItemList;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getApplyAfterSaleTime() {
        return applyAfterSaleTime;
    }

    public void setApplyAfterSaleTime(LocalDateTime applyAfterSaleTime) {
        this.applyAfterSaleTime = applyAfterSaleTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getRefundMessage() {
        return refundMessage;
    }

    public void setRefundMessage(String refundMessage) {
        this.refundMessage = refundMessage;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public List<OrderItemDto> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemDto> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
