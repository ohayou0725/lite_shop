package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.entity.MallGoodsSpec;
import com.ohayou.liteshop.entity.MallGoodsSpecValue;

import java.util.List;

/**
 * @author liyan
 * @date 2020/9/5 上午9:11
 */
public class MallGoodsSpecDto {

    private Long goodsId;

    private String title;

    private MallGoodsSpec spec;

    private List<MallGoodsSpecValue> values;

    public MallGoodsSpec getSpec() {
        return spec;
    }

    public void setSpec(MallGoodsSpec spec) {
        this.spec = spec;
    }

    public List<MallGoodsSpecValue> getValues() {
        return values;
    }

    public void setValues(List<MallGoodsSpecValue> values) {
        this.values = values;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
