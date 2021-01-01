package com.ohayou.liteshop.vo;

import java.util.List;

/**
 * @author liyan
 * @date 2020/12/3 下午3:12
 */
public class CategoryItemVo {

    private Long id;

    private String text;

    private String img;

    private Integer hot;

    private Integer level;

    private List<CategoryItemVo> children;

    public List<CategoryItemVo> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryItemVo> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
