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
    MallGoodsSkuService skuService;

    @Autowired
    MallGoodsSpecService specService;

    @Autowired
    MallGoodsSpecValueService specValueService;

    @Autowired
    MallCategoryGoodsRelationService categoryGoodsRelationService;

    @Autowired
    MallBrandGoodsRelationService mallBrandGoodsRelationService;

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
        wrapper.eq(null != mallGoodsSpuDto.getCategoryId(), MallGoodsSpu::getCategoryId, mallGoodsSpuDto.getCategoryId());
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
        this.page(page, wrapper);
        PageUtils pageUtils = new PageUtils(page);

        if (null != page.getRecords() && page.getRecords().size() > 0) {
            List<MallGoodsSpuDto> collect = page.getRecords().stream()
                    .map(mallGoodsSpu -> {
                        MallGoodsSpuDto goodsSpuDto = new MallGoodsSpuDto();
                        BeanUtils.copyProperties(mallGoodsSpu, goodsSpuDto);
                        goodsSpuDto.setReservePrice(mallGoodsSpu.getPrice().toString());
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
        String category = categoryService.getTreeAsString(goodsSpu.getCategoryId());
        goodsDetailDto.setCategory(category);
        goodsDetailDto.setAttrValueList(this.getAllAttrAndValue(goodsId));
        List<GoodsSkuDto> goodsSpecs = this.getGoodsSpecs(goodsId);
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
                    .map(MallGoodsAttr::getId).collect(Collectors.toList());
            List<AttrValueDto> attrValues = goodsFormDto.getAttrValues();
            List<Long> collect2 = attrValues.stream()
                    .map(AttrValueDto::getAttrId).collect(Collectors.toList());
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
            List<MallGoodsSpec> specs = goodsFormDto.getSpecs();
            if (CollUtil.isEmpty(specs)) {
                throw new GlobalException(ErrorCodeMsg.GOODS_SPEC_EMPTY);
            }
            specs.forEach(spec -> {
                spec.setGoodsId(goodsSpu.getId());
            });
            boolean result4 = specService.saveBatch(specs);
            if (!result4) {
                throw new  GlobalException(ErrorCodeMsg.SAVE_GOODS_ERROR);
            }
            return true;
        }
        return false;
    }

    /**
     * 根据商品ID查询所有sku规格
     *
     * @param goodsId
     * @return
     */
    public List<GoodsSkuDto> getGoodsSpecs(Long goodsId) {
        //获取sku信息
        List<MallGoodsSku> skuList = skuService.list(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getGoodsId, goodsId));
        if (skuList == null || skuList.size() < 1) {
            return null;
        }
        //查询sku所有规格参数
        List<MallGoodsSpec> goodsSpecs = specService.list(new LambdaQueryWrapper<MallGoodsSpec>().eq(MallGoodsSpec::getGoodsId, goodsId));
        List<GoodsSkuDto> goodsSkuDtoList = new ArrayList<>();
        //查询所有规格值
        if (goodsSpecs != null && goodsSpecs.size() > 0) {
            List<MallGoodsSpecValue> specValues = goodsSpecs.stream()
                    .flatMap(spec -> {
                        return specValueService.list(new LambdaQueryWrapper<MallGoodsSpecValue>().eq(MallGoodsSpecValue::getSpecId, spec.getId())).stream();
                    }).collect(Collectors.toList());
            List<GoodsSkuDto> goodsSkuDtos = skuList.stream()
                    .map(sku -> {
                        GoodsSkuDto goodsSkuDto = new GoodsSkuDto();
                        goodsSkuDto.setSkuId(sku.getId());
                        goodsSkuDto.setPrice(sku.getPrice());
                        goodsSkuDto.setStock(sku.getStock());
                        goodsSkuDto.setStockWarningCount(sku.getStockWarningCount());
                        goodsSkuDto.setImg(sku.getImg());
                        goodsSkuDto.setSpecSn(sku.getSpecSn());
                        return goodsSkuDto;
                    }).collect(Collectors.toList());
            goodsSkuDtos.stream().forEach(goodsSkuDto -> {
                List<SpecAndValueDto> specAndValueDtos = new ArrayList<>();
                String specSn = goodsSkuDto.getSpecSn();
                Map<Long, Long> specIdAndValueId = GoodsSpecUtil.getSpecIdAndValueId(specSn);

                specIdAndValueId.forEach((specId, valueId) -> {
                    SpecAndValueDto specAndValueDto = new SpecAndValueDto();
                    specAndValueDto.setSpecId(specId);
                    specAndValueDto.setValueId(valueId);
                    specAndValueDto.setSpec(getSpecBySpuSpecId(specId, goodsSpecs));
                    specAndValueDto.setValue(getValueBySpuValueId(valueId, specValues));
                    specAndValueDtos.add(specAndValueDto);
                });
                goodsSkuDto.setSpecAndValueList(specAndValueDtos);
            });

            goodsSkuDtoList.addAll(goodsSkuDtos);
        }
        return goodsSkuDtoList;
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
    private String getSpecBySpuSpecId(Long specId, List<MallGoodsSpec> specs) {
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
    private String getValueBySpuValueId(Long valueId, List<MallGoodsSpecValue> specValues) {
        MallGoodsSpecValue mallGoodsSpecValue = specValues.stream()
                .filter(value -> {
                    return value.getId().equals(valueId);
                })
                .findAny().orElse(null);
        return mallGoodsSpecValue != null ? mallGoodsSpecValue.getSpecValue() : "";
    }
}
