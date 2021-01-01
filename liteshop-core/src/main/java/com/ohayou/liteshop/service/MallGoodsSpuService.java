package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.MallGoodsSpec;
import com.ohayou.liteshop.entity.MallGoodsSpecValue;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.HotGoodsVo;

import java.util.List;

/**
 * <p>
 * 商品spu信息表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallGoodsSpuService extends IService<MallGoodsSpu> {

    PageUtils getPage(MallGoodsSpuDto mallGoodsSpuDto, IPage<MallGoodsSpu> page);

    GoodsDetailDto getDetail(Long goodsId);

    List<AttrValueDto> getAllAttrAndValue(Long goodsId);

    boolean addGoodsSpu(GoodsFormDto goodsFormDto);

    boolean updateBasicInfo(GoodsFormDto goodsFormDto);

    boolean updateAttr(GoodsFormDto goodsFormDto);

    boolean updateSpec(GoodsFormDto goodsFormDto);

    boolean changeStatus(GoodsFormDto goodsFormDto);

    boolean updateDetail(GoodsFormDto goodsFormDto);

    List<MallGoodsSpecDto> getSpecsById(Long id);

    boolean deleteGoods(Long id);

    String getSpecBySpuSpecId(Long specId, List<MallGoodsSpec> specs);

    String getValueBySpuValueId(Long valueId, List<MallGoodsSpecValue> specValues);


    List<MallGoodsSpecDto> specListByGoodsSn(String goodsSn);

    List<MallGoodsSpu> goodsListByTopicId(Long topicId);

    List<MallGoodsSpu> goodsListByCategoryId(Long categoryId);

    List<MallGoodsSpu> getGoodsListByCouponId(Long couponId, int limit, Long lastGoodsId);

    GoodsStatisticsDto getGoodsStatistics(Long categoryId, Long brandId);

    List<HotGoodsVo> getHotGoodsList(int page, int size);

    List<HotGoodsVo> getAllHotGoodsList();

    List<MallGoodsSpu> getGoodsPageByTopicId(Long topicId, int page, int size);

    List<HotGoodsVo> getGoodsPageByCategoryId(Long categoryId,int page,int size);
}
