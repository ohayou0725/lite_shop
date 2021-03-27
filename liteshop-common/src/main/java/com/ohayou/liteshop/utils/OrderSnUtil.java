package com.ohayou.liteshop.utils;

import cn.hutool.core.util.RandomUtil;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

/**
 * @author liyan
 * @date 2021/2/20 下午10:07
 */
public class OrderSnUtil {

    public static String generateOrderSn() {
        LocalDate now = LocalDate.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return format.replace("-","") + String.valueOf(System.currentTimeMillis()).substring(9,12) + RandomUtil.randomNumbers(4);
    }


}
