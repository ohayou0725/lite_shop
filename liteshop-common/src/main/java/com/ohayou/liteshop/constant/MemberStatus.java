package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/7/30 上午10:09
 */
public enum  MemberStatus {

    ENABLED("正常",1),
    DISABLED("禁用",0);

    private String statusDesc;

    private Integer status;

    MemberStatus(String statusDesc, Integer status) {
        this.statusDesc = statusDesc;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
