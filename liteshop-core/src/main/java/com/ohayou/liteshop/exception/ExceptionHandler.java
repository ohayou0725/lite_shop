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
    
    @org.springframework.web.bind.annotation.ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result globalExceptionHandler(Exception exception) {
        GlobalException e = (GlobalException)exception;
       return Result.error(e.getErrorCodeMsg());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result BindExceptionHandler(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Result.parameterError(errorMsg);
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(UnAuthenticationException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public Result AuthenticationExceptionHandler(Exception e) {
//        if (e instanceof UnAuthenticationException) {
//            UnAuthenticationException unAuthenticationException = (UnAuthenticationException)e;
//            return Result.error(unAuthenticationException.getErrorCodeMsg());
//        }
//        throw new GlobalException(ErrorCodeMsg.SERVER_ERROR);
//    }
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(PermissionDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public Result AccessDeniedHandler(Exception e) {
//        if (e instanceof PermissionDeniedException) {
//            PermissionDeniedException permissionDeniedException = (PermissionDeniedException) e;
//            return Result.error(permissionDeniedException.getErrorCodeMsg());
//        }
//        throw new GlobalException(ErrorCodeMsg.SERVER_ERROR);
//    }
}
