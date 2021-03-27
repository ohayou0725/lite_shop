package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/9/21 下午10:35
 */
public enum PayType {
    WECHAT("微信支付",1,"wxpay"),
    ALIPAY("支付宝支付",2,"alipay"),
    UNPAID("",0,"");


    private String description;

    private Integer type;

    private String payMethod;



    PayType(String description, Integer type, String payMethod) {
        this.description = description;
        this.type = type;
        this.payMethod = payMethod;
    }

    public static PayType getPayType(int type) {
        PayType[] values = values();
        for (PayType value : values) {
            if (value.getType().equals(type)) {
                return value;
            }
        }
        return PayType.UNPAID;
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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
}
