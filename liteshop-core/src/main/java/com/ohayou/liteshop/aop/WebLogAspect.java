package com.ohayou.liteshop.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohayou.liteshop.dto.WebLog;
import com.ohayou.liteshop.entity.AdminLog;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.AdminUserDetails;
import com.ohayou.liteshop.service.AdminLogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/7/14 下午10:00
 */
/*
日志记录切面类
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AdminLogService adminLogService;

    @Pointcut("execution(public * com.ohayou.liteshop.controller.*.*(..))")
    public void webLog(){}

    /*
    环绕通知记录日志
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        LocalDateTime startTime = LocalDateTime.now();
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录请求信息
        WebLog webLog = new WebLog();
        Object result = pjp.proceed();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminLog adminLog = null;
        if (principal == null) {
            webLog.setUsername("匿名用户");
        }

        if (principal instanceof AdminUserDetails) {
            webLog.setUsername(((AdminUserDetails)principal).getUsername());
            adminLog = new AdminLog();
            adminLog.setAdmin(((AdminUserDetails)principal).getUsername());
            adminLog.setIp(request.getRemoteHost());
            adminLog.setAdmin(webLog.getUsername());
            Result apiResult = (Result)result;
            if (apiResult.getCode() != 200) {
                adminLog.setStatus(0);
                adminLog.setResult("操作失败");
                adminLog.setComment(apiResult.getMsg());
            } else {
                adminLog.setStatus(1);
                adminLog.setResult("操作成功");
            }
        } else {
            webLog.setUsername(((MemUser)principal).getMobile());
        }
        LocalDateTime endTime = LocalDateTime.now();
        Duration between = Duration.between(startTime, endTime);
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(ApiDesc.class)) {
            ApiDesc annotation = method.getAnnotation(ApiDesc.class);
            webLog.setDesc(annotation.value());
        }
        adminLog.setAction(webLog.getDesc());
        webLog.setIp(request.getRemoteHost());
        webLog.setMethod(request.getMethod());
        webLog.setResult(result);
        webLog.setSpendTime(between.toMillis() + "ms");
        webLog.setStatTime(startTime);
        webLog.setUri(request.getRequestURI());
        webLog.setUrl(request.getRequestURL().toString());
        webLog.setParameter(getParameter(method,pjp.getArgs()));
        LOGGER.info("{}",objectMapper.writeValueAsString(webLog));

//        adminLogService.save(adminLog);

        return result;
    }

    /**
     * 获取请求参数
     */

    private Object getParameter(Method method,Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {

            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                if (args[i] instanceof MultipartFile) {
                    argList.add(((MultipartFile)args[i]).getOriginalFilename());
                }
                Map<String ,Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                    if (key.equals("file")) {
                        map.put(key,((MultipartFile)args[i]).getOriginalFilename());
                    } else {
                        map.put(key,args[i]);
                    }
                }
                argList.add(map);
            }
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }
}
