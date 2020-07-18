package com.ohayou.liteshop.vo;

import java.util.List;

/**
 * @author liyan
 * @date 2020/7/18 上午11:16
 */
public class AdminMenuVo {

    private Long id;

    private String title;

    private Integer level;

    private String name;

    private String icon;

    private boolean hidden;
    private Integer sort;

    private List<AdminMenuVo> children;


    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AdminMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<AdminMenuVo> children) {
        this.children = children;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
