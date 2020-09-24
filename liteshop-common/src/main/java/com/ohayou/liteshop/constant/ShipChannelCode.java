package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/9/24 下午2:13
 * 快递公司编码
 */

public enum ShipChannelCode {
    SF("顺丰速运","SF"),
    YTO("圆通快递","YTO"),
    TTK("天天快读","TTK"),
    ZTO("中通快递","ZTO"),
    YD("韵达快递","YD");


    private String courier;

    private String code;

    ShipChannelCode(String courier, String code) {
        this.courier = courier;
        this.code = code;
    }

    public static ShipChannelCode getShipChannelCode(String shipChannel) {
        for (ShipChannelCode value : values()) {
            if (value.courier.equals(shipChannel)) {
                return value;
            }
        }
        return null;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
