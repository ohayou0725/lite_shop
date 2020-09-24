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
    PARAMETER_VALIDATED_ERROR(400101,"参数错误"),
    UPLOAD_ERROR(400010,"上传失败"),


    USER_INFO_ERROR(400101,"获取用户信息失败"),
    USER_NOT_FOUND(400102,"没有该用户"),
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
    CATEGORY_ID_IS_NULL(400501,"分类ID为空"),

    BRAND_EXIST(400502,"该品牌商已存在"),
    SAVE_BRAND_ERROR(400503,"添加品牌商信息失败"),
    BRAND_NOT_FOUND(400504,"没有此品牌商"),
    BRAND_UPDATE_ERROR(400504,"品牌商更新失败"),
    BRAND_CATEGORY_EXIST(400506,"品牌商已有该分类，不能重复添加"),
    BRAND_NOT_HAS_CATEGORY(400505,"该品牌商没有此分类"),

    GOODS_NOT_FOUND(400601,"没有此商品"),
    GOODS_EXIST(400602,"商品编号已存在或存在相同商品，不能重复添加"),
    GOODS_SPEC_EMPTY(400603,"商品规格列表不能为空"),
    SAVE_GOODS_ERROR(400604,"新增商品信息失败"),
    UPDATE_GOODS_INFO_ERROR(400605,"修改商品信息失败"),
    UPDATE_GOODS_ATTR_ERROR(400606,"修改商品属性失败"),
    UPDATE_GOODS_SPEC_ERROR(400607,"修改商品规格失败"),
    CHANGE_GOODS_STATUS_ERROR(400608,"修改商品状态失败"),
    DELETE_GOODS_ERROR(400609,"删除商品失败"),
    GOODS_IN_STOCK(400610,"商品还未下架或还有剩余库存，不能进行删除"),
    GOODS_SKU_NOT_EXIST(400611,"该商品还未上架过单品"),
    GOODS_SPEC_VALUE_CANT_DELETE(400612,"无法删除该规格值，请确认该规格单品是否已删除"),
    GOODS_ADD_SKU_ERROR(400613,"单品上架失败"),
    SKU_EXIST(400614,"该单品已上架，不能重复上架"),
    GOODS_SKU_UPDATE_ERROR(400615,"单品信息更新失败"),
    GOODS_SKU_NOT_FOUND(400616,"单品不存在"),
    GOODS_SKU_DELETE_ERROR(400617,"单品不存在"),

    COMMENT_NOT_FOUND(400701,"没有此评论，或该评论已删除"),

    ORDER_NOT_EXIST(400801,"该订单不存在"),
    ORDER_STATUS_ERROR(400802,"订单状态错误"),
    ORDER_ERROR(400803,"订单异常"),
    ORDER_NOT_DELETE(400804,"无法删除该订单"),
    QUERY_TRACK_ERROR(400805,"物流查询发生未知错误")

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
