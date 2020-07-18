package com.ohayou.liteshop.exception;

import com.ohayou.liteshop.response.ErrorCodeMsg;
import org.springframework.security.access.AccessDeniedException;


/**
 * @author liyan
 * @date 2020/7/15 下午4:49
 */
public class PermissionDeniedException extends AccessDeniedException {
    private ErrorCodeMsg errorCodeMsg;


    public PermissionDeniedException(ErrorCodeMsg errorCodeMsg) {
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
