package com.ohayou.liteshop.vo;

import java.util.List;

/**
 * @author liyan
 * @date 2020/12/7 下午9:11
 */
public class TopicGoodsListVo {

    private String content;

    private List<HotGoodsVo> hotGoodsVo;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<HotGoodsVo> getHotGoodsVo() {
        return hotGoodsVo;
    }

    public void setHotGoodsVo(List<HotGoodsVo> hotGoodsVo) {
        this.hotGoodsVo = hotGoodsVo;
    }
}
