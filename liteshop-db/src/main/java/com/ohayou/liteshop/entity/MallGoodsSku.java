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
 * 商品sku信息表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public class MallGoodsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品sku_id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品spu_id
     */
    private Long goodsId;

    /**
     * 单品价格
     */
    private BigDecimal price;

    /**
     * 单品库存
     */
    private Integer stock;

    /**
     * 单品图片地址
     */
    private String img;

    /**
     * 商品规格信息编码 例 $1#1-1&2-2&3-3
     */
    private String specSn;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getSpecSn() {
        return specSn;
    }

    public void setSpecSn(String specSn) {
        this.specSn = specSn;
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
        return "MallGoodsSku{" +
            "id=" + id +
            ", goodsId=" + goodsId +
            ", price=" + price +
            ", stock=" + stock +
            ", img=" + img +
            ", specSn=" + specSn +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
