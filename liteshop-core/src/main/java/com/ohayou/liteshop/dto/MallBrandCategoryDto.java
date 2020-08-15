package com.ohayou.liteshop.dto;

import javax.validation.constraints.NotNull;

/**
 * @author liyan
 * @date 2020/8/15 上午10:09
 */
public class MallBrandCategoryDto {

    @NotNull(message = "品牌商ID不能为空")
    private Long brandId;

    @NotNull(message = "分类ID不能为空")
    private Long categoryId;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
