package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.MallCoupon;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 优惠券 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface MallCouponMapper extends BaseMapper<MallCoupon> {

    List<MallCoupon> getCouponByGoods(MallGoodsSpu goodsSpu);
}
