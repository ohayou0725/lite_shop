package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/10/19 上午11:24
 */
public enum AdminUserStatus {


    NORMAL(0,"正常"),
    DISABLE(1,"已停用"),
    LOCKED(2,"已锁定");

    AdminUserStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private Integer status;

    private String desc;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
