package com.ohayou.liteshop.cache.cachekey;

/**
 * @author liyan
 * @date 2020/7/16 下午10:28
 */
public interface KeyPrefix {

    String getPrefix();

    long expireSeconds();
}
