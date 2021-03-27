package com.ohayou.liteshop.interceptor;

import com.ohayou.liteshop.annotation.Idempotent;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.RequestTokenKey;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.security.MemberUserDetails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author liyan
 * @date 2021/2/22 下午9:55
 */
@Component
public class IdempotentInterceptor implements HandlerInterceptor {

    private final static String IDEMPOTENT_TOKEN_HEADER = "idempotent_token" ;

    @Autowired
    private RedisService  redisService;

    /**
     * 幂等接口拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod =  (HandlerMethod) handler;
            Idempotent annotation = handlerMethod.getMethodAnnotation(Idempotent.class);
            if (null == annotation) {
                //如果方法没有幂等注解则直接放行
                return true;
            }
            //获取Header中的requestToken
            String token = request.getHeader(IDEMPOTENT_TOKEN_HEADER);
            if (StringUtils.isBlank(token)) {
                throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
            }
            MemberUserDetails user = (MemberUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!redisService.validToken(token,String.valueOf(user.getId()))) {
                throw new GlobalException(ErrorCodeMsg.REPEAT_REQUEST);
            }
        }
        return true;
    }


}
