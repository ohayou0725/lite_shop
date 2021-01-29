package com.ohayou.liteshop.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;

/**
 * @author liyan
 * @date 2021/1/4 下午9:12
 */
public class LoginCaptchaUtil {

    public static ICaptcha createCaptcha() {
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.setGenerator(randomGenerator);
        lineCaptcha.createCode();
        return lineCaptcha;
    }

    public static boolean verify(String captcha, String inputCaptcha) {
        return captcha.equals(inputCaptcha);
    }
}
