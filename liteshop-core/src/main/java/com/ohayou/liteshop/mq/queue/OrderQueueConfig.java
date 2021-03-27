package com.ohayou.liteshop.mq.queue;

import com.ohayou.liteshop.entity.SysOrderConfig;
import com.ohayou.liteshop.mq.exchange.OrderTopicExchangeConfig;
import com.ohayou.liteshop.service.SysOrderConfigService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyan
 * @date 2021/2/24 下午10:47
 */
@Configuration
public class OrderQueueConfig {

    @Autowired
    SysOrderConfigService sysOrderConfigService;

    public static final String ORDER_SKU_QUEUE = "order_sku_queue";
    public static final String ORDER_DLX_QUEUE="order_DLX_queue";
    public static final String ORDER_DELAY_QUEUE = "order_delay_queue";

    @Bean("orderSkuQueue")
    public Queue orderSkuQueue() {
        return QueueBuilder.durable(ORDER_SKU_QUEUE).build();
    }

    /*
    消息成为死信后将消息发送到死信交换机
     */
    @Bean("orderDLXQueue")
    public Queue orderDLXQueue() {
        SysOrderConfig orderConfig = sysOrderConfigService.getById(1);
        Integer expireTime = orderConfig.getExpireTime();
        return QueueBuilder.durable(ORDER_DLX_QUEUE)
                .deadLetterExchange(OrderTopicExchangeConfig.DLX_EXCHANGE_NAME)
                .deadLetterRoutingKey("delayOrder.unpaid")
                .ttl(1000*60*expireTime)
                .build();
    }

    /**
     * 订单延迟队列
     * @return
     */
    @Bean("orderUnpaidQueue")
    public Queue orderDelayQueue() {
        return QueueBuilder.durable(ORDER_DELAY_QUEUE).build();
    }
}
