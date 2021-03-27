package com.ohayou.liteshop.utils;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @author liyan
 * @date 2021/3/11 下午12:41
 */
public class MD5SignUtil {

    public static String createSign(SortedMap parameters,String key){
        StringBuffer sb = new StringBuffer();

        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序(升序)

        Iterator it = es.iterator();

        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();

            String k = (String)entry.getKey();

            Object v = entry.getValue();

            if(null != v && !"".equals(v)

                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");

            }

        }
        String substring = sb.substring(0, sb.length()-1);
        substring = substring + (key);



        String sign = md5Password(substring).toLowerCase();

        return sign;

    }

    /**

     * 生成32位md5码

     *

     * @param key

     * @return

     */

    public static String md5Password(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'

        };

        try {
            byte[] btInput = key.getBytes();

// 获得MD5摘要算法的 MessageDigest 对象

            MessageDigest mdInst = MessageDigest.getInstance("MD5");

// 使用指定的字节更新摘要

            mdInst.update(btInput);

// 获得密文

            byte[] md = mdInst.digest();

// 把密文转换成十六进制的字符串形式

            int j = md.length;

            char str[] = new char[j * 2];

            int k = 0;

            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];

                str[k++] = hexDigits[byte0 >>> 4 & 0xf];

                str[k++] = hexDigits[byte0 & 0xf];

            }

            return new String(str);

        } catch (Exception e) {
            return null;

        }

    }

}
