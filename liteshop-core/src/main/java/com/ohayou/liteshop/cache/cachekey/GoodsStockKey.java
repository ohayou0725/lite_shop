package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/2/28 上午11:37
 */
public class GoodsStockKey extends BaseKey{
    public GoodsStockKey() {
    }

    public GoodsStockKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public GoodsStockKey(String prefix) {
        super(prefix);
    }

    public GoodsStockKey(long expiration) {
        super(expiration);
    }
}
