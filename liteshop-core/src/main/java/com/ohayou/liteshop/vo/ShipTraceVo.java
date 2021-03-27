package com.ohayou.liteshop.vo;

import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/3/22 下午10:19
 */
public class ShipTraceVo {

    private String shipSn;

    private String shipChannel;

    private String receiver;

    private String logo;

    private String mobile;

    private String address;

    private List<Map<String, String>> content;


    public String getShipSn() {
        return shipSn;
    }

    public void setShipSn(String shipSn) {
        this.shipSn = shipSn;
    }

    public String getShipChannel() {
        return shipChannel;
    }

    public void setShipChannel(String shipChannel) {
        this.shipChannel = shipChannel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Map<String, String>> getContent() {
        return content;
    }

    public void setContent(List<Map<String, String>> content) {
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

