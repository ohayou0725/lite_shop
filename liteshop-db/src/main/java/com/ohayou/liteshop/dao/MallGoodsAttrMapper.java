package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallGoodsAttr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品参数表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MallGoodsAttrMapper extends BaseMapper<MallGoodsAttr> {

    List<MallGoodsAttr> listAttrByGroupId(Long attrGroupId);
}
