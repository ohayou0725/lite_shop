package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.async.event.UserRegisterEvent;
import com.ohayou.liteshop.constant.CouponStatus;
import com.ohayou.liteshop.constant.CouponType;
import com.ohayou.liteshop.constant.UserCouponStatus;
import com.ohayou.liteshop.dto.CouponDetailDto;
import com.ohayou.liteshop.dto.CouponDto;
import com.ohayou.liteshop.entity.*;
import com.ohayou.liteshop.dao.MallCouponMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.CouponVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 优惠券 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallCouponServiceImpl extends ServiceImpl<MallCouponMapper, MallCoupon> implements MallCouponService, ApplicationListener<UserRegisterEvent> {

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    MallCouponTypeService couponTypeService;

    @Autowired
    MallCategoryService categoryService;

    @Autowired
    MallBrandService brandService;

    @Autowired
    MallUserCouponService userCouponService;


    @Override
    public PageUtils getPage(IPage<MallCoupon> page, CouponDto couponDto) {
        LambdaQueryWrapper<MallCoupon> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNoneBlank(couponDto.getName()), MallCoupon::getName, couponDto.getName());
        queryWrapper.eq(null != couponDto.getStatus(), MallCoupon::getStatus, couponDto.getStatus());
        queryWrapper.eq(null != couponDto.getType(), MallCoupon::getType, couponDto.getType());

        this.page(page, queryWrapper);

        PageUtils pageUtils = new PageUtils(page);

        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<CouponDto> collect = page.getRecords().stream()
                    .map(mallCoupon -> {
                        CouponDto newCouponDto = new CouponDto();
                        BeanUtils.copyProperties(mallCoupon, newCouponDto);
                        MallCouponType one = couponTypeService.getOne(
                                new LambdaQueryWrapper<MallCouponType>().
                                        eq(MallCouponType::getCouponId, mallCoupon.getId()));
                        newCouponDto.setCouponType(one);
                        return newCouponDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }

        return pageUtils;
    }

    /**
     * 获取优惠券详情
     *
     * @param couponId
     * @return
     */
    @Override
    public CouponDetailDto getDetail(Long couponId) {
        MallCoupon coupon = this.getById(couponId);
        if (null == coupon) {
            throw new GlobalException(ErrorCodeMsg.COUPON_NOT_EXIST);
        }
        CouponDetailDto couponDetailDto = new CouponDetailDto();
        BeanUtils.copyProperties(coupon, couponDetailDto);

        CouponType couponType = CouponType.getCouponType(coupon.getType());
        if (null != couponType) {
            couponDetailDto.setType(couponType.getDesc());
        }

        CouponStatus couponStatus = CouponStatus.getCouponStatus(coupon.getStatus());
        if (null != couponStatus) {
            couponDetailDto.setStatus(couponStatus.getDesc());
        }

        couponDetailDto.setGoodsList(goodsSpuService.getGoodsListByCouponId(couponId, 3, 0L));
        return couponDetailDto;
    }

    /**
     * 新增优惠券
     *
     * @param couponDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addCoupon(CouponDto couponDto) {
        MallCoupon coupon = new MallCoupon();
        if (null == couponDto.getDays()) {
            //如果没有days字段。则为没有天数限制
            coupon.setDays(0);
            coupon.setTimeType(1);
        } else {
            coupon.setTimeType(0);
        }

        BeanUtils.copyProperties(couponDto, coupon);
        boolean save = this.save(coupon);

        if (save) {
            Integer type = coupon.getType();
            MallCouponType dtoCouponType = couponDto.getCouponType();
            if (type.equals(CouponType.CATE.getCode())) {
                MallCouponType couponType = new MallCouponType();
                couponType.setCategoryId(dtoCouponType.getCategoryId());
                couponType.setCouponId(coupon.getId());
                return couponTypeService.save(couponType);
            } else if (type.equals(CouponType.BRAND.getCode())) {
                MallCouponType couponType = new MallCouponType();
                couponType.setBrandId(dtoCouponType.getBrandId());
                couponType.setCouponId(coupon.getId());
                return couponTypeService.save(couponType);
            } else if (type.equals(CouponType.GOODS.getCode())) {
                MallCouponType couponType = new MallCouponType();
                couponType.setCouponId(coupon.getId());
                couponType.setGoodsId(dtoCouponType.getGoodsId());
                return couponTypeService.save(couponType);

            }
        }
        return false;
    }

    /**
     * 更新优惠券信息
     * @param couponDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCoupon(CouponDto couponDto) {
        Long id = couponDto.getId();
        int count = this.count(new LambdaQueryWrapper<MallCoupon>().eq(MallCoupon::getId, id));
        if (count < 1) {
            throw new GlobalException(ErrorCodeMsg.COUPON_NOT_EXIST);
        }
        MallCoupon coupon = new MallCoupon();
        BeanUtils.copyProperties(couponDto,coupon);

        if (null == couponDto.getDays() && null == couponDto.getStartTime() && null == couponDto.getEndTime()) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        if (null != couponDto.getDays()) {
            coupon.setDays(couponDto.getDays());
            coupon.setTimeType(0);
        } else {
            coupon.setTimeType(1);
            coupon.setStartTime(couponDto.getStartTime());
            coupon.setEndTime(couponDto.getEndTime());
        }
        boolean update = this.updateById(coupon);
        if (update && null != couponDto.getCouponType().getId() ) {
            MallCouponType couponType = couponDto.getCouponType();
            if (null == couponType.getId()) {
                throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
            }
            Integer type = coupon.getType();
            if (type.equals(CouponType.BRAND.getCode())) {
                if (null == couponDto.getCouponType().getBrandId()) {
                    throw new GlobalException(ErrorCodeMsg.COUPON_UPDATE_ERROR);
                }
                couponType.setGoodsId(0L);
                couponType.setCategoryId(0L);
            } else if (type.equals(CouponType.GOODS.getCode())) {
                if (null == couponDto.getCouponType().getGoodsId()) {
                    throw new GlobalException(ErrorCodeMsg.COUPON_UPDATE_ERROR);
                }
                couponType.setBrandId(0L);
                couponType.setCategoryId(0L);
            } else if (type.equals(CouponType.CATE.getCode())) {
                if (null == couponDto.getCouponType().getCategoryId()) {
                    throw new GlobalException(ErrorCodeMsg.COUPON_UPDATE_ERROR);
                }
                couponType.setGoodsId(0L);
                couponType.setBrandId(0L);
            }
            return couponTypeService.updateById(couponType);
        }
        return update;
    }

    /**
     * 删除优惠券
     * @param couponId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCoupon(Long couponId) {
        MallCoupon coupon = this.getById(couponId);
        if (null == coupon) {
            throw new GlobalException(ErrorCodeMsg.COUPON_NOT_EXIST);
        }

        if (coupon.getStatus().equals(CouponStatus.NORMAL.getStatus())) {
            throw new GlobalException(ErrorCodeMsg.COUPON_STATUS_ERROR);
        }
        boolean remove = this.removeById(coupon);
        if (remove && !coupon.getType().equals(CouponType.ALL.getCode())) {
            return couponTypeService.remove(new LambdaQueryWrapper<MallCouponType>()
            .eq(MallCouponType::getCouponId,coupon.getId()));
        }
        return remove;
    }

    /**
     * 查询商品下可用的优惠券
     * @param goodsId 商品ID
     * @return 可用优惠券列表
     */
    @Override
    public List<CouponVo> getCouponVo(Long goodsId) {
        MallGoodsSpu goodsSpu = this.goodsSpuService.getById(goodsId);
        if (null == goodsSpu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        List<MallCoupon> mallCoupons = this.baseMapper.getCouponByGoods(goodsSpu);
        return mallCoupons.stream()
                .filter(mallCoupon -> {
                    return mallCoupon.getStatus().equals(CouponStatus.NORMAL.getStatus());
                })
                .filter(mallCoupon -> {
                    if (mallCoupon.getTimeType().equals(1)) {
                        return LocalDateTime.now().isBefore(mallCoupon.getEndTime()) &&
                        LocalDateTime.now().isAfter(mallCoupon.getStartTime());
                    }
                    return true;
                })
                .map(mallCoupon -> {
                    CouponVo couponVo = new CouponVo();
                    couponVo.setCouponId(mallCoupon.getId());
                    couponVo.setName(mallCoupon.getName());
                    couponVo.setDescription(mallCoupon.getDetail());
                    couponVo.setUnitDesc("元");
                    couponVo.setCondition(this.getCouponCondition(mallCoupon));
                    couponVo.setValue(mallCoupon.getDiscount().stripTrailingZeros().toPlainString());
                    couponVo.setValueDesc(mallCoupon.getDiscount().stripTrailingZeros().toPlainString());
                    couponVo.setStartAt(this.getStartTime(mallCoupon));
                    couponVo.setEndAt(this.getEndTime(mallCoupon));
                    return couponVo;
                }).collect(Collectors.toList());

    }

    /**
     * 用户领取优惠券
     * @param couponId 优惠券Id
     * @param userId 用户ID
     * @return 是否领取成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean receive(Long couponId, Long userId) {
        MallCoupon coupon = this.getById(couponId);
        if (null == coupon) {
            throw new GlobalException(ErrorCodeMsg.COUPON_NOT_EXIST);
        }
        if (!coupon.getStatus().equals(CouponStatus.NORMAL.getStatus())) {
            throw new GlobalException(ErrorCodeMsg.COUPON_RECEIVE_ERROR);
        }
        if (coupon.getTimeType().equals(1)) {
            if (!LocalDateTime.now().isAfter(coupon.getStartTime()) && LocalDateTime.now().isBefore(coupon.getEndTime())) {
                throw new GlobalException(ErrorCodeMsg.COUPON_EXPIRED);
            }
        }
        //该用户已拥有该优惠券数量是否大于等于该优惠券限领数量
        LambdaQueryWrapper<MallUserCoupon> wrapper = new LambdaQueryWrapper<MallUserCoupon>().eq(MallUserCoupon::getCouponId, couponId).eq(MallUserCoupon::getUserId, userId);
        int count = userCouponService.count(wrapper);
        if (count >= coupon.getStint()) {
            throw new GlobalException(ErrorCodeMsg.COUPON_RECEIVE_OVER_LIMIT);
        }

        LambdaUpdateWrapper<MallCoupon> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(MallCoupon::getId,coupon.getId());
        //乐观锁控制优惠券库存
        updateWrapper.gt(MallCoupon::getTotal,0);
        updateWrapper.set(MallCoupon::getTotal,coupon.getTotal()-1);
        boolean update = this.update(updateWrapper);
        if (update) {
            MallUserCoupon mallUserCoupon = new MallUserCoupon();
            mallUserCoupon.setCouponId(coupon.getId());
            mallUserCoupon.setUserId(userId);
            mallUserCoupon.setNumber(1);
            return userCouponService.save(mallUserCoupon);
        }

        return update;
    }

    /**
     * 根据优惠券列表查询已领取优惠券
     * @param coupons 优惠券列表Id
     * @param userId 用户Id
     * @return
     */
    @Override
    public List<Long> hasReceived(List<Long> coupons, Long userId) {
        List<MallUserCoupon> list = userCouponService.list(new LambdaQueryWrapper<MallUserCoupon>()
                .eq(MallUserCoupon::getUserId, userId)
                .eq(MallUserCoupon::getStatus,UserCouponStatus.AVAILABLE.getStatus()));
        List<Long> currentCouponIds = list.stream().map(MallUserCoupon::getCouponId).collect(Collectors.toList());
        Collection<Long> intersection = CollUtil.intersection(coupons, currentCouponIds);
        return new ArrayList<>(intersection);
    }

    private String getCouponCondition(MallCoupon coupon) {
        return "满" + coupon.getMin().stripTrailingZeros().toPlainString() + "减" + coupon.getDiscount().stripTrailingZeros().toPlainString() ;
    }

    private Long getStartTime(MallCoupon coupon) {
        if (coupon.getTimeType().equals(0)) {
            return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        }
        return coupon.getStartTime().toEpochSecond(ZoneOffset.of("+8"));
    }

    private Long getEndTime(MallCoupon coupon) {
        if (coupon.getTimeType().equals(0)) {
            Integer days = coupon.getDays();
            return LocalDateTime.now().plusDays(days).toEpochSecond(ZoneOffset.of("+8"));
        }
        return coupon.getEndTime().toEpochSecond(ZoneOffset.of("+8"));
    }

    //监听用户注册成功时间，注册成功后发放新人优惠券
    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        Long userId = userRegisterEvent.getUserId();
        List<MallCoupon> coupons = this.list(new LambdaQueryWrapper<MallCoupon>().like(MallCoupon::getName, "新用户"));
        coupons.forEach(coupon -> {
            MallUserCoupon mallUserCoupon = new MallUserCoupon();
            mallUserCoupon.setUserId(userId);
            mallUserCoupon.setCouponId(coupon.getId());
            mallUserCoupon.setNumber(1);
            userCouponService.save(mallUserCoupon);
        });
    }
}
