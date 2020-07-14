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
 * 订单设置表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-12
 */
public class SysOrderConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单配置id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单过期取消时间
     */
    private Integer expireTime;

    /**
     * 过期时间单位
     */
    private String timeUnit;

    /**
     * 订单发货后超期未确认收货天数后自动确认收货
     */
    private String confirmDays;

    /**
     * 超过天数未评论取消评论资格
     */
    private String commentDays;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

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
    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }
    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }
    public String getConfirmDays() {
        return confirmDays;
    }

    public void setConfirmDays(String confirmDays) {
        this.confirmDays = confirmDays;
    }
    public String getCommentDays() {
        return commentDays;
    }

    public void setCommentDays(String commentDays) {
        this.commentDays = commentDays;
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
        return "SysOrderConfig{" +
            "id=" + id +
            ", expireTime=" + expireTime +
            ", timeUnit=" + timeUnit +
            ", confirmDays=" + confirmDays +
            ", commentDays=" + commentDays +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
