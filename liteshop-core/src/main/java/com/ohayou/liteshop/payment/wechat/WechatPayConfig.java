package com.ohayou.liteshop.payment.wechat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * @author liyan
 * @date 2021/2/27 上午11:15
 */
@Configuration
public class WechatPayConfig {

    //商户号
    @Value(value = "${payment.wechat.mchid}")
    private String mchid;
    //秘钥
    @Value(value = "${payment.wechat.key}")
    private String key;
    //H5支付Api地址
    @Value(value = "${payment.wechat.mwebUrl}")
    private String mwebUrl;

    @Value(value = "${payment.wechat.refundUrl}")
    private String refundUrl;

    //回调地址
    @Value(value = "${payment.wechat.notifyUrl}")
    private String notifyUrl;

    @Value(value = "${payment.wechat.openId}")
    private String openId;

    @Value(value = "${payment.wechat.callbackUrl}")
    private String callbackUrl;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public void setMwebUrl(String mwebUrl) {
        this.mwebUrl = mwebUrl;
    }

    public String getRefundUrl() {
        return refundUrl;
    }

    public void setRefundUrl(String refundUrl) {
        this.refundUrl = refundUrl;
    }
}
