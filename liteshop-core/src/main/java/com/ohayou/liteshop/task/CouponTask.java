package com.ohayou.liteshop.task;

import com.ohayou.liteshop.service.MallCouponService;
import com.ohayou.liteshop.vo.CouponVo;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author liyan
 * @date 2021/1/21 下午9:38
 */
public class CouponTask implements Callable<List<CouponVo>> {

    private Long goodsId;

    private MallCouponService couponService;

    public CouponTask(Long goodsId, MallCouponService couponService) {
        this.goodsId = goodsId;
        this.couponService = couponService;
    }

    @Override
    public List<CouponVo> call() throws Exception {
        return couponService.getCouponVo(goodsId);
    }
}
