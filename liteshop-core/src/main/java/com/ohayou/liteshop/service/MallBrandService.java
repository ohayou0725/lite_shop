package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MallBrandDto;
import com.ohayou.liteshop.dto.ProductCategoryDto;
import com.ohayou.liteshop.entity.MallBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

import java.util.List;

/**
 * <p>
 * 品牌分类表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallBrandService extends IService<MallBrand> {

    PageUtils queryPage(MallBrandDto brandDto,IPage<MallBrand> page);

    boolean addBrand(MallBrandDto mallBrandDto);

    boolean updateBrand(MallBrandDto mallBrandDto);

    void deleteBrand(Long brandId);

    void addCategory(Long brandId, Long categoryId);

    void deleteCategory(Long brandId, Long categoryId);

    boolean brandExist(Long brandId);
}
