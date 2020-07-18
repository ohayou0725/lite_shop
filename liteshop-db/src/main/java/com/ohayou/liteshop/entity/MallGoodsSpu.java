package com.ohayou.liteshop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品spu信息表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public class MallGoodsSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品sku_id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品编号
     */
    private Long goodsSn;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 商品简要
     */
    private String brief;

    /**
     * 标题图片
     */
    private String titleImg;

    /**
     * 商品轮播图片列表
     */
    private String gallery;

    /**
     * 商品状态0-未上架 1-已上架
     */
    private Integer status;

    /**
     * 是否热卖 0-否 1-是
     */
    private Integer hot;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否新品 0-否 1-是
     */
    private Integer isNew;

    /**
     * 商品单位
     */
    private String unit;

    /**
     * 商品零售价格
     */
    private BigDecimal price;

    /**
     * 商品折扣价格
     */
    private BigDecimal discountPrice;

    /**
     * 参数分组id
     */
    private Long attrGroupId;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(Long goodsSn) {
        this.goodsSn = goodsSn;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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
    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "MallGoodsSpu{" +
            "id=" + id +
            ", goodsSn=" + goodsSn +
            ", name=" + name +
            ", categoryId=" + categoryId +
            ", brandId=" + brandId +
            ", brief=" + brief +
            ", titleImg=" + titleImg +
            ", gallery=" + gallery +
            ", status=" + status +
            ", hot=" + hot +
            ", sort=" + sort +
            ", isNew=" + isNew +
            ", unit=" + unit +
            ", price=" + price +
            ", discountPrice=" + discountPrice +
            ", attrGroupId=" + attrGroupId +
            ", detail=" + detail +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
