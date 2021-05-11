package com.ohayou.liteshop.vo;

import com.ohayou.liteshop.es.ChatRecord;

import java.util.List;

/**
 * @author liyan
 * @date 2021/5/4 下午9:23
 */
public class UserMessageVo {

    private String userMobile;

    private String userNickname;

    private String avatar;

    private Long UnReadCount;

    private List<ChatRecord>  records;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getUnReadCount() {
        return UnReadCount;
    }

    public void setUnReadCount(Long unReadCount) {
        UnReadCount = unReadCount;
    }

    public List<ChatRecord> getRecords() {
        return records;
    }

    public void setRecords(List<ChatRecord> records) {
        this.records = records;
    }
}
