package com.ohayou.liteshop.message;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.entity.ChatRecord;
import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.mq.queue.ServiceChatQueueConfig;
import com.ohayou.liteshop.service.ChatRecordService;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.vo.MessageVo;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author liyan
 * @date 2021/5/9 下午1:18
 */
@Component
public class AdminMessageConsumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Autowired
    ChatRecordService recordService;

    @Autowired
    MallOrderService orderService;

    @RabbitListener(queues = ServiceChatQueueConfig.ADMIN_TO_USER_QUEUE)
    public void process(Message message, Channel channel) throws Exception {

        MessageVo messageVo = objectMapper.readValue(message.getBody(), MessageVo.class);
        //判断订单是否存在
        Long orderId = messageVo.getOrderId();
        if (orderService.count(new LambdaQueryWrapper<MallOrder>().eq(MallOrder::getId,orderId)) < 1) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            return;
        }

        //将消息推送到前台用户
        messagingTemplate.convertAndSend("/topic/" + messageVo.getUserMobile(), objectMapper.writeValueAsString(messageVo));



        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setUserMobile(messageVo.getUserMobile());
        chatRecord.setAck(1);
        chatRecord.setAdminId(messageVo.getAdminId());
        chatRecord.setContent(messageVo.getContent());
        chatRecord.setId(messageVo.getMessageId());
        chatRecord.setSendTime(messageVo.getSendTime());
        chatRecord.setSrc(messageVo.getSrc());
        chatRecord.setType(messageVo.getType());
        chatRecord.setUserNickname(messageVo.getUserNickname());
        chatRecord.setAdminName(messageVo.getAdminName());
        chatRecord.setAdminSend(1);
        chatRecord.setOrderId(messageVo.getOrderId());
        recordService.save(chatRecord);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);

    }
}
