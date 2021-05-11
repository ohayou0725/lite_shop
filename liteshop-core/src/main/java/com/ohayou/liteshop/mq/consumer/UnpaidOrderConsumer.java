package com.ohayou.liteshop.mq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.cache.RedisService;

import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.service.MallGoodsSkuService;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.service.MallUserCouponService;
import com.ohayou.liteshop.vo.OrderConfirmVo;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author liyan
 * @date 2021/2/28 下午10:06
 */
@Component
public class UnpaidOrderConsumer {


    public static final Logger LOGGER = LoggerFactory.getLogger(UnpaidOrderConsumer.class);

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MallOrderService orderService;

    @Autowired
    RedisService redisService;

    @Autowired
    MallGoodsSkuService skuService;

    @Autowired
    MallUserCouponService userCouponService;


    /**
     * 监听订单延迟队列，消息到期后会接收到消息判断订单是否已经支付，如果未支付则取消订单,释放库存,返还优惠券
     * @param message
     * @throws IOException
     */
    @RabbitListener(queues = "order_delay_queue")
    @Transactional(rollbackFor = Exception.class)
    public void process(Message message, Channel channel) throws IOException {
        OrderConfirmVo orderConfirmVo = objectMapper.readValue(message.getBody(), OrderConfirmVo.class);
        String orderSn = orderConfirmVo.getOrderSn();
        try {
            boolean result = orderService.cancelOrder(orderSn);
            if (result) {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
            } else {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            }
        } catch (GlobalException e) {
            LOGGER.info("订单编号：{}，该订单已支付或已取消，取消订单失败", orderConfirmVo.getOrderSn());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        }
    }
}
