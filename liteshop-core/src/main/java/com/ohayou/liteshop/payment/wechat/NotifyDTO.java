package com.ohayou.liteshop.payment.wechat;

/**
 * @author liyan
 * 微信支付回调
 * @date 2021/2/27 下午3:25
 */
public class NotifyDTO {
    // 1：支付成功
    private String return_code;
    // 金额。单位：分
    private String total_fee;
    // 用户端自主生成的订单号
    private String out_trade_no;
    // PAYJS 订单号
    private String payjs_order_id;
    // 微信用户手机显示订单号
    private String transaction_id;
    // 支付成功时间
    private String time_end;
    //
    private String openid;
    // 用户自定义数据
    private String attach;
    // 商户号
    private String mchid;
    //
    private String type;

    private String sign;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getPayjs_order_id() {
        return payjs_order_id;
    }

    public void setPayjs_order_id(String payjs_order_id) {
        this.payjs_order_id = payjs_order_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
