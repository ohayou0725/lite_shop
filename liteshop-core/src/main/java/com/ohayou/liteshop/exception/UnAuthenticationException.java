package com.ohayou.liteshop.exception;

import com.ohayou.liteshop.response.ErrorCodeMsg;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;

/**
 * @author liyan
 * @date 2020/7/15 下午12:58
 */

public class UnAuthenticationException extends AuthenticationException {
    private ErrorCodeMsg errorCodeMsg;

    public UnAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public UnAuthenticationException(String msg) {
        super(msg);
    }

    public UnAuthenticationException(ErrorCodeMsg errorCodeMsg) {
        super(errorCodeMsg.getMsg());
        this.errorCodeMsg = errorCodeMsg;
    }

    public ErrorCodeMsg getErrorCodeMsg() {
        return errorCodeMsg;
    }

    public void setErrorCodeMsg(ErrorCodeMsg errorCodeMsg) {
        this.errorCodeMsg = errorCodeMsg;
    }
}
