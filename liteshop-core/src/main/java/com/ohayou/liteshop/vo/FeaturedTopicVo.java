package com.ohayou.liteshop.vo;

import java.math.BigDecimal;

/**
 * @author liyan
 * @date 2020/11/28 下午9:32
 */
public class FeaturedTopicVo {

    private Long topicId;

    private String img;

    private String title;

    private BigDecimal price;

    private Integer goodsCount;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
}
