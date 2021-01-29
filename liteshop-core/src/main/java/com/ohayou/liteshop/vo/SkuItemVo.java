package com.ohayou.liteshop.vo;

import com.ohayou.liteshop.dto.SpecAndValueDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/1/2 下午10:21
 */
public class SkuVo {

    private Long skuId;

    private BigDecimal price;

    private Integer stock;

    private boolean NoneSku;

    private Long collectionId;

    private List<Map<String,Object>> specs;

    private boolean hideStock;

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isNoneSku() {
        return NoneSku;
    }

    public void setNoneSku(boolean noneSku) {
        NoneSku = noneSku;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public List<Map<String, Object>> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Map<String, Object>> specs) {
        this.specs = specs;
    }

    public boolean isHideStock() {
        return hideStock;
    }

    public void setHideStock(boolean hideStock) {
        this.hideStock = hideStock;
    }
}
