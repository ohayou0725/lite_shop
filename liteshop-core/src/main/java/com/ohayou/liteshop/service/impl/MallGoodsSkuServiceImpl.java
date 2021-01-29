package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.constant.GoodsStatus;
import com.ohayou.liteshop.dto.GoodsFormDto;
import com.ohayou.liteshop.dto.GoodsSkuDto;
import com.ohayou.liteshop.dto.MallGoodsSpecDto;
import com.ohayou.liteshop.dto.SpecAndValueDto;
import com.ohayou.liteshop.entity.MallGoodsSku;
import com.ohayou.liteshop.dao.MallGoodsSkuMapper;
import com.ohayou.liteshop.entity.MallGoodsSpec;
import com.ohayou.liteshop.entity.MallGoodsSpecValue;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallGoodsSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MallGoodsSpecService;
import com.ohayou.liteshop.service.MallGoodsSpecValueService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.utils.GoodsSpecUtil;
import com.ohayou.liteshop.vo.SkuVo;
import com.ohayou.liteshop.vo.SpecValueVo;
import com.ohayou.liteshop.vo.SpecVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品sku信息表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallGoodsSkuServiceImpl extends ServiceImpl<MallGoodsSkuMapper, MallGoodsSku> implements MallGoodsSkuService {

    @Autowired
    MallGoodsSpuService mallGoodsSpuService;

    @Autowired
    MallGoodsSpecService specService;

    @Autowired
    MallGoodsSpecValueService specValueService;




    /**
     * 根据商品ID查询所有sku规格
     *
     * @param goodsId
     * @return
     */
    @Override
    public List<GoodsSkuDto> getGoodsSku(Long goodsId) {
        //获取sku信息
        List<MallGoodsSku> skuList = this.list(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getGoodsId, goodsId));
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
                        goodsSkuDto.setSales(sku.getSales());
                        goodsSkuDto.setStock(sku.getStock());
                        goodsSkuDto.setStockWarningCount(sku.getStockWarningCount());
                        goodsSkuDto.setImg(sku.getImg());
                        goodsSkuDto.setSpecSn(sku.getSpecSn());
                        return goodsSkuDto;
                    }).collect(Collectors.toList());
            goodsSkuDtos.forEach(goodsSkuDto -> {
                List<SpecAndValueDto> specAndValueDtos = new ArrayList<>();
                String specSn = goodsSkuDto.getSpecSn();
                Map<Long, Long> specIdAndValueId = GoodsSpecUtil.getSpecIdAndValueId(specSn);
                if (specIdAndValueId != null) {
                    specIdAndValueId.forEach((specId, valueId) -> {
                        SpecAndValueDto specAndValueDto = new SpecAndValueDto();
                        specAndValueDto.setSpecId(specId);
                        specAndValueDto.setValueId(valueId);
                        specAndValueDto.setSpec(mallGoodsSpuService.getSpecBySpuSpecId(specId, goodsSpecs));
                        specAndValueDto.setValue(mallGoodsSpuService.getValueBySpuValueId(valueId, specValues));
                        specAndValueDtos.add(specAndValueDto);
                    });
                }
                goodsSkuDto.setSpecAndValueList(specAndValueDtos);
            });

            goodsSkuDtoList.addAll(goodsSkuDtos);
        }
        return goodsSkuDtoList;
    }

    /**
     * 根据规格编号查询规格值
     * @param specSn
     * @return
     */
    @Override
    public Map<String,String> getSpecAndValue(String specSn) {
        Map<Long, Long> specIdAndValueId = GoodsSpecUtil.getSpecIdAndValueId(specSn);
        if (CollectionUtil.isEmpty(specIdAndValueId)) {
            return null;
        }
        Long spuId = GoodsSpecUtil.getSpuIdBySpecSn(specSn);
        if (spuId == null) {
            return null;
        }
        List<MallGoodsSpec> goodsSpecs = specService.list(new LambdaQueryWrapper<MallGoodsSpec>().eq(MallGoodsSpec::getGoodsId, spuId));

        List<MallGoodsSpecValue> specValues = goodsSpecs.stream()
                .flatMap(spec -> {
                    return specValueService.list(new LambdaQueryWrapper<MallGoodsSpecValue>().eq(MallGoodsSpecValue::getSpecId, spec.getId())).stream();
                }).collect(Collectors.toList());

        Map<String, String> result = new HashMap<>();
        specIdAndValueId.forEach((spec,value)->{
            result.put(mallGoodsSpuService.getSpecBySpuSpecId(spec, goodsSpecs),mallGoodsSpuService.getValueBySpuValueId(value, specValues));
        });
        return result;
    }

    @Override
    public SkuVo getGoodsSkuVo(Long goodsId) {
        List<GoodsSkuDto> goodsSku = this.getGoodsSku(goodsId);
        SkuVo skuVo = new SkuVo();

        List<MallGoodsSpec> specs = specService.list(new LambdaQueryWrapper<MallGoodsSpec>().eq(MallGoodsSpec::getGoodsId, goodsId));
        List<SpecVo> specValueVos = specs.stream()
                .map(spec -> {
                    SpecVo specVo = new SpecVo();
                    specVo.setId(spec.getId().toString());
                    specVo.setK(spec.getName());
                    return specVo;
                }).collect(Collectors.toList());

        List<SpecVo> specVoList = specValueVos.stream()
                .peek(specVo -> {
                    List<MallGoodsSpecValue> list = specValueService
                            .list(new LambdaQueryWrapper<MallGoodsSpecValue>()
                                    .eq(MallGoodsSpecValue::getSpecId, specVo.getId()));
                    List<SpecValueVo> collect = list.stream()
                            .map(mallGoodsSpecValue -> {
                                SpecValueVo specValueVo = new SpecValueVo();
                                specValueVo.setName(mallGoodsSpecValue.getSpecValue());
                                specValueVo.setId(mallGoodsSpecValue.getId());
                                if(specVo.getK().contains("颜色")) {
                                    String img = this.findSkuImgBySpecAndValue(mallGoodsSpecValue.getSpecId() + "-" + mallGoodsSpecValue.getId(),goodsSku);
                                    specValueVo.setImgUrl(img);
                                    specValueVo.setPreviewImgUrl(img);
                                }
                                return specValueVo;
                            }).collect(Collectors.toList());
                    specVo.setV(collect);
                }).collect(Collectors.toList());

        skuVo.setTree(specVoList);
        skuVo.setHideStock(false);
        MallGoodsSpu goodsSpu = mallGoodsSpuService.getById(goodsId);
        skuVo.setPrice(goodsSpu.getDiscountPrice().toString());
        skuVo.setTotalStock(this.getStock(goodsId));
        //判断是否为无规格商品
        if (skuVo.getTree().size() == 1 && skuVo.getTree().get(0).getV().size() == 1) {
            skuVo.setNoneSku(true);
            Long skuId = goodsSku.get(0).getSkuId();
            skuVo.setCollectionId(skuId);
        }
        skuVo.setCollectionId(goodsSku.get(0).getSkuId());
        List<Map<String, Object>> list = goodsSku.stream()
                .map(goodsSkuDto -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", goodsSkuDto.getSkuId());
                    map.put("price", goodsSkuDto.getPrice().toString());
                    map.put("stock", goodsSkuDto.getStock());
                    List<SpecAndValueDto> specAndValueList = goodsSkuDto.getSpecAndValueList();
                    for (SpecAndValueDto specAndValueDto : specAndValueList) {
                        map.put(specAndValueDto.getSpecId().toString(), specAndValueDto.getValueId().toString());
                    }
                    return map;
                }).collect(Collectors.toList());
        skuVo.setList(list);
        return skuVo;
    }

    /**
     * 根据Spec和value的组合编码找到对应sku的图片
     *
     * @param specAndValue
     * @return
     */
    private String findSkuImgBySpecAndValue(String specAndValue,List<GoodsSkuDto> goodsSku) {
        Optional<GoodsSkuDto> first = goodsSku.stream()
                .filter(goodsSkuDto -> {
                    return goodsSkuDto.getSpecSn().contains(specAndValue);
                }).findFirst();
        if (first.isPresent()) {
            return first.get().getImg();
        }
        return "";

    }

    private Integer getStock(Long spuId) {
        //查询到商品sku信息后对sku库存进行累加
        List<MallGoodsSku> list = this.list(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getGoodsId, spuId));
        if (null != list && list.size() > 0) {
            return list.stream()
                    .map(MallGoodsSku::getStock)
                    .reduce(0, Integer::sum);
        }
        return 0;
    }


    /**
     * 根据商品编号获取sku信息
     *
     * @param goodsSn
     * @return
     */
    @Override
    public List<GoodsSkuDto> getSkuByGoodsSn(String goodsSn) {
        if (StringUtils.isBlank(goodsSn)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallGoodsSpu goodsSpu = mallGoodsSpuService.getOne(new LambdaQueryWrapper<MallGoodsSpu>().eq(MallGoodsSpu::getGoodsSn, goodsSn));
        if (null == goodsSpu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        List<GoodsSkuDto> goodsSkuDtos = this.getGoodsSku(goodsSpu.getId());
        if (CollUtil.isEmpty(goodsSkuDtos)) {
            return null;
        }
        goodsSkuDtos.forEach(goodsSkuDto -> {
            goodsSkuDto.setTitle(goodsSpu.getTitle());
        });
        return goodsSkuDtos;
    }

    /**
     * 添加商品sku信息
     * @param goodsSkuDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addGoodsSku(GoodsSkuDto goodsSkuDto) {
        Long spuId = GoodsSpecUtil.getSpuIdBySpecSn(goodsSkuDto.getSpecSn());
        if (null == spuId || spuId < 1) {
          throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallGoodsSpu spu = mallGoodsSpuService.getById(spuId);
        if (null == spu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        //判断是否已经有相同的sku
        int sku = this.count(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getSpecSn, goodsSkuDto.getSpecSn()));
        if ( sku != 0 ) {
            throw new GlobalException(ErrorCodeMsg.SKU_EXIST);
        }
        //判断规格参数是否存在
        Map<Long, Long> specIdAndValueId = GoodsSpecUtil.getSpecIdAndValueId(goodsSkuDto.getSpecSn());
        if (null == specIdAndValueId) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<Long> specList = specService.list(new LambdaQueryWrapper<MallGoodsSpec>().eq(MallGoodsSpec::getGoodsId, spuId))
                .stream().map(MallGoodsSpec::getId).collect(Collectors.toList());

        if (specIdAndValueId.size() != specList.size()) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<Long> valueList = specValueService.listByGoodsId(spuId)
                .stream().map(MallGoodsSpecValue::getId).collect(Collectors.toList());

        specIdAndValueId.forEach((specId,valueId)->{
            if (!specList.contains(specId) || !valueList.contains(valueId)) {
                throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
            }
        });
        MallGoodsSku mallGoodsSku = new MallGoodsSku();
        mallGoodsSku.setGoodsId(spuId);
        BeanUtils.copyProperties(goodsSkuDto,mallGoodsSku);
        //添加sku成功后还需更改商品状态
        boolean save = this.save(mallGoodsSku);
        if (save) {
            int skuCount = this.count(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getGoodsId, spuId));
            if (skuCount == 1) {
                MallGoodsSpu goodsSpu = new MallGoodsSpu();
                goodsSpu.setId(spuId);
                goodsSpu.setStatus(GoodsStatus.IN_STOCK.getStatus());
                return mallGoodsSpuService.updateById(goodsSpu);
            }
        }
        return save;
    }

    /**
     * 更新Sku信息
     * @param goodsSkuDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateGoodsSku(GoodsSkuDto goodsSkuDto) {
        Long skuId = goodsSkuDto.getSkuId();
        if (null == skuId || skuId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallGoodsSku sku = this.getById(skuId);
        if (null == sku) {
            throw new GlobalException(ErrorCodeMsg.GOODS_SKU_NOT_FOUND);
        }

        MallGoodsSku newSku = new MallGoodsSku();
        newSku.setId(goodsSkuDto.getSkuId());
        BeanUtils.copyProperties(goodsSkuDto,newSku);
        return this.updateById(newSku);
    }

    /**
     * 删除sku信息
     * @param skuId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteSku(Long skuId) {
        MallGoodsSku sku = this.getById(skuId);
        if (null == sku) {
            throw new GlobalException(ErrorCodeMsg.GOODS_SKU_NOT_FOUND);
        }
        boolean remove = this.removeById(skuId);
        if (remove) {
            //查询该商品是否已经没有单品上架
            List<MallGoodsSku> skuList = this.list(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getGoodsId, sku.getGoodsId()));
            if (CollectionUtil.isEmpty(skuList)) {
                //如果删除后没有单品了就更改商品状态为未上架
                GoodsFormDto goodsSpuDto = new GoodsFormDto();
                goodsSpuDto.setId(sku.getGoodsId());
                goodsSpuDto.setStatus(GoodsStatus.NOT_IN_STOCK.getStatus());
                if (!mallGoodsSpuService.changeStatus(goodsSpuDto)) {
                    throw new GlobalException(ErrorCodeMsg.GOODS_SKU_DELETE_ERROR);
                };
            }
        }
        return remove;
    }

    /**
     * 删除某个商品下所有Sku信息，并更改商品状态为未上架
     * @param goodsSn
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteAllSku(String goodsSn) {
        MallGoodsSpu spu = mallGoodsSpuService.getOne(new LambdaQueryWrapper<MallGoodsSpu>().eq(MallGoodsSpu::getGoodsSn, goodsSn));
        if (null == spu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        List<MallGoodsSku> skuList = this.list(new LambdaQueryWrapper<MallGoodsSku>().eq(MallGoodsSku::getGoodsId, spu.getId()));
        if (CollectionUtil.isEmpty(skuList)) {
            throw new GlobalException(ErrorCodeMsg.GOODS_SKU_NOT_EXIST);
        }
        List<Long> idS = skuList.stream().map(MallGoodsSku::getId).collect(Collectors.toList());
        boolean remove = this.removeByIds(idS);
        if (remove) {
            GoodsFormDto goodsSpuDto = new GoodsFormDto();
            goodsSpuDto.setId(spu.getId());
            goodsSpuDto.setStatus(GoodsStatus.NOT_IN_STOCK.getStatus());
            if (!mallGoodsSpuService.changeStatus(goodsSpuDto)) {
                throw new GlobalException(ErrorCodeMsg.GOODS_SKU_DELETE_ERROR);
            };
        }
        return remove;
    }



}
