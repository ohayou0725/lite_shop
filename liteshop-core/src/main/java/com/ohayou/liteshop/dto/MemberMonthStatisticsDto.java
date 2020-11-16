package com.ohayou.liteshop.dto;

import java.util.List;

/**
 * @author liyan
 * @date 2020/11/11 下午2:59
 */
public class MemberMonthStatisticsDto {


    private String month;

    private Integer increment;

    private Integer total;




    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
