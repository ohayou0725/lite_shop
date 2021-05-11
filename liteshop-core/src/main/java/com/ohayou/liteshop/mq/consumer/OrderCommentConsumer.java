package com.ohayou.liteshop.mq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.mq.queue.OrderQueueConfig;
import com.ohayou.liteshop.service.MallGoodsCommentService;
import com.ohayou.liteshop.service.MallOrderService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/4/15 下午10:34
 */
@Component
public class OrderCommentConsumer {

    @Autowired
    MallOrderService mallOrderService;

    @Autowired
    MallGoodsCommentService commentService;

    @Autowired
    ObjectMapper objectMapper;

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderCommentConsumer.class);

    @RabbitListener(queues = OrderQueueConfig.ORDER_COMMENT_DELAY_QUEUE)
    public void process(Message message, Channel channel) throws Exception {


        Map map = objectMapper.readValue(message.getBody(), Map.class);
        Long orderId = (Long)map.get("orderId");
        Long userId  = (Long)map.get("userId");
        try {
            commentService.commitByTimeOut(orderId, userId);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);

        } catch (GlobalException e) {
            LOGGER.info("订单Id{}已确认收货",orderId);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        }
    }

}
