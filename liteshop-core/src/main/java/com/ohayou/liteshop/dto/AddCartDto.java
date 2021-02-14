package com.ohayou.liteshop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author liyan
 * @date 2021/2/2 下午9:24
 */
public class AddCartDto {


    private Long cartItemId;

    @NotNull(message = "商品id不能为空")
    private Long goodsId;

    private Integer num;

    @NotNull(message = "skuId不能为空")
    private Long skuId;

    private Long userId;

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}
