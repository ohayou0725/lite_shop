package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/2/28 下午1:38
 */
public class GoodsLockKey extends BaseKey{
    public GoodsLockKey() {
    }

    public GoodsLockKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public GoodsLockKey(String prefix) {
        super(prefix);
    }

    public GoodsLockKey(long expiration) {
        super(expiration);
    }
}
