package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.OrderPaymentKey;
import com.ohayou.liteshop.payment.wechat.NotifyDTO;
import com.ohayou.liteshop.payment.wechat.WechatPayConfig;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.utils.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/2/27 下午3:41
 */
@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    WechatPayConfig payConfig;


    @Autowired
    MallOrderService orderService;

    @Autowired
    RedisService redisService;

    @ApiDesc("支付回调接口")
    @PostMapping("/notify")
    public String payNotify(NotifyDTO notifyDTO) {
        Map<String,Object> notifyData = new HashMap<>();
        notifyData.put("return_code",notifyDTO.getReturn_code());
        notifyData.put("total_fee",notifyDTO.getTotal_fee());
        notifyData.put("out_trade_no",notifyDTO.getOut_trade_no());
        notifyData.put("payjs_order_id",notifyDTO.getPayjs_order_id());
        notifyData.put("transaction_id",notifyDTO.getTransaction_id());
        notifyData.put("time_end",notifyDTO.getTime_end());
        notifyData.put("openid",notifyDTO.getOpenid());
        notifyData.put("mchid",notifyDTO.getMchid());

        if (notifyDTO.getAttach() != null) {
            notifyData.put("attach",notifyDTO.getAttach());
        }
        if (notifyDTO.getType() != null) {
            notifyData.put("type", notifyDTO.getType());
        }
        String sign = SignUtil.sign(notifyData, payConfig.getKey());
        if (sign.equals(notifyDTO.getSign())) {
            //支付成功,验证消息是否为重复发送,通过redis进行去重
            if (redisService.validToken(notifyDTO.getAttach(),notifyDTO.getTotal_fee())) {
                //如果为第一次请求，并且金额与订单金额一致，则修改订单状态
                orderService.doPayed(notifyDTO);
            }

            return "success";
        }
        return "failure";
    }
}
