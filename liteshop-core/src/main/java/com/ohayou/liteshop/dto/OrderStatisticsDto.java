package com.ohayou.liteshop.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author liyan
 * @date 2020/11/14 下午9:39
 */
public class OrderStatisticsDto {

    private BigDecimal amount;

    private Integer count;

    private LocalDate orderDate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
