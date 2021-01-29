package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品spu信息表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MallGoodsSpuMapper extends BaseMapper<MallGoodsSpu> {

    MallGoodsSpu findGoodsByGoodsSnOrName(@Param("goodsSn") String goodsSn, @Param("name") String name);

    List<MallGoodsSpu> goodsListByTopicId(Long topicId);

    List<MallGoodsSpu> page(@Param("limit") int limit, @Param("lastGoodsId") Long lastGoodsId);

    List<MallGoodsSpu> goodsListByCouponTypeIdAndCate(@Param("couponTypeId") Long couponTypeId, @Param("limit") int limit, @Param("lastGoodsId") Long lastGoodsId);

    List<MallGoodsSpu> goodsListByCouponTypeIdAndBrand(@Param("couponTypeId") Long couponTypeId, @Param("limit") int limit, @Param("lastGoodsId") Long lastGoodsId);

    List<MallGoodsSpu> getGoodsByCouponType(Long id);

    List<MallGoodsSpu> goodsPageByTopicId(@Param("topicId") Long topicId, @Param("start") int start, @Param("size") int size);

    List<MallGoodsSpu> findGoodsPageByCategoryIds(@Param("childrenIds") List<Long> childrenIds, @Param("page") int page, @Param("size") int size);

    MallGoodsSpu getGoodsByCouponId(Long couponId);
}
