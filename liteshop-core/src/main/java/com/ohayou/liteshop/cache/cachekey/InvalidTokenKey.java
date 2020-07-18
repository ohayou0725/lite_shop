package com.ohayou.liteshop.cache.cachekey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liyan
 * @date 2020/7/16 下午10:43
 */

public class InvalidTokenKey extends BaseKey {



    public InvalidTokenKey() {

    }

    public InvalidTokenKey(String prefix) {
        super(prefix);
    }

    public InvalidTokenKey(String prefix, long expiration) {
        super(prefix, expiration);
    }


}
