package com.ohayou.liteshop.payment.wechat;

import cn.hutool.core.lang.UUID;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.cache.cachekey.RequestTokenKey;
import com.ohayou.liteshop.constant.PayType;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.payment.PayService;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.utils.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static final Logger LOGGER = LoggerFactory.getLogger(WechatPayServiceImpl.class);

    @Override
    public String pay(BigDecimal totalPrice, String orderSn, PayType payType) {
        Map<String,Object> payData = new HashMap<>();
        payData.put("mchid", wechatPayConfig.getMchid());
        payData.put("total_fee", "1");
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
        } else {
            LOGGER.error("微信支付接口返回错误信息：{}",response);
            throw new GlobalException(ErrorCodeMsg.THREE_PARTY_PAYMENT_FAILED);
        }
        return url;
    }

    /**
     * 退款
     * @param payId
     * @return
     */
    @Override
    public boolean refund(String payId) {
        Map<String,Object> payData = new HashMap<>();
        payData.put("payjs_order_id",payId);
        payData.put("sign", SignUtil.sign(payData, wechatPayConfig.getKey()));

        String response = HttpUtil.post(wechatPayConfig.getRefundUrl(), payData);
        RefundReturnDto refundReturnDto = null;
        try {
            refundReturnDto = objectMapper.readValue(response, RefundReturnDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new GlobalException(ErrorCodeMsg.SERVER_ERROR);
        }
        LOGGER.info("支付订单{}发起退款，返回{}",payId,refundReturnDto.getReturn_msg());
        Integer return_code = refundReturnDto.getReturn_code();
        return return_code.equals(1);
    }
}
