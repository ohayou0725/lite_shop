package com.ohayou.liteshop.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2021/2/15 下午10:45
 */
public class OrderConfirmVo implements Serializable {

    private String orderSn;

    private List<OrderConfirmItemVo> orderList;

    private Integer total;

    private BigDecimal amount;

    private BigDecimal totalWeight;

    private BigDecimal freightPrice;

    private BigDecimal payablePrice;

    private List<UserCouponVo> couponList;

    public List<OrderConfirmItemVo> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderConfirmItemVo> orderList) {
        this.orderList = orderList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public List<UserCouponVo> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<UserCouponVo> couponList) {
        this.couponList = couponList;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public BigDecimal getPayablePrice() {
        return payablePrice;
    }

    public void setPayablePrice(BigDecimal payablePrice) {
        this.payablePrice = payablePrice;
    }
}
