package com.ohayou.liteshop.mq.bind;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author liyan
 * @date 2021/5/2 下午3:13
 */

@Configuration
public class ServiceChatBindingConfig {

    @Resource
    private Exchange serviceChatTopicExchange;

    @Resource
    private Queue userToAdminQueue;

    @Resource
    private Queue adminToUserQueue;

    public  static final String  USER_TO_ADMIN_ROUTING_KEY = "user_to_admin.#";
    public  static final String  ADMIN_TO_USER_ROUTING_KEY = "admin_to_user.#";

    @Bean
    public Binding userToAdminBinding() {
        return BindingBuilder.bind(userToAdminQueue)
                .to(serviceChatTopicExchange)
                .with(USER_TO_ADMIN_ROUTING_KEY)
                .noargs();

    }

    @Bean
    public Binding adminToUserBinding() {
        return BindingBuilder.bind(adminToUserQueue)
                .to(serviceChatTopicExchange)
                .with(ADMIN_TO_USER_ROUTING_KEY)
                .noargs();
    }
}
