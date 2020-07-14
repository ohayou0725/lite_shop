package com.ohayou.liteshop.exception;

import com.ohayou.liteshop.response.ErrorCodeMsg;

/**
 * @author liyan
 * @date 2020/7/13 下午10:28
 */
public class GlobalException extends RuntimeException{
    private ErrorCodeMsg errorCodeMsg;

    public GlobalException() {
    }

    public GlobalException(ErrorCodeMsg errorCodeMsg) {
        this.errorCodeMsg = errorCodeMsg;
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public ErrorCodeMsg getErrorCodeMsg() {
        return errorCodeMsg;
    }

    public void setErrorCodeMsg(ErrorCodeMsg errorCodeMsg) {
        this.errorCodeMsg = errorCodeMsg;
    }
}
