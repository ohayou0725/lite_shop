package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/2/20 下午10:02
 */
public class ConfirmOrderKey extends BaseKey{
    public ConfirmOrderKey() {
    }

    public ConfirmOrderKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public ConfirmOrderKey(String prefix) {
        super(prefix);
    }

    public ConfirmOrderKey(long expiration) {
        super(expiration);
    }
}
