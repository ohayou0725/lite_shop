package com.ohayou.liteshop.utils;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.SecureUtil;

import java.math.BigInteger;

/**
 * @author liyan
 * @date 2021/1/5 下午9:57
 */
public class TokenUtil {

    public static String generateToken(String str) {
        StringBuilder s = new StringBuilder(new BigInteger(1, str.getBytes()).toString(16));
        for (int i = 0; i < 32 - s.length(); i++) {
            s.insert(0, "0");
        }
        return SecureUtil.md5(s.toString());
    }
}
