package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.validate.MobileValidate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author liyan
 * @date 2021/1/14 下午9:21
 */
public class AddressFormDto {


    private Long addressId;

    @NotEmpty(message = "收货人不能为空")
    private String receiver;

    @MobileValidate()
    private String receiverMobile;

    @NotEmpty(message = "收货区域不能为空")
    private String area;

    @NotEmpty(message = "邮政编码不能为空")
    private String postalCode;

    @NotEmpty(message = "地区代码不能为空")
    private String areaCode;

    @NotEmpty(message = "详细地址不能为空")
    private String address;

    private boolean defaultAddress;

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
