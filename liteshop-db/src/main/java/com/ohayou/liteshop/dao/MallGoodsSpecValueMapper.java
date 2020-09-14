package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallGoodsSpecValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品规格值表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MallGoodsSpecValueMapper extends BaseMapper<MallGoodsSpecValue> {

    List<MallGoodsSpecValue> listByGoodsId(Long id);
}
