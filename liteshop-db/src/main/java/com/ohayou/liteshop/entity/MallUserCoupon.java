package com.ohayou.liteshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户优惠券
 * </p>
 *
 * @author ohayou
 * @since 2020-07-29
 */
public class MallUserCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户优惠券id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 优惠券状态 0-可用 1-不可用 2-已过期
     */
    private Integer status;

    /**
     * 优惠券数量
     */
    private Integer number;

    /**
     * 已使用订单id
     */
    private Long orderId;

    private LocalDateTime creteTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getCreteTime() {
        return creteTime;
    }

    public void setCreteTime(LocalDateTime creteTime) {
        this.creteTime = creteTime;
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
        return "MallUserCoupon{" +
            "id=" + id +
            ", userId=" + userId +
            ", couponId=" + couponId +
            ", status=" + status +
            ", number=" + number +
            ", orderId=" + orderId +
            ", creteTime=" + creteTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
