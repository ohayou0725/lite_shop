package com.ohayou.liteshop.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/7/13 下午8:03
 */
/*
统一返回封装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    public  static final int SUCCESS_CODE = 200;

    public  static final String SUCCESS_MSG = "操作成功!";

    private int code;

    private String msg;

    private boolean success;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime timestamp = LocalDateTime.now();

    private Map<String, Object> data;


    private Result() {

    }


    public static Result error(ErrorCodeMsg errorCodeMsg) {
        Result result = new Result();
        result.setCode(errorCodeMsg.getCode());
        result.setMsg(errorCodeMsg.getMsg());
        result.setSuccess(false);
        return result;
    }

    public static Result parameterError(String msg) {
        Result result = new Result();
        result.setCode(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR.getCode());
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static Result success() {
        return Result.success(SUCCESS_MSG);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(msg);
        result.setSuccess(true);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", data);
        result.setData(map);
        result.setSuccess(true);
        return result;
    }

    public static Result success(Map<String, Object> data) {
        Result result = Result.success();
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static Result success(String dataKey, Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        HashMap<String, Object> map = new HashMap<>();
        map.put(dataKey, data);
        result.setData(map);
        result.setSuccess(true);
        return result;
    }


    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static String getSuccessMsg() {
        return SUCCESS_MSG;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
