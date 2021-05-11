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

    public static final String ORDER_CONFIRM_DELAY_QUEUE = "order_confirm_delay_queue";
    public static final String ORDER_CONFIRM_DLX_QUEUE = "order_confirm_DLX_queue";
    public static final String ORDER_DLX_QUEUE="order_DLX_queue";
    public static final String ORDER_DELAY_QUEUE = "order_delay_queue";
    public static final String ORDER_COMMENT_DELAY_QUEUE = "order_comment_delay_queue";
    public static final String ORDER_COMMENT_DLX_QUEUE = "order_comment_DLX_queue";

    @Bean("orderConfirmQueue")
    public Queue orderConfirm() {
        return QueueBuilder.durable(ORDER_CONFIRM_DELAY_QUEUE).build();
    }

    @Bean("orderCommentQueue")
    public Queue orderComment() {
        return QueueBuilder.durable(ORDER_COMMENT_DELAY_QUEUE).build();
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
     * 订单确认队列
     *    消息成为死信后将消息发送到死信交换机
     * @return
     */
    @Bean("orderConfirmDLXQueue")
    public Queue orderConfirmDLXQueue() {
        SysOrderConfig orderConfig = sysOrderConfigService.getById(1);
        String confirmDays = orderConfig.getConfirmDays();
        return QueueBuilder.durable(ORDER_CONFIRM_DLX_QUEUE)
                .deadLetterExchange(OrderTopicExchangeConfig.DLX_EXCHANGE_NAME)
                .deadLetterRoutingKey("delayOrderConfirm.confirm")
                .ttl(1000*60*60*24*Integer.parseInt(confirmDays))
                .build();
    }

    /**
     * 订单评论延迟队列
     *     消息成为死信后将消息发送到死信交换机
     * @return
     */
    @Bean( "orderCommentDLXQueue")
    public Queue orderCommentDLXQueue() {
        SysOrderConfig orderConfig = sysOrderConfigService.getById(1);
        String commentDays = orderConfig.getCommentDays();
        return QueueBuilder.durable(ORDER_COMMENT_DLX_QUEUE)
                .deadLetterExchange(OrderTopicExchangeConfig.DLX_EXCHANGE_NAME)
                .deadLetterRoutingKey("delayOrderComment.comment")
                .ttl(1000*60*60*24*Integer.parseInt(commentDays))
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
