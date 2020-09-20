package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/9/17 下午10:13
 */
public enum  OrderStatus {
    UNPAID("待付款",0),
    PAID("已付款",1),
    UN_SHIPPED("待发货",2),
    SHIPPED("已发货",3),
    COMPLETED("已完成",4),
    CLOSED("已关闭",5)
    ;

    OrderStatus(String description, Integer status) {
        this.description = description;
        this.status = status;
    }

    private String description;

    private Integer status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
