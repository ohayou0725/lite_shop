package com.ohayou.liteshop.vo;

/**
 * @author liyan
 * @date 2020/11/26 下午1:41
 */
public class BannerVo {

    private Long topicId;

    private String img;

    private boolean isShow;

    private Integer sort;

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

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
