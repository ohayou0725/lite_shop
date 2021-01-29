package com.ohayou.liteshop.vo;

import com.ohayou.liteshop.dto.CommentDetailDto;
import com.ohayou.liteshop.entity.MallGoodsComment;

import java.util.List;

/**
 * @author liyan
 * @date 2021/1/1 下午9:42
 */
public class CommentVo {


    private Long goodsId;

    private Integer num;

    private String rate;

    private String[] tags;

    private List<CommentItemVo> list;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public List<CommentItemVo> getList() {
        return list;
    }

    public void setList(List<CommentItemVo> list) {
        this.list = list;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
