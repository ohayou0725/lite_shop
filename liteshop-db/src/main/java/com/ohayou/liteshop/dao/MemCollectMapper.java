package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MemCollect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户收藏表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MemCollectMapper extends BaseMapper<MemCollect> {

    int getCountByGoodsIdAndUserId(@Param("goodsId") Long goodsId, @Param("userId") Long userId);
}
