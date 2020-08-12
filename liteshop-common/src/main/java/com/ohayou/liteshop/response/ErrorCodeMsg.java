package com.ohayou.liteshop.response;

import org.springframework.validation.BindException;

/**
 * @author liyan
 * @date 2020/7/13 下午8:08
 */
/*
错误状态码枚举

 */
public enum ErrorCodeMsg {

    SERVER_ERROR(99999,"系统异常"),
    UNAUTHENTICATED_ERROR(400201,"认证失败，用户名或密码有误"),
    USER_NOT_ENABLED_ERROR(400202,"认证失败，该账号不可用"),
    INVALID_TOKEN(400203,"无效的token,拒绝访问"),
    TOKEN_EXPIRED(400204,"token已过期，请重新登录"),
    ACCESS_DENIED_ERROR(400300,"权限不足，拒绝访问"),
    PARAMETER_VALIDATED_ERROR(400101),
    UPLOAD_ERROR(400010,"上传失败"),


    USER_INFO_ERROR(400101,"获取用户信息失败"),
    UNAUTHENTICATED_CODE(400200),

    CHANGE_STATUS_ERROR(400301,"更改状态失败"),

    HAS_CHILDREN_NODE(400401,"无法删除，该分类下还有关联子分类"),
    CATEGORY_NOT_FOUND(400402,"该分类不存在"),
    CATEGORY_UPDATE_ERROR(400403,"更新分类失败"),
    CATEGORY_EXIST(400404,"该分类已存在,请勿重复添加"),
    CATEGORY_SAVE_ERROR(400405,"分类添加失败"),
    GOODS_ATTR_NOT_FOUND(400406,"该商品属性不存在"),
    GOODS_ATTR_UPDATE_ERROR(400407,"商品属性更新失败"),
    GOODS_ATTR_DELETE_ERROR(400408,"商品属性删除失败"),
    GOODS_ATTR_EXIST(400409,"该商品属性已存在"),
    ;



    private int code;

    private String msg;

    ErrorCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ErrorCodeMsg(int code){
        this.code = code;
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
}
