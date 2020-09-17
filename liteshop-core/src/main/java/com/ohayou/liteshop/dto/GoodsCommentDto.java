package com.ohayou.liteshop.dto;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/9/14 下午4:05
 */
public class GoodsCommentDto {

    private Long id;


    private String userMobile;

    private Long goodsId;

    private String goodsSn;

    private String goodsTitle;


    private Integer score;


    private Map<String,String> specAndValue;

    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public Integer getScore() {
        return score;
    }



    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }



    public Map<String, String> getSpecAndValue() {
        return specAndValue;
    }

    public void setSpecAndValue(Map<String, String> specAndValue) {
        this.specAndValue = specAndValue;
    }
}
