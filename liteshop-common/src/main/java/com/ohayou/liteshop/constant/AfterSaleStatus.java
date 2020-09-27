package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/9/25 下午9:26
 */
public enum AfterSaleStatus {
    CAN_APPLY("可申请",0),
    ALREADY_APPLIED("用户已申请",1),
    ADMIN_PASSED("管理员审核通过",2),
    REFUND_SUCCESSFULLY("管理员退款成功",3),
    UN_PASSED("管理员审核未通过",4),
    USER_CANCELED("用户取消",5);


    private String description;

    private Integer status;



    AfterSaleStatus(String description, Integer status) {
        this.description = description;
        this.status = status;
    }

    public static AfterSaleStatus getAfterSaleStatus(Integer status) {
        AfterSaleStatus[] values = values();
        for (AfterSaleStatus value : values) {
            if (value.getStatus().equals(status)) {
                return value;
            }
        }
        return null;
    }

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
