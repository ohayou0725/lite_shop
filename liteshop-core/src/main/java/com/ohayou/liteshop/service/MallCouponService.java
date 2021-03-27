package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.CouponDetailDto;
import com.ohayou.liteshop.dto.CouponDto;
import com.ohayou.liteshop.entity.MallCoupon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.CouponVo;
import com.ohayou.liteshop.vo.UserCouponVo;

import java.util.List;

/**
 * <p>
 * 优惠券 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallCouponService extends IService<MallCoupon> {

    PageUtils getPage(IPage<MallCoupon> page, CouponDto couponDto);

    CouponDetailDto getDetail(Long couponId);

    boolean addCoupon(CouponDto couponDto);

    boolean updateCoupon(CouponDto couponDto);

    boolean deleteCoupon(Long couponId);

    List<CouponVo> getCouponVo(Long goodsId);

    Boolean receive(Long couponId, Long id);

    List<Long> hasReceived(List<Long> coupons, Long id);

    List<UserCouponVo> getCouponByUserId(Long userId);

    List<MallCoupon> listByUserId(Long userId);

    List<UserCouponVo> getApplicableCoupon(List<UserCouponVo> coupons, MallGoodsSpu spu);


}
