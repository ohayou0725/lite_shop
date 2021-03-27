package com.ohayou.liteshop.payment.wechat;

/**
 * @author liyan
 * @date 2021/2/27 下午12:57
 */
public class PayReturnDTO {

    private Integer return_code;

    private String return_msg;

    private String payjs_order_id;

    private String out_trade_no;

    private Integer total_fee;

    private String h5_url;

    private String sign;

    public Integer getReturn_code() {
        return return_code;
    }

    public void setReturn_code(Integer return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getPayjs_order_id() {
        return payjs_order_id;
    }

    public void setPayjs_order_id(String payjs_order_id) {
        this.payjs_order_id = payjs_order_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public String getH5_url() {
        return h5_url;
    }

    public void setH5_url(String h5_url) {
        this.h5_url = h5_url;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
