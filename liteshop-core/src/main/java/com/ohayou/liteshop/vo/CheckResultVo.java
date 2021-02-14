package com.ohayou.liteshop.vo;

import java.math.BigDecimal;

/**
 * @author liyan
 * @date 2021/2/9 下午10:33
 */
public class CheckResultVo {

    private boolean success;

    private BigDecimal amount;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
