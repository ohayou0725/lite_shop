package com.ohayou.liteshop.dto;

/**
 * @author liyan
 * @date 2020/8/18 下午3:31
 */
public class AttrValueDto {
    private Long attrId;

    private Long valueId;

    private String attr;

    private String value;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }
}
