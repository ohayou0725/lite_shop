package com.ohayou.liteshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.mq.exchange.ServiceChatTopicExchangeConfig;
import com.ohayou.liteshop.vo.MessageVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author liyan
 * @date 2021/5/9 下午1:12
 */
@Controller
public class WebSocketController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @MessageMapping("/chat")
    public void handleChat(MessageVo message, StompHeaderAccessor accessor) throws JsonProcessingException {
        MessageVo messageVo = new MessageVo();
        messageVo.setAvatar(message.getAvatar());
        messageVo.setAdminName(message.getAdminName());
        messageVo.setUserNickname(message.getUserNickname());
        messageVo.setMessageId(UUID.randomUUID().toString().replace("-",""));
        messageVo.setAck(false);
        messageVo.setUploaded(message.isUploaded());
        messageVo.setViewed(message.isViewed());
        messageVo.setType(message.getType());
        messageVo.setSendTime(LocalDateTime.now());
        messageVo.setAdminId(message.getAdminId());
        messageVo.setContent(message.getContent());
        messageVo.setAdminSend(true);
        messageVo.setUserMobile(message.getUserMobile());
        messageVo.setSrc(message.getSrc());
        messageVo.setOrderId(message.getOrderId());
        rabbitTemplate.convertAndSend(ServiceChatTopicExchangeConfig.SERVICE_CHAT_EXCHANGE_NAME,
                "admin_to_user.message",
                objectMapper.writeValueAsString(messageVo));
    }

}
