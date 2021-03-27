package com.ohayou.liteshop.vo;

/**
 * @author liyan
 * @date 2021/3/21 上午10:51
 */
public class OrderCountVo {

    private Integer unPaidOrderCount;

    private Integer paidOrderCount;

    private Integer shippedOrderCount;

    private Integer unCommentOrderCount;

    private Integer afterSaleOrderCount;

    public Integer getUnCommentOrderCount() {
        return unCommentOrderCount;
    }

    public void setUnCommentOrderCount(Integer unCommentOrderCount) {
        this.unCommentOrderCount = unCommentOrderCount;
    }

    public Integer getAfterSaleOrderCount() {
        return afterSaleOrderCount;
    }

    public void setAfterSaleOrderCount(Integer afterSaleOrderCount) {
        this.afterSaleOrderCount = afterSaleOrderCount;
    }

    public Integer getUnPaidOrderCount() {
        return unPaidOrderCount;
    }

    public void setUnPaidOrderCount(Integer unPaidOrderCount) {
        this.unPaidOrderCount = unPaidOrderCount;
    }

    public Integer getPaidOrderCount() {
        return paidOrderCount;
    }

    public void setPaidOrderCount(Integer paidOrderCount) {
        this.paidOrderCount = paidOrderCount;
    }

    public Integer getShippedOrderCount() {
        return shippedOrderCount;
    }

    public void setShippedOrderCount(Integer shippedOrderCount) {
        this.shippedOrderCount = shippedOrderCount;
    }
}
