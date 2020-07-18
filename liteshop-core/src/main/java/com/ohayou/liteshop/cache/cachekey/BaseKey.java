package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/7/16 下午10:26
 */
public class BaseKey implements KeyPrefix{

    private String prefix;

    private long expiration;


    public BaseKey() {
    }

    public BaseKey(String prefix, long expiration) {
        this.prefix = prefix;
        this.expiration = expiration;
    }

    public BaseKey(String prefix) {
        this.prefix = prefix;
        this.expiration = 0;
    }



    @Override
    public String getPrefix() {
        return getClass().getSimpleName() + ":" + prefix.trim();
    }


    @Override
    public long expireSeconds() {
        return this.expiration;
    }

}
