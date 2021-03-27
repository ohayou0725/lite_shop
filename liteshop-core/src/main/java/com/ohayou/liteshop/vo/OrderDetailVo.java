package com.ohayou.liteshop.vo;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2021/3/6 下午9:22
 */
public class OrderDetailVo {

    private String OrderSn;

    //商品数量
    private Integer total;
    //商品总价
    private BigDecimal amount;
    //商品总重量
    private BigDecimal totalWeight;
    //商品运费
    private BigDecimal freightPrice;
    //应付金额
    private BigDecimal payablePrice;
    //优惠券减免金额
    private BigDecimal discountPrice;

    private LocalDateTime createTime;

    private LocalDateTime paymentTime;
    //支付方式
    private String PayType;

    private List<OrderItemVo> orderList;

    private MemberAddressVo addressVo;


    public String getOrderSn() {
        return OrderSn;
    }

    public void setOrderSn(String orderSn) {
        OrderSn = orderSn;
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

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getPayablePrice() {
        return payablePrice;
    }

    public void setPayablePrice(BigDecimal payablePrice) {
        this.payablePrice = payablePrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    public List<OrderItemVo> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItemVo> orderList) {
        this.orderList = orderList;
    }

    public MemberAddressVo getAddressVo() {
        return addressVo;
    }

    public void setAddressVo(MemberAddressVo addressVo) {
        this.addressVo = addressVo;
    }
}
