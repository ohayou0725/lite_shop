package com.ohayou.liteshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户操作日志表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public class AdminLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 管理员名
     */
    private String admin;

    /**
     * 登录IP地址
     */
    private String ip;

    /**
     * 操作动作
     */
    private String action;

    /**
     *  操作状态 1-成功 0-失败
     */
    private Integer status;

    /**
     * 操作结果
     */
    private String result;

    /**
     * 补充信息
     */
    private String comment;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
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

    @Override
    public String toString() {
        return "AdminLog{" +
            "id=" + id +
            ", admin=" + admin +
            ", ip=" + ip +
            ", action=" + action +
            ", status=" + status +
            ", result=" + result +
            ", comment=" + comment +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
