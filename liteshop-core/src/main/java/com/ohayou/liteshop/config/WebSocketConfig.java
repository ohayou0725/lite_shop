package com.ohayou.liteshop.config;

import cn.hutool.core.collection.CollectionUtil;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.MemberUserTokenKey;
import com.ohayou.liteshop.security.JWTTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import sun.security.acl.PrincipalImpl;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author liyan
 * @date 2021/4/26 下午9:34
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {

    @Autowired
    RedisService redisService;

    @Autowired
    UserDetailsService memberUserDetailService;

    @Autowired
    JWTTokenUtil jwtTokenUtil;



    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue,","/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/service").setAllowedOrigins("*").withSockJS();

    }



    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                //判断是否为首次连接请求
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                    String token = null;
                    List<String> nativeHeader = accessor.getNativeHeader("Authorization");
                    if (CollectionUtil.isNotEmpty(nativeHeader)) {
                        String header = nativeHeader.get(0);
                        if (!StringUtils.isEmpty(header) && header.startsWith("Bearer")) {
                            token = header.substring("Bearer".length());
                        }
                        if (null != token) {
                            //判断为前台用户还是后台用户
                            String username = null;
                            MemberUserTokenKey memberUserTokenKey = new MemberUserTokenKey(token);
                            if(redisService.hasKey(memberUserTokenKey.getPrefix())){
                                //当前用户为前台用户
                                String mobile = String.valueOf(redisService.get(memberUserTokenKey.getPrefix()));
                                UserDetails userDetails = memberUserDetailService.loadUserByUsername(mobile);
                                username = userDetails.getUsername();
                            } else {
                                //当前用户为后台用户
                                username = jwtTokenUtil.getUserNameFromToken(token);

                            }
                            if (null != username) {
                                accessor.setUser(new PrincipalImpl(username));
                            }
                        }
                    }
                }
                if (StompCommand.ACK.equals(accessor.getCommand())) {
                    //手动确认消息
                }

                return message;
            }
        });


    }
}


