package com.ohayou.liteshop.utils;

import java.util.List;

/**
 * @author liyan
 * @date 2020/8/21 下午10:00
 */
public class ListUtil {

    public static boolean equals(List aList, List bList) {

        if (aList == bList)
            return true;

        if (aList.size() != bList.size())
            return false;

        int n = aList.size();
        int i = 0;
        while (n-- != 0) {
            if (!aList.get(i).equals(bList.get(i)))
                return false;
            i++;
        }

        return true;
    }

}
