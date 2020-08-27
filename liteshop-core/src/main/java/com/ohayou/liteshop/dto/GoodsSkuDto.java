package com.ohayou.liteshop.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2020/8/18 下午3:36
 */
public class GoodsSkuDto {
    private Long skuId;

    List<SpecAndValueDto> specAndValueList;

    private Integer stock;

    private Integer stockWarningCount;

    private BigDecimal price;

    private String img;

    private String specSn;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<SpecAndValueDto> getSpecAndValueList() {
        return specAndValueList;
    }

    public void setSpecAndValueList(List<SpecAndValueDto> specAndValueList) {
        this.specAndValueList = specAndValueList;
    }

    public String getSpecSn() {
        return specSn;
    }

    public void setSpecSn(String specSn) {
        this.specSn = specSn;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getStockWarningCount() {
        return stockWarningCount;
    }

    public void setStockWarningCount(Integer stockWarningCount) {
        this.stockWarningCount = stockWarningCount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
