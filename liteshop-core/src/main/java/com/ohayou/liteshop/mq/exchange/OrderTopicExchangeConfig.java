package com.ohayou.liteshop.mq.exchange;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyan
 * @date 2021/2/24 下午10:20
 */
@Configuration
public class OrderTopicExchangeConfig {

    public final static String ORDER_EXCHANGE_NAME = "order_topic_exchange";
    public final static String DLX_EXCHANGE_NAME = "dlx_exchange";


    @Bean("orderExchange")
    public TopicExchange orderTopicExchange() {
        return ExchangeBuilder.topicExchange(ORDER_EXCHANGE_NAME)
                .durable(true).build();

    }

    /**
     * 定义死信交换机，实现延迟队列
     * @return TopicExchange
     */
    @Bean("orderDLXExchange")
    public TopicExchange DLXExchange() {
        return ExchangeBuilder.topicExchange(DLX_EXCHANGE_NAME)
                .durable(true).build();
    }


}
