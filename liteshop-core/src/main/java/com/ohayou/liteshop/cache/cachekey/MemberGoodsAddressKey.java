package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/1/16 下午4:56
 */
public class MemberGoodsAddressKey extends BaseKey{
    public MemberGoodsAddressKey() {
    }

    public MemberGoodsAddressKey(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public MemberGoodsAddressKey(String prefix) {
        super(prefix);
    }

    public MemberGoodsAddressKey(long expiration) {
        super(expiration);
    }
}
