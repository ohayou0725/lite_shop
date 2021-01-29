package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.validate.MobileValidate;
import org.hibernate.validator.constraints.Length;

/**
 * @author liyan
 * @date 2021/1/5 下午8:59
 */
public class MemberLoginFormDto {

    @MobileValidate
    private String mobile;

    @Length(min = 6,max = 16)
    private String password;

    private String captcha;

    private String captchaId;

    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(String captchaId) {
        this.captchaId = captchaId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
