package com.ohayou.liteshop.dto;

import com.ohayou.validate.Number;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/7/31 下午10:28
 */
public class MemCollectDto {

    private Long id;

    private String mobile;

    @Number
    private String spuSn;

    private LocalDateTime JoinTime;

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

    public LocalDateTime getJoinTime() {
        return JoinTime;
    }

    public void setJoinTime(LocalDateTime joinTime) {
        JoinTime = joinTime;
    }
}
