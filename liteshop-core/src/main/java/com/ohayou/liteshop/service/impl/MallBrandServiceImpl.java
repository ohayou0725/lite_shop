package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MallBrandDto;
import com.ohayou.liteshop.entity.MallBrand;
import com.ohayou.liteshop.dao.MallBrandMapper;
import com.ohayou.liteshop.entity.MallBrandCategoryRelation;
import com.ohayou.liteshop.entity.MallCategory;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallBrandCategoryRelationService;
import com.ohayou.liteshop.service.MallBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 品牌分类表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallBrandServiceImpl extends ServiceImpl<MallBrandMapper, MallBrand> implements MallBrandService {

    @Autowired
    MallCategoryService mallCategoryService;

    @Autowired
    MallBrandCategoryRelationService mallBrandCategoryRelationService;

    @Autowired
    MallCategoryService categoryService;
    /**
     * 条件查询品牌列表
     *
     * @param brandDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(MallBrandDto brandDto, IPage<MallBrand> page) {
        LambdaQueryWrapper<MallBrand> queryWrapper = new LambdaQueryWrapper<>();
        //支持品牌名模糊查询
        queryWrapper.like(StringUtils.isNotBlank(brandDto.getName()),MallBrand::getName,brandDto.getName());
        this.page(page,queryWrapper);
        PageUtils pageUtils = new PageUtils(page);
        if (null != page.getRecords() && page.getRecords().size() > 0) {
            List<MallBrandDto> collect = page.getRecords().stream()
                    .map(mallBrand -> {
                        MallBrandDto mallBrandDto = new MallBrandDto();
                        BeanUtils.copyProperties(mallBrand, mallBrandDto);
                        mallBrandDto.setJoinTime(mallBrand.getCreateTime().toLocalDate());
                        mallBrandDto.setCategoryList(mallCategoryService.CategoryListByBrandId(mallBrand.getId()));
                        return mallBrandDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 添加品牌商信息
     * @param mallBrandDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addBrand(MallBrandDto mallBrandDto) {
        if (null == mallBrandDto.getCategoryIds()) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_ID_IS_NULL);
        }
        //判断是否已经存在该品牌商
        MallBrand brand = this.getOne(new LambdaQueryWrapper<MallBrand>().eq(MallBrand::getName, mallBrandDto.getName()));
        if (null != brand) {
            throw new GlobalException(ErrorCodeMsg.BRAND_EXIST);
        }
        MallBrand mallBrand = new MallBrand();
        BeanUtils.copyProperties(mallBrandDto,mallBrand);
        boolean save = this.save(mallBrand);
        if (save) {
            List<Long> categoryIds = mallBrandDto.getCategoryIds();
            List<MallBrandCategoryRelation> collect = categoryIds.stream()
                    .map(id -> {
                        MallBrandCategoryRelation mallBrandCategoryRelation = new MallBrandCategoryRelation();
                        mallBrandCategoryRelation.setBrandId(mallBrand.getId());
                        mallBrandCategoryRelation.setCategoryId(id);
                        return mallBrandCategoryRelation;
                    }).collect(Collectors.toList());
            return mallBrandCategoryRelationService.saveBatch(collect);
        }
        return false;
    }

    /**
     * 更新品牌商信息
     * @param mallBrandDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBrand(MallBrandDto mallBrandDto) {
        Long id = mallBrandDto.getId();
        MallBrand brand = this.getById(id);
        if (null == brand) {
            throw new GlobalException(ErrorCodeMsg.BRAND_NOT_FOUND);
        }
        BeanUtils.copyProperties(mallBrandDto,brand);
        return this.updateById(brand);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBrand(Long brandId) {
        MallBrand brand = this.getById(brandId);
        if (brand == null) {
            throw new GlobalException(ErrorCodeMsg.BRAND_NOT_FOUND);
        }
        //先删除品牌与分类关联信息
        List<MallBrandCategoryRelation> list = mallBrandCategoryRelationService.list(
                new LambdaQueryWrapper<MallBrandCategoryRelation>().eq(MallBrandCategoryRelation::getBrandId, brandId));
        if (null != list) {
            List<Long> collect = list.stream().map(MallBrandCategoryRelation::getId).collect(Collectors.toList());
            mallBrandCategoryRelationService.removeByIds(collect);
        }
        this.removeById(brandId);
    }

    /**
     * 添加品牌商分类
     * @param brandId
     * @param categoryId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCategory(Long brandId, Long categoryId) {
        if (!brandExist(brandId)) {
            throw new GlobalException(ErrorCodeMsg.BRAND_NOT_FOUND);
        }
        if (!categoryService.categoryExist(categoryId)) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
        }
        //查询该品牌分类下是否已有相同分类
        QueryWrapper<MallBrandCategoryRelation> mallBrandCategoryRelationQueryWrapper = new QueryWrapper<>();
        mallBrandCategoryRelationQueryWrapper
                .eq("brand_id",brandId)
                .eq("category_id",categoryId);
        int result = mallBrandCategoryRelationService.count(mallBrandCategoryRelationQueryWrapper);
        if ( result > 0) {
            throw new GlobalException(ErrorCodeMsg.BRAND_CATEGORY_EXIST);
        }
        MallBrandCategoryRelation mallBrandCategoryRelation = new MallBrandCategoryRelation();
        mallBrandCategoryRelation.setBrandId(brandId);
        mallBrandCategoryRelation.setCategoryId(categoryId);
        mallBrandCategoryRelationService.save(mallBrandCategoryRelation);
    }

    /**
     * 删除品牌分类
     * @param brandId
     * @param categoryId
     */
    @Override
    public void deleteCategory(Long brandId, Long categoryId) {
        if (!brandExist(brandId)) {
            throw new GlobalException(ErrorCodeMsg.BRAND_NOT_FOUND);
        }
        if (!categoryService.categoryExist(categoryId)) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
        }
        QueryWrapper<MallBrandCategoryRelation> mallBrandCategoryRelationQueryWrapper = new QueryWrapper<>();
        mallBrandCategoryRelationQueryWrapper
                .eq("brand_id",brandId)
                .eq("category_id",categoryId);
        int result = mallBrandCategoryRelationService.count(mallBrandCategoryRelationQueryWrapper);
        if ( result == 0) {
            throw new GlobalException(ErrorCodeMsg.BRAND_NOT_HAS_CATEGORY);
        }
        mallBrandCategoryRelationService.remove(mallBrandCategoryRelationQueryWrapper);
    }

    @Override
    public boolean brandExist(Long brandId) {
        return 1 == this.count(new LambdaQueryWrapper<MallBrand>().eq(MallBrand::getId, brandId));
    }

}
