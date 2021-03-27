package com.ohayou.liteshop.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2021/3/16 下午9:52
 */
public class OrderListItemVo {


    private String orderSn;

    private Long orderId;


    private BigDecimal totalPrice;

    private BigDecimal discount;

    private BigDecimal paymentPrice;

    private BigDecimal freightPrice;

    private List<OrderItemVo> itemList;

    private Integer status;

    private int comments;

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<OrderItemVo> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItemVo> itemList) {
        this.itemList = itemList;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(BigDecimal paymentPrice) {
        this.paymentPrice = paymentPrice;
    }
}
