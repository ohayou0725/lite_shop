package com.ohayou.liteshop.utils;


import java.text.NumberFormat;

/**
 * @author liyan
 * @date 2021/1/2 下午1:03
 */
public class RateUtil {

    public static String getRate(int score, int totalScore) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format((float)score/(float)totalScore*100) + "%";
    }
}
