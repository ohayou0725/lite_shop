package com.ohayou.liteshop.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author liyan
 * @date 2020/7/28 下午9:57
 */
public class DateTimeUtil {

    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static String SQL_DATE_FORMAT = "'%Y-%m-%d'";

    public static String formatForSql(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }
        return DateTimeFormatter.ofPattern(DATE_FORMAT).format(localDate);
    }

    public static String sqlDateFormat(String field) {
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append("date_format(")
                    .append(field)
                    .append(", ")
                    .append(SQL_DATE_FORMAT)
                    .append(")").toString();
    }
}
