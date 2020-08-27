package com.ohayou.liteshop.utils;

import java.util.*;

/**
 * @author liyan
 * @date 2020/8/18 下午10:51
 */
public class GoodsSpecUtil {


    //解析sku规格和规格值
    public static Map<Long,Long> getSpecIdAndValueId(String goodsSn) {
        int index = goodsSn.lastIndexOf("#");
        String specAndValues = goodsSn.substring(index + 1, goodsSn.length());
        String[] specValueGroup = specAndValues.split("&");

        HashMap<Long, Long> map = new LinkedHashMap<>();
        for (int i = 0; i < specValueGroup.length; i++) {
            String specValue = specValueGroup[i];
            String[] split = specValue.split("-");
            map.put(Long.parseLong(split[0]),Long.parseLong(split[1]));
        }
        return map;
    }
}
