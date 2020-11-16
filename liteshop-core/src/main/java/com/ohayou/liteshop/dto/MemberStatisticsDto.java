package com.ohayou.liteshop.dto;

import java.util.List;

/**
 * @author liyan
 * @date 2020/11/11 下午9:42
 */
public class MemberStatisticsDto {

    private Integer year;

    private Integer total;

    private List<MemberMonthStatisticsDto> memberMonthStatisticsDtos;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<MemberMonthStatisticsDto> getMemberMonthStatisticsDtos() {
        return memberMonthStatisticsDtos;
    }

    public void setMemberMonthStatisticsDtos(List<MemberMonthStatisticsDto> memberMonthStatisticsDtos) {
        this.memberMonthStatisticsDtos = memberMonthStatisticsDtos;
    }
}
