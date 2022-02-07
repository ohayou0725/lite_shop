package com.ohayou.liteshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ohayou
 * @since 2021-05-13
 */
public class ChatRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户手机
     */
    private String userMobile;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 管理员名称
     */
    private String adminName;

    /**
     * 管理员Id
     */
    private Long adminId;

    /**
     * 正文
     */
    private String content;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 图片链接
     */
    private String src;

    /**
     * 是否收到消息
     */
    private Integer ack;

    /**
     * 是否为客服人员发送
     */
    private Integer adminSend;

    /**
     * 订单Id
     */
    private Long orderId;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

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
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
    public Integer getAck() {
        return ack;
    }

    public void setAck(Integer ack) {
        this.ack = ack;
    }
    public Integer getAdminSend() {
        return adminSend;
    }

    public void setAdminSend(Integer adminSend) {
        this.adminSend = adminSend;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "ChatRecord{" +
            "id=" + id +
            ", userMobile=" + userMobile +
            ", userNickname=" + userNickname +
            ", adminName=" + adminName +
            ", adminId=" + adminId +
            ", content=" + content +
            ", type=" + type +
            ", src=" + src +
            ", ack=" + ack +
            ", adminSend=" + adminSend +
            ", orderId=" + orderId +
            ", sendTime=" + sendTime +
            ", deleted=" + deleted +
        "}";
    }
}
