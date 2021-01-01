package com.ohayou.liteshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品类目表
 * </p>
 *
 * @author ohayou
 * @since 2020-07-29
 */
public class MallCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品类目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 商品级别 0-一级 1 1-二级 2-三级
     */
    private Integer level;

    /**
     * 父级分类id
     */
    private Long parentId;

    /**
     * 类目图片
     */
    private String img;

    /**
     * 类目图标
     */
    private String icon;

    /**
     * 是否为热门分类
     */
    private Integer hot;

    /**
     * 类目参数id
     */
    private Long attrGroupId;

    /**
     * 类目描述
     */
    private String detail;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最近修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除 1-已删除 0-未删除
     */
    @TableLogic
    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getLevel() {
        return level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "MallCategory{" +
            "id=" + id +
            ", name=" + name +
            ", level=" + level +
            ", parentId=" + parentId +
            ", img=" + img +
            ", icon=" + icon +
            ", attrGroupId=" + attrGroupId +
            ", detail=" + detail +
            ", sort=" + sort +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
