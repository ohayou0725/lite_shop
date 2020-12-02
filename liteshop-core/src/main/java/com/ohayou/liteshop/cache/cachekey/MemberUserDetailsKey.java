package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/11/24 下午10:02
 */
public class MemberUserDetailsKey extends BaseKey{
    public MemberUserDetailsKey() {
    }

    public MemberUserDetailsKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public MemberUserDetailsKey(String prefix) {
        super(prefix);
    }
}
