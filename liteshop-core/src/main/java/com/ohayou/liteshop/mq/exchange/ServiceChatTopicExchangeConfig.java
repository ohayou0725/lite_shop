package com.ohayou.liteshop.mq.exchange;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyan
 * @date 2021/5/2 下午2:57
 */
@Configuration
public class ServiceChatTopicExchangeConfig {

    public final static String SERVICE_CHAT_EXCHANGE_NAME = "service_chat_exchange";


    @Bean
    public TopicExchange serviceChatTopicExchange() {
        return ExchangeBuilder.topicExchange(SERVICE_CHAT_EXCHANGE_NAME)
                .durable(true)
                .build();
    }

}
