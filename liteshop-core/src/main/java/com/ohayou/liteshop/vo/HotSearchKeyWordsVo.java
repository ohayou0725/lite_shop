package com.ohayou.liteshop.vo;

/**
 * @author liyan
 * @date 2020/12/5 下午9:39
 */
public class HotSearchKeyWordsVo {

    private String text;

    private Double score;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
