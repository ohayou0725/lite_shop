package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.entity.MallGoodsSpu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/10/5 下午2:59
 */
public class CouponDetailDto {

    private Long id;

    private String name;

    private String detail;

    private Integer total;

    private BigDecimal discount;

    private BigDecimal min;

    private Integer stint;

    private String status;

    private String type;

    private Integer days;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private List<MallGoodsSpu> goodsList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public Integer getStint() {
        return stint;
    }

    public void setStint(Integer stint) {
        this.stint = stint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<MallGoodsSpu> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<MallGoodsSpu> goodsList) {
        this.goodsList = goodsList;
    }
}
