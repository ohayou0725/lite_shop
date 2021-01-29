package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/1/4 下午9:36
 */
public class CaptchaKey extends BaseKey{
    public CaptchaKey() {
    }

    public CaptchaKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public CaptchaKey(String prefix) {
        super(prefix);
    }

    public CaptchaKey(long expiration) {
        super(expiration);
    }
}
