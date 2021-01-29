package com.ohayou.liteshop.vo;

import java.util.List;

/**
 * @author liyan
 * @date 2021/1/2 下午10:06
 */
public class SpecVo {
    private String k ;

    private String id;

    private List<SpecValueVo> v;

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public List<SpecValueVo> getV() {
        return v;
    }

    public void setV(List<SpecValueVo> v) {
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
