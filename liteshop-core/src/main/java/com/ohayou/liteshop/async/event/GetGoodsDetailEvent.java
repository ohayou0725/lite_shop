package com.ohayou.liteshop.async.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author liyan
 * @date 2021/2/1 下午10:20
 */
public class GetGoodsDetailEvent extends ApplicationEvent {
    private Long goodsId;

    private Long userId;

    public GetGoodsDetailEvent(Object source, Long goodsId, Long userId) {
        super(source);
        this.goodsId = goodsId;
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
