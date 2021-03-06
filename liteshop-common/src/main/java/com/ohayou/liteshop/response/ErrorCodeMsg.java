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
    GET_TOKEN_ERROR(88888,"获取token失败"),
    REPEAT_REQUEST(77777,"请勿重复请求"),
    THREE_PARTY_PAYMENT_FAILED(66666,"调用第三方支付失败，请稍后再试"),
    PAYMENT_ERROR(55555,"支付失败，请稍后再试"),
    UNAUTHENTICATED_ERROR(400201,"认证失败，用户名或密码有误"),
    USER_NOT_ENABLED_ERROR(400202,"该账号不可用,请联系管理员"),
    USER_LOCKED(400205,"该账号已被锁定,请联系管理员"),

    INVALID_TOKEN(400203,"无效的token,拒绝访问"),
    TOKEN_EXPIRED(400204,"token已过期，请重新登录"),
    USER_EXIST(400206,"用户已存在"),
    USER_NO_ROLE(400207,"用户未分配角色"),
    USER_ADD_ERROR(400208,"添加用户失败"),
    USER_CANT_RESET(400209,"不能重置该用户密码"),
    USER_UPDATE_ERROR(400210,"更新用户失败"),
    USER_DELETE_ERROR(400211,"删除用户失败"),
    ROLE_EXIST(400212,"已存在该角色"),
    ADD_ROLE_ERROR(400213,"添加角色失败"),
    ROLE_NOT_FOUND(400214,"角色不存在"),
    UPDATE_ROLE_ERROR(400215,"更新角色失败"),
    USER_HAS_ROLE(400216,"无法删除，还有用户拥有该角色"),
    ROLE_DELETE_ERROR(400217,"该角色无法删除"),
    CONFIG_UPDATE_ERROR(400218,"更新配置失败"),
    INVALID_OLDPASSWORD(400219,"旧密码有误"),
    UPDATE_PASSWORD_ERROR(400220,"修改密码失败"),
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
    GOODS_DETAIL_ERROR(400618,"获取商品信息失败"),
    GOODS_HAS_COLLECT(400619,"该商品已收藏"),
    GOODS_COLLECT_ERROR(400620,"商品收藏失败"),
    REMOVE_COLLECT_ERROR(400621,"取消收藏失败"),
    GOODS_SPEC_NOT_EXIST(400622,"没有此规格商品"),
    GOODS_INVENTORY_SHORTAGE(400623,"商品库存不足"),


    COMMENT_NOT_FOUND(400701,"没有此评论，或该评论已删除"),
    COMMENT_HAS_COMMIT(400702,"已对该商品作出评价，不能重复评价"),
    COMMENT_ERROR(400703,"提交评论失败"),

    ORDER_NOT_EXIST(400801,"该订单不存在"),
    ORDER_STATUS_ERROR(400802,"订单状态错误"),
    ORDER_ERROR(400803,"订单异常"),
    ORDER_NOT_DELETE(400804,"无法删除该订单"),
    QUERY_TRACK_ERROR(400805,"物流查询发生未知错误"),
    ORDER_NOT_APPLY_AFTER_SALE(400806,"该订单未申请售后服务"),
    AUDIT_ERROR(400807,"审核失败"),
    CONFIRM_ORDER_NOT_EXIST(400808,"确认订单不存在"),
    SETTLE_ORDER_ERROR(400809,"确定订单失败，请刷新后重新提交"),
    TRACK_NOT_EXIST(400810,"还未有订单轨迹信息"),



    TOPIC_NOT_EXIST(400901,"该专题不存在"),
    TOPIC_CHANGE_ERROR(400902,"更改专题状态失败"),
    TOPIC_ADD_ERROR(400903,"添加专题失败"),
    TOPIC_EXIST(400904,"该专题已存在，不能重复添加"),
    TOPIC_ADD_GOODS_ERROR(400905,"添加专题商品失败"),
    TOPIC_DELETE_GOODS_ERROR(400906,"移除专题商品失败"),
    TOPIC_GOODS_EXIST(400907,"专题下已存在该商品,不能重复添加"),
    TOPIC_DELETE_ERROR(400908,"删除专题失败"),
    TOPIC_UPDATE_ERROR(400909,"专题修改失败"),


    COUPON_NOT_EXIST(401001,"优惠券不存在"),
    COUPON_ADD_ERROR(401002,"优惠券添加失败"),
    COUPON_UPDATE_ERROR(401003,"优惠券更新失败"),
    COUPON_STATUS_ERROR(401004,"无法删除,该优惠券未下架或未过期"),
    COUPON_DELETE_ERROR(401005,"删除优惠券失败"),
    COUPON_RECEIVE_ERROR(401006,"优惠券领取失败"),
    COUPON_EXPIRED(401007,"优惠券已过期"),
    COUPON_RECEIVE_OVER_LIMIT(401008,"优惠券领取数量超限"),
    COUPON_INSUFFICIENT_QUANTITY(401009,"优惠券数量不足"),

    CAPTCHA_EXPIRED(401101,"验证码已过期"),
    CAPTCHA_ERROR(401102,"验证码有误"),
    MEMBER_AUTH_ERROR(401103,"用户名或密码有误"),
    MEMBER_DISABLED(401104,"该用户不可用"),
    TWO_PASSWORD_NOT_EQUALS(401105,"两次输入密码不一致"),
    MEMBER_EXIST(401106,"该用户已注册"),
    REGISTER_ERROR(401107,"注册失败，请稍后再试"),
    ADD_ADDRESS_ERROR(401108,"用户添加收货地址失败"),
    ADDRESS_NOT_FOUND(401109,"地址不存在"),
    UPDATE_ADDRESS_ERROR(401110,"用户更新收货地址失败"),
    DELETE_ADDRESS_ERROR(401111,"用户删除收货地址失败"),

    CART_ADD_ERROR(401210,"购物车添加商品失败"),
    CART_NO_GOODS(401211,"该商品还未添加购物车"),
    CART_REMOVE_ITEM_ERROR(401212,"购物车删除商品失败"),
    CHECKED_FAIL(401213,"选择商品失败"),
    CART_CHANGE_NUM_ERROR(401214,"更改购物车商品数量失败"),
    GOODS_HAS_IN_CART(401215,"购物车里已有该商品")

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
