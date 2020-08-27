package com.ohayou.liteshop.exception;

import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

/**
 * @author liyan
 * @date 2020/7/13 下午10:35
 */

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result globalExceptionHandler(Exception exception) {
        if (exception instanceof GlobalException) {
            GlobalException e = (GlobalException)exception;
            return Result.error(e.getErrorCodeMsg());
        }
        if (exception instanceof BindException) {
            BindException e = (BindException)exception;
            String errorMsg = e.getAllErrors().get(0).getDefaultMessage();
            e.printStackTrace();
            return Result.parameterError(errorMsg);
        }
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException)exception;
            String errorMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
            return Result.parameterError(errorMsg);
        }

        exception.printStackTrace();
        return Result.error(ErrorCodeMsg.SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @org.springframework.web.bind.annotation.ExceptionHandler(UnAuthenticationException.class)
    public Result LoginExceptionHandler(Exception exception) {
        UnAuthenticationException e= (UnAuthenticationException)exception;
        return Result.error(e.getErrorCodeMsg());
    }



}
