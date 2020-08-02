package com.ohayou.liteshop.dto;

import com.ohayou.validate.MobileValidate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * @author liyan
 * @date 2020/7/30 下午12:43
 */
public class MemAddrDto {

    private Long id;

    @MobileValidate
    private String mobile;

    private String receiver;

    @MobileValidate
    private String receiverMobile;

    private String area;

    private String memNickname;

    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMemNickname() {
        return memNickname;
    }

    public void setMemNickname(String memNickname) {
        this.memNickname = memNickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
