package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/3/12 下午9:41
 */
public class OrderPaymentKey extends BaseKey{
    public OrderPaymentKey() {
    }

    public OrderPaymentKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public OrderPaymentKey(String prefix) {
        super(prefix);
    }

    public OrderPaymentKey(long expiration) {
        super(expiration);
    }
}
