package com.ohayou.liteshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ohayou.liteshop.entity.MallCouponType;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/10/3 下午9:26
 */
public class CouponDto {

    public interface AddCoupon {};

    public interface UpdateCoupon {};

    @Min(value = 0,message = "id不合法",groups = UpdateCoupon.class)
    @Max(value = Long.MAX_VALUE,message = "id不合法",groups = UpdateCoupon.class)
    private Long id;

    @NotBlank(message = "优惠券名不能为空",groups = AddCoupon.class)
    private String name;

    @NotBlank(message = "优惠券介绍不能为空",groups = AddCoupon.class)
    private String detail;

    private Integer total;

    @NotNull(message = "减免金额不能为空",groups = AddCoupon.class)
    @Digits(integer = Integer.MAX_VALUE,fraction = 2,groups = AddCoupon.class)
    private BigDecimal discount;

    @NotNull(message = "最低消费金额不能为空")
    @Digits(integer = Integer.MAX_VALUE,fraction = 2,groups = AddCoupon.class)
    private BigDecimal min;

    private Integer stint;

    private Integer status;

    private Integer type;

    private Integer days;

    private Integer timeType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    private MallCouponType couponType;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    public MallCouponType getCouponType() {
        return couponType;
    }

    public void setCouponType(MallCouponType couponType) {
        this.couponType = couponType;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }
}
