package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2021/1/16 下午4:56
 */
public class MemberGoodsAddress extends BaseKey{
    public MemberGoodsAddress() {
    }

    public MemberGoodsAddress(String prefix, long expiration) {
        super(prefix, expiration);
    }

    public MemberGoodsAddress(String prefix) {
        super(prefix);
    }

    public MemberGoodsAddress(long expiration) {
        super(expiration);
    }
}
