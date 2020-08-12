package com.ohayou.liteshop.dto;



import java.time.LocalDate;
import com.ohayou.liteshop.validate.*;
import com.ohayou.liteshop.validate.Number;

/**
 * @author liyan
 * @date 2020/7/24 下午10:59
 */


public class MemUserDto {
    private Long id;

    private String nickname;

    @MobileValidate
    private String mobile;

    private String gender;

    private String rank;
    @Number
    private String status;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
