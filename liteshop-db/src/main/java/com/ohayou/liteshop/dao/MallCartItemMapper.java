package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallCartItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 购物车商品 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MallCartItemMapper extends BaseMapper<MallCartItem> {

    List<MallCartItem> listByUser(Long userId);
}
