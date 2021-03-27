package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.CouponDetailDto;
import com.ohayou.liteshop.dto.CouponDto;
import com.ohayou.liteshop.entity.MallCoupon;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallCouponService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/10/3 下午9:23
 */
@RestController
@RequestMapping("/operation/coupon")
public class CouponController {

    @Autowired
    MallCouponService couponService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @ApiDesc("查询优惠券列表")
    @GetMapping("/list")
    public Result list(CouponDto couponDto,@RequestParam Map<String, Object> queryParam) {
        PageQuery<MallCoupon> pageQuery = new PageQuery<>();
        IPage<MallCoupon> page = pageQuery.getPage(queryParam);
        PageUtils pageUtils = couponService.getPage(page,couponDto);
        return Result.success("page",pageUtils);
    }

    @ApiDesc("优惠券详情")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable("id") Long couponId) {
        if (null == couponId || couponId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        CouponDetailDto couponDetailDto = couponService.getDetail(couponId);
        return Result.success("detail",couponDetailDto);
    }

    @ApiDesc("查询优惠券可用商品列表")
    @GetMapping("/goodsList")
    public Result goodsList(@RequestParam("couponId") Long couponId,
                            @RequestParam(value = "limit",defaultValue = "5") int limit,
                            @RequestParam("lastGoodsId") Long lastGoodsId) {
        if (null == couponId || couponId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<MallGoodsSpu> goodsSpuList = goodsSpuService.getGoodsListByCouponId(couponId,limit,lastGoodsId);
        return Result.success("list",goodsSpuList);
    }

    @ApiDesc("新增优惠券")
    @PostMapping("/add")
    public Result addCoupon(@RequestBody @Validated(CouponDto.AddCoupon.class) CouponDto couponDto) {
        boolean result = couponService.addCoupon(couponDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.COUPON_ADD_ERROR);
    }

    @ApiDesc("修改优惠券")
    @PostMapping("/update")
    public Result updateCoupon(@RequestBody @Validated(CouponDto.UpdateCoupon.class) CouponDto couponDto) {
        boolean result = couponService.updateCoupon(couponDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.COUPON_UPDATE_ERROR);
    }

    @ApiDesc("删除优惠券")
    @PostMapping("/delete/{id}")
    public Result deleteCoupon(@PathVariable("id") Long couponId) {
        if (null == couponId || couponId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = couponService.deleteCoupon(couponId);
        return result ? Result.success() : Result.error(ErrorCodeMsg.COUPON_DELETE_ERROR);
    }
}
