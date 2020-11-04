package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/10/25 上午11:05
 */
public enum  AdminRoleStatus {

    ENABLED("启用",1),
    DISABLED("停用",0);

    AdminRoleStatus(String desc, Integer status) {
        this.desc = desc;
        this.status = status;
    }

    private String desc;

    private Integer status;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
