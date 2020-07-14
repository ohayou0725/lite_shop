package com.ohayou.liteshop.exception;

import com.ohayou.liteshop.response.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liyan
 * @date 2020/7/13 下午10:35
 */

@RestControllerAdvice
public class ExceptionHandler {
    
    @org.springframework.web.bind.annotation.ExceptionHandler(GlobalException.class)
    public Result globalExceptionHandler(Exception exception) {
        GlobalException e = (GlobalException)exception;
       return Result.error(e.getErrorCodeMsg());
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    public Result BindExceptionHandler(BindException e) {
        String errorMsg = e.getAllErrors().get(0).getDefaultMessage();
        return Result.parameterError(errorMsg);
    }
}
