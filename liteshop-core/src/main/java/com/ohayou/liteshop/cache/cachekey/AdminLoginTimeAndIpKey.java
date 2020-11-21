package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/11/19 下午4:23
 */
public class AdminLoginTimeAndIpKey extends BaseKey{


    public AdminLoginTimeAndIpKey() {
    }

    public AdminLoginTimeAndIpKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public AdminLoginTimeAndIpKey(String prefix) {
        super(prefix);
    }
}
