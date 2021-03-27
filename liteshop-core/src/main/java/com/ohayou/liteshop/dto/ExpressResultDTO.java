package com.ohayou.liteshop.dto;

import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2021/3/25 下午10:36
 */
public class ExpressResultDTO {

    private String number;

    private String type;

    private String typename;

    private String logo;

    private List<Map<String,String>> list;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }
}
