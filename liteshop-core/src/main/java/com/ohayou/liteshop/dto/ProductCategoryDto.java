package com.ohayou.liteshop.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ohayou.liteshop.entity.MallGoodsAttr;

import javax.validation.constraints.Digits;

/**
 * @author liyan
 * @date 2020/8/3 下午10:50
 */

public class ProductCategoryDto {
    @Digits(message = "id必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Long id;

    private String name;

    private Integer level;
    @Digits(message = "父级分类id必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Long parentId;
    @Digits(message = "排序号必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Integer sort;

    private String icon;

    private String img;

    private LocalDateTime createTime;

    private List<GoodsAttrDto> attrs;

    private List<ProductCategoryDto> children;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<ProductCategoryDto> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategoryDto> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<GoodsAttrDto> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<GoodsAttrDto> attrs) {
        this.attrs = attrs;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
