package com.ohayou.liteshop.async.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

/**
 * @author liyan
 * @date 2021/2/4 下午9:29
 */
public class PriceChangeEvent extends ApplicationEvent {

    private Long skuId;

    private BigDecimal price;

    public PriceChangeEvent(Object source, Long skuId, BigDecimal price) {
        super(source);
        this.skuId = skuId;
        this.price = price;
    }

    public PriceChangeEvent(Object source) {
        super(source);
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
