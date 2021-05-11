package com.ohayou.liteshop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 订单商品表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-29
 */
public class MallOrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * skuId
     */
    private Long SkuId;

    /**
     * 商品编号
     */
    private String goodsSn;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 购买数量
     */
    private Integer number;

    /**
     * 商品售价
     */
    private BigDecimal price;


    /**
     * 商品小计
     */
    private BigDecimal subtotal;

    /**
     * 商品规格码
     */
    private String goodsSpecSn;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 订单商品评论，如果是-1，则超期不能评价；如果是0，则可以评价；如果其他值，则是comment表里面的评论ID。
     */
    private Long comment;

    /**
     * 是否申请退款
     */
    private Integer applyRefund;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最近修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getGoodsSpecSn() {
        return goodsSpecSn;
    }

    public void setGoodsSpecSn(String goodsSpecSn) {
        this.goodsSpecSn = goodsSpecSn;
    }
    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
    public Long getComment() {
        return comment;
    }

    public void setComment(Long comment) {
        this.comment = comment;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getApplyRefund() {
        return applyRefund;
    }

    public void setApplyRefund(Integer applyRefund) {
        this.applyRefund = applyRefund;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Long getSkuId() {
        return SkuId;
    }

    public void setSkuId(Long skuId) {
        SkuId = skuId;
    }

    @Override
    public String toString() {
        return "MallOrderGoods{" +
            "id=" + id +
            ", orderId=" + orderId +
            ", goodsSn=" + goodsSn +
            ", goodsName=" + goodsName +
            ", number=" + number +
            ", price=" + price +
            ", goodsSpecSn=" + goodsSpecSn +
            ", goodsImg=" + goodsImg +
            ", comment=" + comment +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
