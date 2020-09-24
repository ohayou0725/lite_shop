package com.ohayou.liteshop.dto;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/9/20 下午10:42
 */
public class OrderItemDto {

    private Long id;

    private Long orderId;

    private String goodsSn;

    private String goodsName;

    private Integer number;

    private BigDecimal price;

    private BigDecimal subtotal;

    private String goodsImg;

    private Map<String,String> specAndValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Map<String, String> getSpecAndValue() {
        return specAndValue;
    }

    public void setSpecAndValue(Map<String, String> specAndValue) {
        this.specAndValue = specAndValue;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
