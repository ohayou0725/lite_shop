package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.*;
import com.ohayou.liteshop.dao.MallGoodsSpuMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.GoodsSpecUtil;
import com.ohayou.liteshop.utils.ListUtil;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品spu信息表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallGoodsSpuServiceImpl extends ServiceImpl<MallGoodsSpuMapper, MallGoodsSpu> implements MallGoodsSpuService {

    @Autowired
    MallBrandService mallBrandService;

    @Autowired
    MallGoodsSkuService mallGoodsSkuService;

    @Autowired
    MallCategoryService categoryService;

    @Autowired
    MallGoodsAttrService mallGoodsAttrService;

    @Autowired
    MallAttrValueService attrValueService;

    @Autowired
    MallGoodsSpecService specService;

    @Autowired
    MallGoodsSpecValueService specValueService;

    @Autowired
    MallCategoryGoodsRelationService categoryGoodsRelationService;

    @Autowired
    MallBrandGoodsRelationService mallBrandGoodsRelationService;

    @Autowired
    MallGoodsAttrService goodsAttrService;

    @Autowired
    MallGoodsSpecValueService goodsSpecValueService;


    /**
     * 条件查询商品列表
     *
     * @param mallGoodsSpuDto
     * @param page
     * @return
     */
    @Override
    public PageUtils getPage(MallGoodsSpuDto mallGoodsSpuDto, IPage<MallGoodsSpu> page) {
        LambdaQueryWrapper<MallGoodsSpu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(mallGoodsSpuDto.getGoodsSn()), MallGoodsSpu::getGoodsSn, mallGoodsSpuDto.getGoodsSn());
        wrapper.eq(null != mallGoodsSpuDto.getStatus(), MallGoodsSpu::getStatus, mallGoodsSpuDto.getStatus());
        wrapper.eq(null != mallGoodsSpuDto.getHot(), MallGoodsSpu::getHot, mallGoodsSpuDto.getHot());
        wrapper.eq(null != mallGoodsSpuDto.getIsNew(), MallGoodsSpu::getIsNew, mallGoodsSpuDto.getIsNew());
        wrapper.like(StringUtils.isNotBlank(mallGoodsSpuDto.getName()), MallGoodsSpu::getName, mallGoodsSpuDto.getName());
        //品牌参数查询
        if (StringUtils.isNotBlank(mallGoodsSpuDto.getBrand())) {
            MallBrand one = mallBrandService.getOne(new LambdaQueryWrapper<MallBrand>().eq(MallBrand::getName, mallGoodsSpuDto.getBrand()));
            if (null == one) {
                return new PageUtils(page);
            }
            wrapper.eq(MallGoodsSpu::getBrandId, one.getId());
        }
        if (null != mallGoodsSpuDto.getCategoryIds() && mallGoodsSpuDto.getCategoryIds().length > 0) {
            wrapper.eq(MallGoodsSpu::getCategoryId,mallGoodsSpuDto.getCategoryIds()[0]);
        }

        this.page(page, wrapper);
        PageUtils pageUtils = new PageUtils(page);

        if (null != page.getRecords() && page.getRecords().size() > 0) {
            List<MallGoodsSpuDto> collect = page.getRecords().stream()
                    .map(mallGoodsSpu -> {
                        MallGoodsSpuDto goodsSpuDto = new MallGoodsSpuDto();
                        BeanUtils.copyProperties(mallGoodsSpu, goodsSpuDto);
                        goodsSpuDto.setCategoryIds(categoryService.getParentTree(mallGoodsSpu.getCategoryId()));
                        goodsSpuDto.setReservePrice(mallGoodsSpu.getPrice().toString());
                        goodsSpuDto.setGalleryList(Arrays.asList(mallGoodsSpu.getGallery().split(",")));
                        MallBrand one = mallBrandService.getById(mallGoodsSpu.getBrandId());
                        if (null != one) {
                            goodsSpuDto.setBrand(one.getName());
                            goodsSpuDto.setBrandLogo(one.getLogo());
                        }
                        goodsSpuDto.setStock(this.getStock(mallGoodsSpu.getId()));
                        return goodsSpuDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 查询商品详情信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public GoodsDetailDto getDetail(Long goodsId) {
        MallGoodsSpu goodsSpu = this.getById(goodsId);
        if (null == goodsSpu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        GoodsDetailDto goodsDetailDto = new GoodsDetailDto();
        BeanUtils.copyProperties(goodsSpu, goodsDetailDto);
        goodsDetailDto.setGalleryList(Arrays.asList(goodsSpu.getGallery().split(",")));
        //查询商品分类
        String category = categoryService.getParentTreeAsString(goodsSpu.getCategoryId());
        goodsDetailDto.setCategory(category);
        goodsDetailDto.setAttrValueList(this.getAllAttrAndValue(goodsId));
        List<GoodsSkuDto> goodsSpecs = mallGoodsSkuService.getGoodsSku(goodsId);
        goodsDetailDto.setGoodsSpecList(goodsSpecs);
        return goodsDetailDto;
    }

    /**
     * 获取spu总库存
     */
    private Integer getStock(Long spuId) {
        //查询到商品sku信息后对sku库存进行累加
        List<MallGoodsSku> list = mallGoodsSkuService.list(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getGoodsId, spuId));
        if (null != list && list.size() > 0) {
            return list.stream()
                    .map(MallGoodsSku::getStock)
                    .reduce(0, Integer::sum);
        }
        return 0;
    }

    /**
     * 根据商品id查询所有商品属性和对应值
     *
     * @param goodsId
     * @return
     */
    public List<AttrValueDto> getAllAttrAndValue(Long goodsId) {
        //查询商品所有属性名并根据id进行排序
        List<MallGoodsAttr> attrs = mallGoodsAttrService.findAttrsByGoodsId(goodsId);
        //获取所有属性值并根据attrId排序
        LambdaQueryWrapper<MallAttrValue> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MallAttrValue::getSpuId, goodsId);
        wrapper.orderByAsc(MallAttrValue::getAttrId);
        List<MallAttrValue> values = attrValueService.list(wrapper);
        //设置属性和值
        List<AttrValueDto> attrValueDtoList = new LinkedList<>();
        for (int i = 0; i < attrs.size(); i++) {
            MallGoodsAttr attr = attrs.get(i);
            MallAttrValue value = values.get(i);
            if (attr != null && value != null) {
                AttrValueDto attrValueDto = new AttrValueDto();
                attrValueDto.setAttr(attr.getAttrName());
                attrValueDto.setAttrId(attr.getId());
                attrValueDto.setValue(value.getAttrValue());
                attrValueDto.setValueId(value.getId());
                attrValueDtoList.add(attrValueDto);
            }
        }
        return attrValueDtoList;
    }

    /**
     * 新增商品sku信息
     *
     * @param goodsFormDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addGoodsSpu(GoodsFormDto goodsFormDto) {
        String goodsSn = goodsFormDto.getGoodsSn();
        //查询该商品是否已经存在,或者是否存在同名的商品
        MallGoodsSpu one = this.baseMapper.findGoodsByGoodsSnOrName(goodsSn, goodsFormDto.getName());
        if (one != null) {
            throw new GlobalException(ErrorCodeMsg.GOODS_EXIST);
        }
        //查询分类是否存在
        MallCategory category = categoryService.getById(goodsFormDto.getCategoryId());
        if (null == category) {
            throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
        }
        //查询品牌商是否存在
        int count = mallBrandService.count(new LambdaQueryWrapper<MallBrand>()
                .eq(MallBrand::getId, goodsFormDto.getBrandId()));
        if (count < 1) {
            throw new GlobalException(ErrorCodeMsg.BRAND_NOT_FOUND);
        }
        MallGoodsSpu goodsSpu = new MallGoodsSpu();
        Long attrGroupId = category.getAttrGroupId();
        goodsSpu.setAttrGroupId(attrGroupId);
        BeanUtils.copyProperties(goodsFormDto, goodsSpu);
        boolean save = this.save(goodsSpu);

        if (save) {
            //新增分类关系
            MallCategoryGoodsRelation mallCategoryGoodsRelation = new MallCategoryGoodsRelation();
            mallCategoryGoodsRelation.setCategoryId(goodsSpu.getCategoryId());
            mallCategoryGoodsRelation.setGoodsId(goodsSpu.getId());
            boolean result1 = categoryGoodsRelationService.save(mallCategoryGoodsRelation);
            if (!result1) {
                throw new GlobalException(ErrorCodeMsg.SAVE_GOODS_ERROR);
            }
            //新增品牌关系
            MallBrandGoodsRelation mallBrandGoodsRelation = new MallBrandGoodsRelation();
            mallBrandGoodsRelation.setBrandId(goodsSpu.getBrandId());
            mallBrandGoodsRelation.setGoodsId(goodsSpu.getId());
            boolean result2 = mallBrandGoodsRelationService.save(mallBrandGoodsRelation);
            if (!result2) {
                throw new GlobalException(ErrorCodeMsg.SAVE_GOODS_ERROR);
            }
            //新增属性值,首先判断属性ID是否与数据库一致
            List<MallGoodsAttr> attrList = mallGoodsAttrService.listByGroupId(goodsSpu.getAttrGroupId());
            List<Long> collect1 = attrList.stream()
                    .map(MallGoodsAttr::getId)
                    .sorted(Comparator.comparing(Long::longValue))
                    .collect(Collectors.toList());
            List<AttrValueDto> attrValues = goodsFormDto.getAttrValues();
            List<Long> collect2 = attrValues.stream()
                    .map(AttrValueDto::getAttrId)
                    .sorted(Comparator.comparing(Long::longValue))
                    .collect(Collectors.toList());

            if (!ListUtil.equals(collect1, collect2)) {
                throw new GlobalException(ErrorCodeMsg.SAVE_GOODS_ERROR);
            }

            List<MallAttrValue> attrValueList = new LinkedList<>();
            attrValues.forEach(attrValue -> {
                MallAttrValue mallAttrValue = new MallAttrValue();
                mallAttrValue.setAttrId(attrValue.getAttrId());
                mallAttrValue.setAttrValue(attrValue.getValue());
                mallAttrValue.setSpuId(goodsSpu.getId());
                attrValueList.add(mallAttrValue);
            });
            boolean result3 = attrValueService.saveBatch(attrValueList);
            if (!result3) {
                throw new GlobalException(ErrorCodeMsg.SAVE_GOODS_ERROR);
            }
            //添加商品规格信息
            List<MallGoodsSpecDto> specs = goodsFormDto.getSpecs();
            if (CollUtil.isEmpty(specs)) {
                throw new GlobalException(ErrorCodeMsg.GOODS_SPEC_EMPTY);
            }
            List<MallGoodsSpec> specList = specs.stream().
                    map(MallGoodsSpecDto::getSpec).collect(Collectors.toList());
            specList.forEach(spec -> {
                spec.setGoodsId(goodsSpu.getId());
            });

            boolean result4 = specService.saveBatch(specList);
            if (!result4) {
                throw new GlobalException(ErrorCodeMsg.SAVE_GOODS_ERROR);
            }
            //添加商品规格属性
            //判断属性时候为空
            specs.forEach(spec -> {
                if (spec.getValues().size() < 1) {
                    throw new GlobalException(ErrorCodeMsg.GOODS_SPEC_EMPTY);
                }
            });
            List<MallGoodsSpecValue> collect = specs.stream().
                    flatMap(spec -> {
                        if (CollUtil.isEmpty(spec.getValues())) {
                            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
                        }
                        return spec.getValues().stream()
                            .peek(value-> value.setSpecId(spec.getSpec().getId()));
                    }).collect(Collectors.toList());
            boolean result5 = goodsSpecValueService.saveBatch(collect);
            if (!result5) {
                throw new GlobalException(ErrorCodeMsg.SAVE_GOODS_ERROR);
            }
            return true;
        }
        return false;
    }

    /**
     * 更新商品基本信息
     *
     * @param goodsFormDto
     * @return
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBasicInfo(GoodsFormDto goodsFormDto) {
        if (null == goodsFormDto.getId() || goodsFormDto.getId() < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        //根据id查询商品信息
        MallGoodsSpu goodsSpu = this.getById(goodsFormDto.getId());
        if (null == goodsSpu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }

        MallGoodsSpu newGoodsSpu = new MallGoodsSpu();
        BeanUtils.copyProperties(goodsFormDto, newGoodsSpu);
        boolean result = this.updateById(newGoodsSpu);
        if (result) {
            //spu更新成功后判断更新前后分类id和品牌id是否有更改，如有更改还需更新商品他们之间的关联关系
            if (!newGoodsSpu.getCategoryId().equals(goodsSpu.getCategoryId())) {
                //分类ID有更改则更改分类与之关联关系
                MallCategoryGoodsRelation one = categoryGoodsRelationService.getOne(new LambdaQueryWrapper<MallCategoryGoodsRelation>()
                        .eq(MallCategoryGoodsRelation::getCategoryId, goodsSpu.getCategoryId())
                        .eq(MallCategoryGoodsRelation::getGoodsId, goodsSpu.getCategoryId()));
                if (one == null) {
                    throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
                }
                MallCategoryGoodsRelation mallCategoryGoodsRelation = new MallCategoryGoodsRelation();
                mallCategoryGoodsRelation.setCategoryId(newGoodsSpu.getCategoryId());
                mallCategoryGoodsRelation.setGoodsId(newGoodsSpu.getId());
                mallCategoryGoodsRelation.setId(one.getId());
                if (!categoryGoodsRelationService.updateById(mallCategoryGoodsRelation)) {
                    throw new GlobalException(ErrorCodeMsg.UPDATE_GOODS_INFO_ERROR);
                }
                //分类关系更新成功后还需更新商品与属性关系，并删除之前商品属性值
                MallCategory category = categoryService.getById(newGoodsSpu.getCategoryId());
                if (null == category) {
                    throw new GlobalException(ErrorCodeMsg.CATEGORY_NOT_FOUND);
                }
                newGoodsSpu.setAttrGroupId(category.getAttrGroupId());
                if (!this.updateById(newGoodsSpu)) {
                    throw new GlobalException(ErrorCodeMsg.UPDATE_GOODS_INFO_ERROR);
                }
                //删除商品之前属性值
                List<MallAttrValue> list = attrValueService.list(new LambdaQueryWrapper<MallAttrValue>()
                        .eq(MallAttrValue::getSpuId, newGoodsSpu.getId()));
                List<Long> collect = list.stream()
                        .map(MallAttrValue::getId).collect(Collectors.toList());
                goodsAttrService.removeByIds(collect);

            }
            //判断品牌与商品关联有无修改
            if (!newGoodsSpu.getBrandId().equals(goodsSpu.getBrandId())) {
                MallBrandGoodsRelation one = mallBrandGoodsRelationService.getOne(new LambdaQueryWrapper<MallBrandGoodsRelation>()
                        .eq(MallBrandGoodsRelation::getBrandId, goodsSpu.getBrandId())
                        .eq(MallBrandGoodsRelation::getGoodsId, goodsSpu.getId()));
                if (null != one) {
                    MallBrandGoodsRelation mallBrandGoodsRelation = new MallBrandGoodsRelation();
                    mallBrandGoodsRelation.setBrandId(newGoodsSpu.getBrandId());
                    mallBrandGoodsRelation.setGoodsId(newGoodsSpu.getId());
                    mallBrandGoodsRelation.setId(one.getId());
                    if (!mallBrandGoodsRelationService.updateById(mallBrandGoodsRelation)) {
                        throw new GlobalException(ErrorCodeMsg.UPDATE_GOODS_INFO_ERROR);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 修改商品属性值
     *
     * @param goodsFormDto
     * @return
     */
    @Override
    public boolean updateAttr(GoodsFormDto goodsFormDto) {
        Long id = goodsFormDto.getId();
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        MallGoodsSpu goodsSpu = this.getById(id);
        if (null == goodsSpu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }

        List<AttrValueDto> attrValues = goodsFormDto.getAttrValues();
        if (CollUtil.isEmpty(attrValues)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        List<AttrValueDto> allAttrAndValue = this.getAllAttrAndValue(id);

        //判断前端传来的属性id列表是否与数据库一致
        List<Long> collect = attrValues.stream().map(AttrValueDto::getValueId).collect(Collectors.toList());
        List<Long> collect1 = allAttrAndValue.stream().map(AttrValueDto::getValueId).collect(Collectors.toList());
        if (!ListUtil.equals(collect, collect1)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        List<MallAttrValue> collect2 = attrValues.stream()
                .map(attrValueDto -> {
                    MallAttrValue mallAttrValue = new MallAttrValue();
                    mallAttrValue.setId(attrValueDto.getValueId());
                    mallAttrValue.setAttrValue(attrValueDto.getValue());
                    mallAttrValue.setAttrId(attrValueDto.getAttrId());
                    mallAttrValue.setSpuId(id);
                    return mallAttrValue;
                }).collect(Collectors.toList());
        return attrValueService.updateBatchById(collect2);
    }

    /**
     * 修改商品规格
     *
     * @param goodsFormDto
     * @return
     */
    @Override
    public boolean updateSpec(GoodsFormDto goodsFormDto) {
        Long id = goodsFormDto.getId();
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<MallGoodsSpecDto> specs = goodsFormDto.getSpecs();
        if (CollUtil.isEmpty(specs)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<MallGoodsSpec> specList = specs.stream()
                .map(spec -> {
                    MallGoodsSpec mallGoodsSpec = new MallGoodsSpec();
                    mallGoodsSpec.setName(spec.getSpec().getName());
                    mallGoodsSpec.setId(spec.getSpec().getId());
                    mallGoodsSpec.setSort(spec.getSpec().getSort());
                    return mallGoodsSpec;
                }).collect(Collectors.toList());
        if (specService.updateBatchById(specList)) {
            //更新商品规格属性
            List<MallGoodsSpecValue> newSpecValues = specs.stream().
                    flatMap(spec -> {
                        List<MallGoodsSpecValue> values = spec.getValues();
                        if (CollUtil.isEmpty(values)) {
                            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
                        }
                        return values.stream();
                    }).collect(Collectors.toList());

            List<MallGoodsSpecValue> oldSpecValues = goodsSpecValueService.listByGoodsId(id);
            //判断是否有删除了属性
            if (oldSpecValues.size() > newSpecValues.size()) {
                //如果有删除则判断单品中是否有该规格值
                List<Long> longList = CollUtil.subtractToList(oldSpecValues, newSpecValues).stream().map(MallGoodsSpecValue::getId).collect(Collectors.toList());
                List<MallGoodsSku> skuList = mallGoodsSkuService.list(new LambdaQueryWrapper<MallGoodsSku>()
                        .eq(MallGoodsSku::getGoodsId, id));
                if (CollUtil.isNotEmpty(skuList)) {
                    List<Long> valueIdList = skuList.stream()
                            .flatMap(sku -> {
                                Map<Long, Long> specIdAndValueId = GoodsSpecUtil.getSpecIdAndValueId(sku.getSpecSn());
                                return specIdAndValueId.values().stream();
                            }).collect(Collectors.toList());

                    Collection<Long> intersection = CollUtil.intersection(valueIdList, longList);
                    if (CollUtil.isNotEmpty(intersection)) {
                        throw new GlobalException(ErrorCodeMsg.GOODS_SPEC_VALUE_CANT_DELETE);
                    }
                }
                boolean result = goodsSpecValueService.removeByIds(longList);
                if (!result) {
                    throw new GlobalException(ErrorCodeMsg.UPDATE_GOODS_INFO_ERROR);
                }

            }
            //如果新增了规格值，则对新增的规格值进行保存
            return  goodsSpecValueService.saveOrUpdateBatch(newSpecValues);

        }
        return false;
    }

    /**
     * 更改商品状态
     *
     * @param goodsFormDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeStatus(GoodsFormDto goodsFormDto) {
        Long id = goodsFormDto.getId();
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        Integer status = goodsFormDto.getStatus();
        if (null == status) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallGoodsSpu goodsSpu = new MallGoodsSpu();
        goodsSpu.setId(id);
        goodsSpu.setStatus(status);
        return this.updateById(goodsSpu);
    }

    /**
     * 修改商品详情页显示信息
     *
     * @param goodsFormDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateDetail(GoodsFormDto goodsFormDto) {
        Long id = goodsFormDto.getId();
        if (id == null || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallGoodsSpu mallGoodsSpu = new MallGoodsSpu();
        mallGoodsSpu.setId(id);
        mallGoodsSpu.setDetail(goodsFormDto.getDetail());
        return this.updateById(mallGoodsSpu);
    }

    @Override
    public List<MallGoodsSpecDto> getSpecsById(Long id) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        LambdaQueryWrapper<MallGoodsSpec> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MallGoodsSpec::getGoodsId, id);
        List<MallGoodsSpec> specs = specService.list(wrapper);
        return specs.stream()
                .map(spec->{
                    MallGoodsSpecDto mallGoodsSpecDto = new MallGoodsSpecDto();
                    mallGoodsSpecDto.setSpec(spec);
                    List<MallGoodsSpecValue> list = specValueService.list(new LambdaQueryWrapper<MallGoodsSpecValue>().eq(MallGoodsSpecValue::getSpecId, spec.getId()));
                    mallGoodsSpecDto.setValues(list);
                    return mallGoodsSpecDto;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteGoods(Long id) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallGoodsSpu goodsSpu = this.getById(id);
        if (null == goodsSpu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        //判断该商品是否在售，如果在售需先对其进行下架
        if (goodsSpu.getStatus().equals(1) || this.getStock(id) != 0) {
            throw new GlobalException(ErrorCodeMsg.GOODS_IN_STOCK);
        }
        boolean result = this.removeById(id);
        if (!result) {
            return false;
        }
        //删除该商品与所属分类的关系
        boolean categoryRelationRemove = categoryGoodsRelationService.remove(new LambdaQueryWrapper<MallCategoryGoodsRelation>()
                .eq(MallCategoryGoodsRelation::getGoodsId, id));
        if (!categoryRelationRemove) {
            throw new GlobalException(ErrorCodeMsg.DELETE_GOODS_ERROR);
        }
        //删除该商品与品牌所属的关系
        boolean brandRelationRemove = mallBrandGoodsRelationService.remove(new LambdaQueryWrapper<MallBrandGoodsRelation>()
                .eq(MallBrandGoodsRelation::getGoodsId, id));
        if (!brandRelationRemove) {
            throw new GlobalException(ErrorCodeMsg.DELETE_GOODS_ERROR);
        }
        //删除属性信息
        boolean attrRemove = attrValueService.remove(new LambdaQueryWrapper<MallAttrValue>()
                .eq(MallAttrValue::getSpuId, id));
        if (!attrRemove) {
            throw new GlobalException(ErrorCodeMsg.DELETE_GOODS_ERROR);
        }
        //删除规格信息
        boolean specRemove = specService.remove(new LambdaQueryWrapper<MallGoodsSpec>()
                .eq(MallGoodsSpec::getGoodsId, id));
        if (!specRemove) {
            throw new GlobalException(ErrorCodeMsg.DELETE_GOODS_ERROR);
        }
        //删除sku信息,如果没有sku信息则直接返回
        LambdaQueryWrapper<MallGoodsSku> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MallGoodsSku::getGoodsId, id);
        int count = mallGoodsSkuService.count(wrapper);
        if (count > 0) {
            boolean skuRemove = mallGoodsSkuService.remove(wrapper);
            if (!skuRemove) {
                throw new GlobalException(ErrorCodeMsg.DELETE_GOODS_ERROR);
            }
        }

        return true;
    }


    /**
     * 根据商品sn获取该商品所有规格信息
     * @param goodsSn
     * @return
     */
    @Override
    public List<MallGoodsSpecDto> specListByGoodsSn(String goodsSn) {
        if (StringUtils.isBlank(goodsSn)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallGoodsSpu one = this.getOne(new LambdaQueryWrapper<MallGoodsSpu>().eq(MallGoodsSpu::getGoodsSn, goodsSn));
        if (null == one) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        List<MallGoodsSpecDto> specs = this.getSpecsById(one.getId());
        specs.forEach(spec->{
            spec.setGoodsId(one.getId());
            spec.setTitle(one.getTitle());
        });
        return specs;
    }

    @Override
    public List<MallGoodsSpu> goodsListByTopicId(Long topicId) {
        if (null == topicId || topicId < 1) {
            return null;
        }
        return baseMapper.goodsListByTopicId(topicId);
    }

    /**
     * 查询sku的规格值列表
     *
     * @param specAndValueId
     * @return
     */
    private List<SpecAndValueDto> getSpecAndValue(Map<Long, Long> specAndValueId
            , List<MallGoodsSpec> goodsSpecs
            , List<MallGoodsSpecValue> specValues) {
        List<SpecAndValueDto> collect = specAndValueId.entrySet().stream()
                .map((specs) -> {
                    SpecAndValueDto specAndValueDto = new SpecAndValueDto();
                    specAndValueDto.setSpecId(specs.getKey());
                    specAndValueDto.setValueId(specs.getValue());
                    specAndValueDto.setSpec(this.getSpecBySpuSpecId(specs.getKey(), goodsSpecs));
                    specAndValueDto.setValue(this.getValueBySpuValueId(specs.getValue(), specValues));
                    return specAndValueDto;
                }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 设置规格名
     *
     * @param specId
     * @param specs
     * @return
     */
    public  String getSpecBySpuSpecId(Long specId, List<MallGoodsSpec> specs) {
        MallGoodsSpec mallGoodsSpec = specs.stream()
                .filter(spec -> {
                    return spec.getId().equals(specId);
                })
                .findAny().orElse(null);
        return mallGoodsSpec != null ? mallGoodsSpec.getName() : "";
    }

    /**
     * 设置规格值
     *
     * @param valueId
     * @param specValues
     * @return
     */
    public  String getValueBySpuValueId(Long valueId, List<MallGoodsSpecValue> specValues) {
        MallGoodsSpecValue mallGoodsSpecValue = specValues.stream()
                .filter(value -> {
                    return value.getId().equals(valueId);
                })
                .findAny().orElse(null);
        return mallGoodsSpecValue != null ? mallGoodsSpecValue.getSpecValue() : "";
    }
}
