package com.ohayou.liteshop.dto;

/**
 * @author liyan
 * @date 2020/11/12 下午2:15
 */
public class GoodsStatisticsDto {

    private Integer goodsTotal;

    private Integer onSaleCount;

    private Integer unSaleCount;

    public Integer getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(Integer goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public Integer getOnSaleCount() {
        return onSaleCount;
    }

    public void setOnSaleCount(Integer onSaleCount) {
        this.onSaleCount = onSaleCount;
    }

    public Integer getUnSaleCount() {
        return unSaleCount;
    }

    public void setUnSaleCount(Integer unSaleCount) {
        this.unSaleCount = unSaleCount;
    }
}
