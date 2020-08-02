package com.ohayou.liteshop.dto;

import com.ohayou.validate.MobileValidate;
import com.ohayou.validate.Number;

import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/8/2 上午10:45
 */
public class MemHistoryDto {

    private Long id;

    @MobileValidate
    private String mobile;

    @Number
    private String spuSn;

    private LocalDateTime browserTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSpuSn() {
        return spuSn;
    }

    public void setSpuSn(String spuSn) {
        this.spuSn = spuSn;
    }

    public LocalDateTime getBrowserTime() {
        return browserTime;
    }

    public void setBrowserTime(LocalDateTime browserTime) {
        this.browserTime = browserTime;
    }
}
