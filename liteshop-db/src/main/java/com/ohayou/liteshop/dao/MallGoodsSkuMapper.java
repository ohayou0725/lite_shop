package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallGoodsSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品sku信息表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MallGoodsSkuMapper extends BaseMapper<MallGoodsSku> {

    int updateStock(@Param("skuId") Long skuId, @Param("stock") int stock);
}
