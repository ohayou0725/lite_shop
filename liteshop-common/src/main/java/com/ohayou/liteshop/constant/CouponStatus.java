package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/10/5 下午3:45
 */
public enum CouponStatus {
    NORMAL(0,"正常"),
    EXPIRED(1,"过期"),
    OFF(2,"下架");

    private Integer status;

    private String desc;

    CouponStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static CouponStatus getCouponStatus(Integer status) {

        CouponStatus[] values = values();
        for (CouponStatus value : values) {
            if (value.status.equals(status)) {
                return value;
            }
        }
        return null;
    }

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
