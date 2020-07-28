package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/7/25 下午10:18
 */
public class AdminUserDetailsKey extends BaseKey{
    public AdminUserDetailsKey() {
    }

    public AdminUserDetailsKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public AdminUserDetailsKey(String prefix) {
        super(prefix);
    }
}
