package com.ohayou.liteshop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 运费设置表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public class SysFreightConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 运费配置id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运费价格
     */
    private BigDecimal freightPrice;

    /**
     * 满足免运费的金额
     */
    private BigDecimal reliefAmount;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }
    public BigDecimal getReliefAmount() {
        return reliefAmount;
    }

    public void setReliefAmount(BigDecimal reliefAmount) {
        this.reliefAmount = reliefAmount;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "SysFreightConfig{" +
            "id=" + id +
            ", freightPrice=" + freightPrice +
            ", reliefAmount=" + reliefAmount +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
