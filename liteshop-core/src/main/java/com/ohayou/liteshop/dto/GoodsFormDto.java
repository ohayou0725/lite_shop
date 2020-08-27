package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.entity.MallGoodsSpec;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2020/8/21 下午8:03
 */
public class GoodsFormDto {

    private Long id;

    @NotBlank(message = "必须输入商品编号")
    private String goodsSn;

    @NotBlank(message = "必须输入商品名")
    private String name;

    @NotBlank(message = "必须输入商品简介")
    private String brief;

    @NotNull(message = "分类id不能为空")
    @Digits(message = "分类id必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Long categoryId;

    @NotNull(message = "品牌id不能为空")
    @Digits(message = "品牌id必须为数字",integer = Integer.MAX_VALUE, fraction = 0 )
    private Long brandId;

    private String title;

    private String titleImg;

    private String gallery;

    private Integer status;

    private Integer sales;

    private Integer hot;

    private Integer isNew;

    private String unit;

    private BigDecimal price;

    private Integer sort;

    private BigDecimal discountPrice;

    private String detail;

    private List<AttrValueDto> attrValues;

    private List<MallGoodsSpec> specs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<AttrValueDto> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<AttrValueDto> attrValues) {
        this.attrValues = attrValues;
    }

    public List<MallGoodsSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<MallGoodsSpec> specs) {
        this.specs = specs;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
