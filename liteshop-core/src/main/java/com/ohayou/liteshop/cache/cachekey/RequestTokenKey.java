package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/2/22 下午9:48
 */
public class RequestTokenKey extends BaseKey{
    public RequestTokenKey() {
    }

    public RequestTokenKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public RequestTokenKey(String prefix) {
        super(prefix);
    }

    public RequestTokenKey(long expiration) {
        super(expiration);
    }
}
