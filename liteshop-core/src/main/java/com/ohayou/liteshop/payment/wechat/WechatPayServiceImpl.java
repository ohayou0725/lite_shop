package com.ohayou.liteshop.payment.wechat;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.cache.cachekey.OrderPaymentKey;
import com.ohayou.liteshop.cache.cachekey.RequestTokenKey;
import com.ohayou.liteshop.constant.PayType;
import com.ohayou.liteshop.payment.PayService;
import com.ohayou.liteshop.security.SecurityUtil;
import com.ohayou.liteshop.utils.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author liyan
 * @date 2021/2/27 上午11:27
 */
@Service
public class WechatPayServiceImpl implements PayService {

    @Autowired
    WechatPayConfig wechatPayConfig;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public String pay(BigDecimal totalPrice, String orderSn, PayType payType) {
        Map<String,Object> payData = new HashMap<>();
        payData.put("mchid", wechatPayConfig.getMchid());
        payData.put("total_fee", '1');
//        payData.put("total_fee", totalPrice.multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
        payData.put("out_trade_no", orderSn); // 订单号
        payData.put("body","订单号：" + orderSn);
        payData.put("notify_url", wechatPayConfig.getNotifyUrl());
        payData.put("callback_url",wechatPayConfig.getCallbackUrl());
        String token = UUID.randomUUID().toString().replace("-","");
//        payData.put("openid",wechatPayConfig.getOpenId());
        payData.put("attach",token);

        // 进行sign签名
        payData.put("sign", SignUtil.sign(payData, wechatPayConfig.getKey()));

        String response = HttpUtil.post(wechatPayConfig.getMwebUrl(), payData);

        String url = Jsoup.parse(response)
                .body().getElementsByTag("a")
                .text();
        if (StringUtils.isNoneBlank(url)) {
            redisTemplate.opsForValue().set(new RequestTokenKey(token).getPrefix(),
                    "" + payData.get("total_fee"),
                    1, TimeUnit.HOURS);
        }
        System.out.println(url);
        return url;
    }
}
