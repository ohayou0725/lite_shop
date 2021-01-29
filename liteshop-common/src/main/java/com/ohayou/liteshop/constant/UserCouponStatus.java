package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2021/1/27 下午9:46
 */
public enum UserCouponStatus {
    AVAILABLE(0,"可用"),
    UNAVAILABLE(1,"不可用"),
    EXPIRED(2,"已过期");


    UserCouponStatus(Integer status, String desc) {
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
