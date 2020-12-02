package com.ohayou.liteshop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 专题表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-29
 */
public class MallTopic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专题id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 标题
     */
    private String title;

    /**
     * 子标题
     */
    private String subtitle;

    /**
     * 正文
     */
    private String content;

    /**
     * 专题商品最低价
     */
    private BigDecimal price;

    /**
     * 阅读量
     */
    private Integer readCount;

    /**
     * 专题图片
     */
    private String imgs;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 前台是否显示
     */
    private Integer isShow;

    /**
     * 前台显示位置
     */
    private Integer position;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }


    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "MallTopic{" +
            "id=" + id +
            ", title=" + title +
            ", subtitle=" + subtitle +
            ", content=" + content +
            ", price=" + price +
            ", readCount=" + readCount +
            ", imgs=" + imgs +
            ", sort=" + sort +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
