package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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
}
