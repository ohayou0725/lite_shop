package com.ohayou.liteshop.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

/**
 * @author liyan
 * @date 2020/8/12 下午1:59
 */
public class MallBrandDto {

    private Long id;

    @NotBlank(message = "品牌商名称不能为空")
    private String name;

    private String logo;

    private String introduction;

    private LocalDate joinTime;

    private List<ProductCategoryDto> categoryList;

    private List<Long> categoryIds;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<ProductCategoryDto> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<ProductCategoryDto> categoryDtoList) {
        this.categoryList = categoryDtoList;
    }

    public LocalDate getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDate joinTime) {
        this.joinTime = joinTime;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
