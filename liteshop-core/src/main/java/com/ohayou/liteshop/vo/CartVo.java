package com.ohayou.liteshop.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2021/2/7 下午9:34
 */
public class CartVo {
    private BigDecimal amount;

    private List<CartItemVo> list;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<CartItemVo> getList() {
        return list;
    }

    public void setList(List<CartItemVo> list) {
        this.list = list;
    }
}
