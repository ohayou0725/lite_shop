package com.ohayou.liteshop.vo;

import java.util.List;

/**
 * @author liyan
 * @date 2020/12/3 下午3:50
 */
public class CategoryContentVo {

    private BannerVo bannerVo;

    private List<CategoryItemVo> categoryItemVo;

    public BannerVo getBannerVo() {
        return bannerVo;
    }

    public void setBannerVo(BannerVo bannerVo) {
        this.bannerVo = bannerVo;
    }

    public List<CategoryItemVo> getCategoryItemVo() {
        return categoryItemVo;
    }

    public void setCategoryItemVo(List<CategoryItemVo> categoryItemVo) {
        this.categoryItemVo = categoryItemVo;
    }
}
