package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.dto.MallGoodsAttrDto;
import com.ohayou.liteshop.dto.ProductCategoryDto;
import com.ohayou.liteshop.entity.MallCategory;
import com.ohayou.liteshop.dao.MallCategoryMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MallGoodsAttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品类目表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallCategoryServiceImpl extends ServiceImpl<MallCategoryMapper, MallCategory> implements MallCategoryService {

    @Autowired
    MallGoodsAttrService attrService;
    /**
     * 获取商品分类树
     * @return
     */
    @Override
    public List<ProductCategoryDto> getTree() {
        List<MallCategory> rootNodes = this.getRootNodes();
        List<ProductCategoryDto> collect = rootNodes.stream()
                .map(mallCategory -> {
                    ProductCategoryDto categoryDto = new ProductCategoryDto();
                    BeanUtils.copyProperties(mallCategory, categoryDto);
                    categoryDto.setChildren(getChildren(mallCategory.getId(), childrenList()));
                    return categoryDto;
                })
                .sorted(Comparator.comparing(ProductCategoryDto::getSort))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ProductCategoryDto> findCategory(String key) {
        if (StringUtils.isNotBlank(key)) {
            List<MallCategory> list = this.list(new LambdaQueryWrapper<MallCategory>().like(MallCategory::getName, key));
            if (null != list && list.size() > 0) {
                List<ProductCategoryDto> collect = list.stream()
                        .map(mallCategory -> {
                            ProductCategoryDto categoryDto = new ProductCategoryDto();
                            BeanUtils.copyProperties(mallCategory, categoryDto);
                            return categoryDto;
                        }).collect(Collectors.toList());
                return collect;
            }
        }
        return null;
    }

    /**
     * 根据id删除一个分类，如果该分类下孩子子分类则删除失败
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteNode(Long id) {
        if (null == id || 0 == id) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallCategory category = getById(id);
        if (null == category) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
        }
        //查询该分类下有无子节点
        boolean result = this.list().stream()
                .noneMatch(mallCategory -> mallCategory.getParentId().equals(category.getId()));
        if (result) {
            //如果没有关联子节点则删除该节点
            return this.removeById(id);
        }
        return false;
    }

    /**
     * 获取分类详情
     * @param id
     * @return
     */
    @Override
    public ProductCategoryDto getDetail(Long id) {
        if (null == id || 0 == id) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallCategory category = this.getById(id);
        if (null == category) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
        }
        ProductCategoryDto categoryDto = new ProductCategoryDto();

        //只有三级分类才有属性列表
        if (category.getLevel() == 2) {
            //查找该分类下的商品属性
            List<MallGoodsAttrDto> attrList = attrService.listAttrByGroupId(category.getAttrGroupId(),id);
            if (null != attrList) {
                categoryDto.setAttrs(attrList);
            }
        }

        BeanUtils.copyProperties(category,categoryDto);
        return categoryDto;
    }

    /**
     * 根据level级别查询对应的分类
     * @param level
     * @return
     */
    @Override
    public List<ProductCategoryDto> getCateByLevel(Integer level) {
        if (null == level) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<MallCategory> list = this.list(new LambdaQueryWrapper<MallCategory>().eq(MallCategory::getLevel, level));
        if (null == list || list.size() > 0) {
            List<ProductCategoryDto> collect = list.stream()
                    .map(mallCategory -> {
                        ProductCategoryDto categoryDto = new ProductCategoryDto();
                        BeanUtils.copyProperties(mallCategory, categoryDto);
                        return categoryDto;
                    })
                    .sorted(Comparator.comparing(ProductCategoryDto::getSort))
                    .collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    /**
     * 更新状态
     * @param categoryDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCategory(ProductCategoryDto categoryDto) {
        Long id = categoryDto.getId();
        if (null == id || 0 == id) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        //dto转entity
        MallCategory category = new MallCategory();
        BeanUtils.copyProperties(categoryDto,category);
        return this.updateById(category);
    }

    /**
     * 添加分类
     * @param categoryDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductCategoryDto addCategory(ProductCategoryDto categoryDto) {
        if (categoryDto == null || StringUtils.isBlank(categoryDto.getName())) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        int result = this.count(new LambdaQueryWrapper<MallCategory>().eq(MallCategory::getName, categoryDto.getName()));
        if (result > 0) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_EXIST);
        }
        MallCategory category = new MallCategory();
        BeanUtils.copyProperties(categoryDto,category);
        category.setDetail(categoryDto.getName());
        boolean saved = this.save(category);
        if (saved) {
            BeanUtils.copyProperties(category,categoryDto);
            return categoryDto;
        }
        return null;
    }

    /**
     * 根据品牌Id查询分类
     * @param brandId
     * @return
     */
    @Override
    public List<ProductCategoryDto> CategoryListByBrandId(Long brandId) {
        List<MallCategory> categoryList =  baseMapper.findCategoryListByBrandId(brandId);
        if (null != categoryList && categoryList.size() > 0) {
            List<ProductCategoryDto> collect = categoryList.stream()
                    .map(mallCategory -> {
                        ProductCategoryDto categoryDto = new ProductCategoryDto();
                        BeanUtils.copyProperties(mallCategory, categoryDto);
                        return categoryDto;
                    }).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    /**
     * 递归查找子节点
     * @param id
     * @param childrenList
     * @return
     */

    private List<ProductCategoryDto> getChildren(Long id, List<MallCategory> childrenList) {
        List<ProductCategoryDto> collect = childrenList.stream()
                .filter(mallCategory -> {
                    return id.equals(mallCategory.getParentId());
                })
                .map(mallCategory -> {
                    ProductCategoryDto categoryDto = new ProductCategoryDto();
                    BeanUtils.copyProperties(mallCategory, categoryDto);
                    categoryDto.setChildren(getChildren(mallCategory.getId(), childrenList));
                    return categoryDto;
                })
                .sorted(Comparator.comparing(ProductCategoryDto::getSort))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean categoryExist(Long categoryId) {
        return 1 == this.count(new LambdaQueryWrapper<MallCategory>().eq(MallCategory::getId,categoryId));
    }

    /**
     * 根据分类三级ID获取该id所有父节点的字符串表达形式
     * @param categoryId
     * @return
     */
    @Override
    public String getParentTreeAsString(Long categoryId) {
        MallCategory one = getById(categoryId);

        List<MallCategory> parent = this.getAllParent(categoryId);
        return parent.get(1).getName() + "/" + parent.get(0).getName() + "/" + one.getName();
    }

    /**
     * 获取三级分类所有父节点id
     * @param categoryId
     * @return
     */
    @Override
    public Long[] getParentTree(long categoryId) {
        List<MallCategory> parent = this.getAllParent(categoryId);

        MallCategory category = new MallCategory();
        category.setId(categoryId);
        parent.add(0,category);
        ListUtil.reverse(parent);
        return parent.stream()
                .map(MallCategory::getId)
                .toArray(Long[]::new);
    }

    private List<MallCategory> getAllParent(Long categoryId) {
        MallCategory one = getById(categoryId);
        //获取所有分类Id
        List<MallCategory> list = this.list();
        ArrayList<MallCategory> parentNodes = new ArrayList<>();
        return this.findParent(one, list, parentNodes);
    }
    /**
     * 递归查询所有父节点
     * @param category
     * @param all
     * @param result
     * @return
     */
    private List<MallCategory> findParent(MallCategory category, List<MallCategory> all, List<MallCategory> result) {
        for (MallCategory cate : all) {
            if (cate.getId().equals(category.getParentId())) {
                result.add(cate);
                this.findParent(cate,all,result);
            }
        }
        return result;
    }

    /**
     * 获取所有非根节点
     * @return
     */
    private List<MallCategory> childrenList() {
        return this.list(new LambdaQueryWrapper<MallCategory>().ne(MallCategory::getLevel,0));
    }

    /**
     * 获取所有根节点元素
     * @return
     */
    private List<MallCategory> getRootNodes() {
        return this.list(new LambdaQueryWrapper<MallCategory>().eq(MallCategory::getLevel,0));
    }

}
