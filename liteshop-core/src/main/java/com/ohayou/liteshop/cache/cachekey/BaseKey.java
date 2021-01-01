package com.ohayou.liteshop.cache.cachekey;

import org.apache.commons.lang3.StringUtils;

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
        if (StringUtils.isNotBlank(prefix)) {
            return getClass().getSimpleName() + ":" + prefix.trim();
        }
        return getClass().getSimpleName();
    }


    @Override
    public long expireSeconds() {
        return this.expiration;
    }

}
