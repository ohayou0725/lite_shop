package com.ohayou.liteshop.vo;

import com.ohayou.liteshop.dto.SpecAndValueDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/1/2 下午10:21
 */
public class SkuItemVo {

    private Long skuId;


    private BigDecimal price;


    private Integer stock;

    Map<String,Object> specsAndValue;

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

    public Map<String, Object> getSpecsAndValue() {
        return specsAndValue;
    }

    public void setSpecsAndValue(Map<String, Object> specsAndValue) {
        this.specsAndValue = specsAndValue;
    }
}
