package com.ohayou.liteshop.mq.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyan
 * @date 2021/5/2 下午3:01
 */

@Configuration
public class ServiceChatQueueConfig {

    public static final String USER_TO_ADMIN_QUEUE = "user_to_admin_queue";
    public static final String ADMIN_TO_USER_QUEUE = "admin_to_user_queue";

    @Bean
    public Queue userToAdminQueue() {
        return QueueBuilder.durable(USER_TO_ADMIN_QUEUE).build();
    }


    @Bean
    public Queue adminToUserQueue() {
        return QueueBuilder.durable(ADMIN_TO_USER_QUEUE).build();
    }
}
