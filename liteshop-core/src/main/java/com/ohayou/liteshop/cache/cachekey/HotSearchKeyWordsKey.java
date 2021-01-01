package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/12/5 下午10:31
 */
public class HotSearchKeyWordsKey extends BaseKey{
    public HotSearchKeyWordsKey() {
    }

    public HotSearchKeyWordsKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public HotSearchKeyWordsKey(String prefix) {
        super(prefix);
    }
}
