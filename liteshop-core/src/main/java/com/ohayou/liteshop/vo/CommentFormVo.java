package com.ohayou.liteshop.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author liyan
 * @date 2021/4/7 下午9:50
 */
public class CommentFormVo {

    @NotNull(message = "订单Id不能为空")
    private Long orderId;

    @NotNull(message = "skuId不能为空")
    private Long skuId;

    private String content;

    @Max(value = 5,message = "评价最高为5星")
    @Min(value = 1,message = "评价最低为1星")
    private String score;

    private String[] imgs;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String[] getImgs() {
        return imgs;
    }

    public void setImgs(String[] imgs) {
        this.imgs = imgs;
    }
}
