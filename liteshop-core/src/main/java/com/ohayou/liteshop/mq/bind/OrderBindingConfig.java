package com.ohayou.liteshop.mq.bind;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Resource;

/**
 * @author liyan
 * @date 2021/2/25 下午9:34
 */
@Configuration
public class OrderBindingConfig {

    @Resource(name = "orderSkuQueue")
    private Queue orderSkuQueue;

    @Resource(name = "orderDLXQueue")
    private Queue orderDLXQueue;

    @Resource(name = "orderUnpaidQueue")
    private Queue orderUnpaidQueue;

    @Resource(name = "orderExchange")
    private Exchange orderExchange;

    @Resource(name = "orderDLXExchange")
    private Exchange orderDLXExchange;

    /**
     * 订单交换机与订单库存队列进行绑定，队列收到消息后异步修改库存
     * @return
     */
//    @Bean
//    public Binding orderSkuBinding() {
//        return BindingBuilder.bind(orderSkuQueue)
//                .to(orderExchange)
//                .with("order.#")
//                .noargs();
//    }

    /**
     * 订单交换机与订单队列进行绑定，并且没有消费者，让队列里的消息根据TTL自动过期，
     * 过期后将消息发送到死信交换机后死信交换机分发后消费者进行消费以实现延迟队列
     * @return
     */
    @Bean
    public Binding orderDLXQueueBinding() {
        return BindingBuilder.bind(orderDLXQueue)
                .to(orderExchange)
                .with("order.#")
                .noargs();
    }

    @Bean
    public Binding orderDelayQueue() {
        return BindingBuilder.bind(orderUnpaidQueue)
                .to(orderDLXExchange)
                .with("delayOrder.#")
                .noargs();
    }

}
