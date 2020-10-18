package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/10/5 下午3:32
 */
public enum CouponType {
    ALL(0,"全品券"),
    CATE(1,"类目券"),
    GOODS(2,"单品券"),
    BRAND(3,"品牌券")
    ;

    private Integer code;

    private String desc;

    CouponType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CouponType getCouponType(Integer code) {
        CouponType[] values = values();
        for (CouponType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
