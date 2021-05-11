package com.ohayou.liteshop.es;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2021/5/2 下午8:22
 */
@Document(indexName = "chatrecord",shards = 1,replicas = 0)
public class ChatRecord implements Serializable {

    @Id
    private String messageId;

    private String userMobile;

    private String userNickname;


    private String adminName;

    private Long adminId;

    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String content;

    private String type;

    private String src;

    private boolean ack;

    private boolean adminSend;

    private Long  orderId;


//    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }


    public Long getAdminId() {
        return adminId;
    }

    public boolean isAdminSend() {
        return adminSend;
    }

    public void setAdminSend(boolean adminSend) {
        this.adminSend = adminSend;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
