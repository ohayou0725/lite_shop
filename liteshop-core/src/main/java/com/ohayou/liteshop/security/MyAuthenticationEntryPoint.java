package com.ohayou.liteshop.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.exception.UnAuthenticationException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liyan
 * @date 2020/7/15 下午2:00
 */

/**
 * /*
 * 认证失败统一处理器
 *
 * */

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        if (e instanceof UnAuthenticationException) {
            UnAuthenticationException ex = (UnAuthenticationException) e;
            response.getWriter().println(objectMapper.writeValueAsString(Result.error(ex.getErrorCodeMsg())));
        } else {
            response.getWriter().println(objectMapper.writeValueAsString(Result.error(ErrorCodeMsg.INVALID_TOKEN)));
        }
        response.getWriter().flush();
    }
}
