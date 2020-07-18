package com.ohayou.liteshop.security;

import cn.hutool.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.exception.PermissionDeniedException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liyan
 * @date 2020/7/15 下午1:55
 */
@Component
public class MyAccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.HTTP_FORBIDDEN);
        response.getWriter().println(objectMapper.writeValueAsString(Result.error(ErrorCodeMsg.ACCESS_DENIED_ERROR.getCode(),ErrorCodeMsg.ACCESS_DENIED_ERROR.getMsg())));
        response.getWriter().flush();
    }
}
