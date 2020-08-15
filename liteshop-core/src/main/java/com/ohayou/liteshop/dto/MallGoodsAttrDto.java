package com.ohayou.liteshop.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * @author liyan
 * @date 2020/8/8 下午10:22
 */
public class MallGoodsAttrDto {

    @Digits(message = "id必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Long id;

    @NotBlank(message = "属性名不能为空")
    private String attrName;

    @Digits(message = "排序号必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Integer sort;

    @Digits(message = "分类id必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MallGoodsAttrDto)) return false;
        MallGoodsAttrDto that = (MallGoodsAttrDto) o;
        return Objects.equals(attrName, that.attrName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attrName, sort, categoryId);
    }
}
