package com.ohayou.liteshop.payment.wechat;

/**
 * @author liyan
 * @date 2021/3/30 下午10:37
 */
public class RefundReturnDto {

    private Integer return_code;

    private String return_msg;

    private String payjs_order_id;

    private String out_trade_no;

    private String transaction_id;

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

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
