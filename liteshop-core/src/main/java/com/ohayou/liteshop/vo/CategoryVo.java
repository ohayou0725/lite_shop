package com.ohayou.liteshop.vo;

/**
 * @author liyan
 * @date 2020/11/26 下午9:18
 */
public class CategoryVo {

    private Long categoryId;

    private String icon;

    private String name;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
