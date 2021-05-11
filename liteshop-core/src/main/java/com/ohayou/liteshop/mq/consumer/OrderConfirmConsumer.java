package com.ohayou.liteshop.mq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.mq.queue.OrderQueueConfig;
import com.ohayou.liteshop.service.MallOrderService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liyan
 * @date 2021/4/4 上午10:51
 */
@Component
public class OrderConfirmConsumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MallOrderService mallOrderService;

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderConfirmConsumer.class);


    @RabbitListener(queues = OrderQueueConfig.ORDER_CONFIRM_DELAY_QUEUE)
    public void process(Message message, Channel channel) throws Exception {
        MallOrder order = objectMapper.readValue(message.getBody(), MallOrder.class);

        Long id = order.getId();
        try {
            boolean confirm = mallOrderService.confirm(id);
            if (confirm) {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
            } else {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            }
        } catch (GlobalException e) {
            LOGGER.info("订单编号：{}，用户已确认收货", order.getOrderSn());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        }
    }
}
