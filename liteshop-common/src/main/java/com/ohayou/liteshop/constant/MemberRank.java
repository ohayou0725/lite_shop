package com.ohayou.liteshop.constant;

/**
 * @author liyan
 * @date 2021/1/10 下午2:53
 */
public enum MemberRank {
    GENERAL_USER("普通用户"),
    GOLD_USER("黄金会员");


    private String rank;

    MemberRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
