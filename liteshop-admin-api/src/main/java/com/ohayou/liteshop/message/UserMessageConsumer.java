package com.ohayou.liteshop.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.es.ChatRecord;
import com.ohayou.liteshop.es.service.ChatRecordService;
import com.ohayou.liteshop.mq.queue.ServiceChatQueueConfig;
import com.ohayou.liteshop.vo.MessageVo;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author liyan
 * @date 2021/5/2 下午8:02
 */
@Component
public class UserMessageConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Autowired
    ChatRecordService chatRecordService;

    /**
     * 处理前台用户传来的消息
     * @param message
     * @param channel
     */
    @RabbitListener(queues = ServiceChatQueueConfig.USER_TO_ADMIN_QUEUE)
    public void process(Message message, Channel channel) throws Exception{

        MessageVo messageVo = objectMapper.readValue(message.getBody(), MessageVo.class);

        //将消息推送到后台
        messagingTemplate.convertAndSend("/topic/" + messageVo.getAdminName(),objectMapper.writeValueAsString(messageVo));


        //将聊天记录存入到es
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setUserMobile(messageVo.getUserMobile());
        chatRecord.setAck(messageVo.isAck());
        chatRecord.setAdminId(messageVo.getAdminId());
        chatRecord.setContent(messageVo.getContent());
        chatRecord.setMessageId(messageVo.getMessageId());
        chatRecord.setSendTime(messageVo.getSendTime());
        chatRecord.setSrc(messageVo.getSrc());
        chatRecord.setType(messageVo.getType());
        chatRecord.setUserNickname(messageVo.getUserNickname());
        chatRecord.setAdminName(messageVo.getAdminName());
        chatRecord.setAdminSend(false);
        chatRecord.setOrderId(messageVo.getOrderId());
        chatRecordService.save(chatRecord);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);

    }

}
