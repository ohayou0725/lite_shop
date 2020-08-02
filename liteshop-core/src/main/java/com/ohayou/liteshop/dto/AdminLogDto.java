package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.validate.Number;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/7/25 下午7:59
 */

public class AdminLogDto {

    private String admin;

    private String ip;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate operatingTime;

    private String action;

    @Number
    private String status;

    private String result;

    private String comment;

    private LocalDateTime createTime;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDate getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(LocalDate operatingTime) {
        this.operatingTime = operatingTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
