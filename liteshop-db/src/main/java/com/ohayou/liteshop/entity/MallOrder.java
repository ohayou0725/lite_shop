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
 * 商品订单表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-29
 */
public class MallOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 售后状态，0是可申请，1是用户已申请，2是管理员审核通过，3是管理员退款成功，4是管理员审核拒绝，5是用户已取消
     */
    private Integer aftersaleStatus;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 收货人电话
     */
    private String mobile;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 留言
     */
    private String message;

    /**
     * 商品运费
     */
    private BigDecimal freightPrice;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 优惠券减免
     */
    private BigDecimal couponPrice;

    /**
     * 商品总价
     */
    private BigDecimal orderPrice;

    /**
     * 实付款
     */
    private BigDecimal actualPayment;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 支付id
     */
    private Long payId;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 发货编号
     */
    private String shipSn;

    /**
     * 快递公司
     */
    private String shipChannel;

    /**
     * 发货时间
     */
    private LocalDateTime shipTime;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 退款方式
     */
    private Integer refundType;

    /**
     * 退款备注
     */
    private String refundMessage;

    /**
     * 退款时间
     */
    private LocalDateTime refundTime;

    /**
     *申请售后时间
     */
    private LocalDateTime applyAfterSaleTime;

    /**
     * 用户确认收货时间
     */
    private LocalDateTime confirmTime;

    /**
     * 待评价商品数量
     */
    private Integer comments;

    /**
     * 订单关闭时间
     */
    private LocalDateTime endTime;

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
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getAftersaleStatus() {
        return aftersaleStatus;
    }

    public void setAftersaleStatus(Integer aftersaleStatus) {
        this.aftersaleStatus = aftersaleStatus;
    }
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }
    public String getShipSn() {
        return shipSn;
    }

    public void setShipSn(String shipSn) {
        this.shipSn = shipSn;
    }
    public String getShipChannel() {
        return shipChannel;
    }

    public void setShipChannel(String shipChannel) {
        this.shipChannel = shipChannel;
    }
    public LocalDateTime getShipTime() {
        return shipTime;
    }

    public void setShipTime(LocalDateTime shipTime) {
        this.shipTime = shipTime;
    }
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }
    public String getRefundMessage() {
        return refundMessage;
    }

    public void setRefundMessage(String refundMessage) {
        this.refundMessage = refundMessage;
    }
    public LocalDateTime getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(LocalDateTime refundTime) {
        this.refundTime = refundTime;
    }
    public LocalDateTime getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }
    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public LocalDateTime getApplyAfterSaleTime() {
        return applyAfterSaleTime;
    }

    public void setApplyAfterSaleTime(LocalDateTime applyAfterSaleTime) {
        this.applyAfterSaleTime = applyAfterSaleTime;
    }

    @Override
    public String toString() {
        return "MallOrder{" +
            "id=" + id +
            ", orderSn=" + orderSn +
            ", userId=" + userId +
            ", status=" + status +
            ", aftersaleStatus=" + aftersaleStatus +
            ", receiver=" + receiver +
            ", mobile=" + mobile +
            ", address=" + address +
            ", message=" + message +
            ", freightPrice=" + freightPrice +
            ", goodsPrice=" + goodsPrice +
            ", couponPrice=" + couponPrice +
            ", orderPrice=" + orderPrice +
            ", payId=" + payId +
            ", payTime=" + payTime +
            ", shipSn=" + shipSn +
            ", shipChannel=" + shipChannel +
            ", shipTime=" + shipTime +
            ", refundAmount=" + refundAmount +
            ", refundType=" + refundType +
            ", refundMessage=" + refundMessage +
            ", refundTime=" + refundTime +
            ", confirmTime=" + confirmTime +
            ", comments=" + comments +
            ", endTime=" + endTime +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
