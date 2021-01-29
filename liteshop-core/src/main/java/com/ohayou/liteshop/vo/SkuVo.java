package com.ohayou.liteshop.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/1/3 上午10:57
 */
public class SkuVo {

    List<SpecVo> tree;

    List<Map<String,Object>> list;

    private boolean hideStock;

    private boolean NoneSku;

    private Long collectionId;

    private String price;

    private Integer totalStock;

    public List<SpecVo> getTree() {
        return tree;
    }

    public void setTree(List<SpecVo> tree) {
        this.tree = tree;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    public boolean isHideStock() {
        return hideStock;
    }

    public void setHideStock(boolean hideStock) {
        this.hideStock = hideStock;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }
}
