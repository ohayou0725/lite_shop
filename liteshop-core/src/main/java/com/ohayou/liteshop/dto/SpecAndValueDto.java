package com.ohayou.liteshop.dto;

/**
 * @author liyan
 * @date 2020/8/19 下午9:57
 */
public class SpecAndValueDto {

    private Long specId;

    private Long valueId;

    private String spec;

    private String value;

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
