package com.ohayou.liteshop.response;


import java.util.HashMap;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/7/13 下午8:03
 */
/*
统一返回封装类
 */
public class Result {

    private static final int SUCCESS_CODE = 200;

    private static final String SUCCESS_MSG = "操作成功!";

    private int code;

    private String msg;

    private Map<String,Object> data;


    private Result() {

    }

    public static Result error(ErrorCodeMsg errorCodeMsg) {
        Result result = new Result();
        result.setCode(errorCodeMsg.getCode());
        result.setMsg(errorCodeMsg.getMsg());
        return result;
    }

    public static Result parameterError(String msg) {
        Result result = new Result();
        result.setCode(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR.getCode());
        result.setMsg(msg);
        return result;
    }

    public static Result success() {
        return Result.success(SUCCESS_MSG);
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(msg);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",data);
        result.setData(map);
        return result;
    }

    public static Result success(Map<String,Object> data) {
        Result result = Result.success();
        result.setData(data);
        return result;
    }

    public static Result success(String dataKey, Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        HashMap<String, Object> map = new HashMap<>();
        map.put(dataKey,data);
        result.setData(map);
        return result;
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
