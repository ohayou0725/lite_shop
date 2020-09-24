package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/9/21 下午10:35
 */
public enum PayType {
    WECHAT("微信支付",1),
    ALIPAY("支付宝支付",2);


    private String description;

    private Integer type;

    PayType(String description, Integer type) {
        this.description = description;
        this.type = type;
    }

    public static PayType getPayType(int type) {
        PayType[] values = values();
        for (PayType value : values) {
            if (value.getType().equals(type)) {
                return value;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
