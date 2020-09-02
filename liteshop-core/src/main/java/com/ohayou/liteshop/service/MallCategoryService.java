package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.ProductCategoryDto;
import com.ohayou.liteshop.entity.MallCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品类目表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallCategoryService extends IService<MallCategory> {

    List<ProductCategoryDto> getTree();

    List<ProductCategoryDto> findCategory(String key);

    boolean deleteNode(Long id);

    ProductCategoryDto getDetail(Long id);

    List<ProductCategoryDto> getCateByLevel(Integer level);

    boolean updateCategory(ProductCategoryDto categoryDto);

    ProductCategoryDto addCategory(ProductCategoryDto categoryDto);

    List<ProductCategoryDto> CategoryListByBrandId(Long brandId);

    boolean categoryExist(Long categoryId);

    String getParentTreeAsString(Long categoryId);

    Long[] getParentTree(long categoryId);
}
