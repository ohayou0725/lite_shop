package com.ohayou.liteshop.utils;

import java.util.*;

/**
 * @author liyan
 * @date 2020/8/18 下午10:51
 */
public class GoodsSpecUtil {


    //解析sku规格和规格值
    public static Map<Long,Long> getSpecIdAndValueId(String specSn) {
        try {
            int index = specSn.lastIndexOf("#");
            String specAndValues = specSn.substring(index + 1, specSn.length());
            String[] specValueGroup = specAndValues.split("&");

            HashMap<Long, Long> map = new LinkedHashMap<>();
            for (String specValue : specValueGroup) {
                String[] split = specValue.split("-");
                map.put(Long.parseLong(split[0]), Long.parseLong(split[1]));
            }
            return map;
        } catch (Exception e) {
            return null;
        }

    }

    //获取商品id
    public static Long getSpuIdBySpecSn(String specSn) {
        int i = specSn.lastIndexOf("#");
        String id = specSn.substring(0,i);
        try {
            return Long.parseLong(id);
        } catch (Exception e) {
            return null;
        }
    }

}
