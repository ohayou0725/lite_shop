package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/11/24 下午9:52
 */
public class MemberUserTokenKey extends BaseKey{
    public MemberUserTokenKey() {
    }

    public MemberUserTokenKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public MemberUserTokenKey(String prefix) {
        super(prefix);
    }
}
