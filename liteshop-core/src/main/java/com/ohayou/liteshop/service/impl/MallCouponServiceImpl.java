package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.constant.CouponStatus;
import com.ohayou.liteshop.constant.CouponType;
import com.ohayou.liteshop.dto.CouponDetailDto;
import com.ohayou.liteshop.dto.CouponDto;
import com.ohayou.liteshop.entity.MallCoupon;
import com.ohayou.liteshop.dao.MallCouponMapper;
import com.ohayou.liteshop.entity.MallCouponType;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.service.MallCouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MallCouponTypeService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class MallCouponServiceImpl extends ServiceImpl<MallCouponMapper, MallCoupon> implements MallCouponService {

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    MallCouponTypeService couponTypeService;

    @Autowired
    MallCategoryService categoryService;

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
}
