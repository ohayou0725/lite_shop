package com.ohayou.liteshop.vo;

import com.ohayou.liteshop.validate.MobileValidate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

/**
 * @author liyan
 * @date 2021/1/10 下午2:23
 */
public class RegisterFormVo {

    @MobileValidate
    private String mobile;

    @Length(min = 6,max = 16,message = "密码必须为6-16位之间")
    private String password;

    private String confirmPassword;

    private String captchaId;

    private String captcha;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(String captchaId) {
        this.captchaId = captchaId;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
