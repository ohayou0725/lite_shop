package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/9/14 上午10:43
 */
public enum  GoodsStatus {
    IN_STOCK(1),
    NOT_IN_STOCK(0);
    private Integer status;


    GoodsStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
