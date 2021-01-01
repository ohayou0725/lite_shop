package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/12/3 上午10:47
 */
public class HotGoodsVoListKey extends BaseKey{
    public HotGoodsVoListKey() {
    }

    public HotGoodsVoListKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public HotGoodsVoListKey(String prefix) {
        super(prefix);
    }


}
