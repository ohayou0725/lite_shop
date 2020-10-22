package com.ohayou.liteshop.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2020/8/18 下午3:36
 */
public class GoodsSkuDto {

    /**
     * 新增sku校验分组
     */
    public interface AddSkuValid{}

    /**
     * 更新sku校验分组
     */
    public interface UpdateSkuValid{}

    @NotNull(groups = {UpdateSkuValid.class})
    private Long skuId;


    List<SpecAndValueDto> specAndValueList;

    private String title;

    @Digits(groups = {AddSkuValid.class,UpdateSkuValid.class}, integer = Integer.MAX_VALUE,fraction = 0,message = "库存必须为数字")
    @Min(groups = {AddSkuValid.class,UpdateSkuValid.class},value = 0,message = "库存不能为负数")
    @NotNull(groups = {AddSkuValid.class,UpdateSkuValid.class},message = "库存不能为空")
    private Integer stock;

    private Integer sales;

    @Min(groups = {AddSkuValid.class,UpdateSkuValid.class},value = 0,message = "预警库存不能为负数")
    @Digits(groups = {AddSkuValid.class,UpdateSkuValid.class},integer = Integer.MAX_VALUE,fraction = 0,message = "预警库存必须为数字")
    @NotNull(groups = {AddSkuValid.class},message = "预警库存不能为空")
    private Integer stockWarningCount;

    @NotNull(message = "价格不能为空",groups = {AddSkuValid.class,UpdateSkuValid.class})
    @DecimalMin(value = "0.01",message = "金额最低为0.01",groups = {AddSkuValid.class,UpdateSkuValid.class})
    private BigDecimal price;

    @NotEmpty(message = "必须上传图片",groups = {AddSkuValid.class})
    private String img;

    @NotBlank(message = "规格编号不能为空",groups = {AddSkuValid.class})
    private String specSn;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<SpecAndValueDto> getSpecAndValueList() {
        return specAndValueList;
    }

    public void setSpecAndValueList(List<SpecAndValueDto> specAndValueList) {
        this.specAndValueList = specAndValueList;
    }

    public String getSpecSn() {
        return specSn;
    }

    public void setSpecSn(String specSn) {
        this.specSn = specSn;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getStockWarningCount() {
        return stockWarningCount;
    }

    public void setStockWarningCount(Integer stockWarningCount) {
        this.stockWarningCount = stockWarningCount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
