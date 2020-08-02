package com.ohayou.liteshop.dto;

import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/8/2 下午3:12
 */
public class MemOpinionDto {

    private Long id;

    private String mobile;

    private String nickName;

    private String content;

    private String opinionType;

    private String img;

    private LocalDateTime opinionTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDateTime getOpinionTime() {
        return opinionTime;
    }

    public void setOpinionTime(LocalDateTime opinionTime) {
        this.opinionTime = opinionTime;
    }
}
