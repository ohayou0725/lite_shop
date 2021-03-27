package com.ohayou.liteshop.payment;

import com.ohayou.liteshop.constant.PayType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author liyan
 * @date 2021/2/27 上午11:19
 */
//支付服务
@Service
public interface PayService {

    String pay(BigDecimal totalPrice, String orderSn, PayType payType);
}
