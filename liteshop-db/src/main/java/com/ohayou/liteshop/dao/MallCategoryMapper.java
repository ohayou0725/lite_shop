package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品类目表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MallCategoryMapper extends BaseMapper<MallCategory> {

    List<MallCategory> findCategoryListByBrandId(Long brandId);

    List<MallCategory> findCategoryListByIds(@Param("childrenIds") List<Long> childrenIds);

}
