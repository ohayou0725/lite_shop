package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2020/8/2 下午4:24
 */
public enum  OpinionType {
    malfunction(0,"功能异常"),
    optimization(1,"优化建议");

    private Integer type;

    private String desc;

    OpinionType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
