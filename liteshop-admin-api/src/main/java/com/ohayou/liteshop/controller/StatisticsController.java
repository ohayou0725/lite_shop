package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.GoodsStatisticsDto;
import com.ohayou.liteshop.dto.MemberStatisticsDto;
import com.ohayou.liteshop.dto.OrderStatisticsDto;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.service.MemUserService;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/11/11 下午2:51
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    MemUserService memUserService;

    @Autowired
    MallGoodsSpuService mallGoodsSpuService;

    @Autowired
    MallOrderService mallOrderService;

    @ApiDesc("用户增长统计")
    @GetMapping("/member")
    public Result getMemberStatistics(@RequestParam(value = "year",required = false) Integer year) {
        if (null == year) {
            year = LocalDateTime.now().getYear();
        }
        MemberStatisticsDto memberIncrementStatistics = memUserService.getMemberIncrementStatistics(year);
        return Result.success("data",memberIncrementStatistics);
    }

    @ApiDesc("商品统计")
    @GetMapping("/product")
    public Result getGoodsStatistics(@RequestParam(required = false) Long categoryId,
                                     @RequestParam(required = false) Long brandId) {
        GoodsStatisticsDto goodsStatisticsDto = mallGoodsSpuService.getGoodsStatistics(categoryId,brandId);
        return Result.success("data",goodsStatisticsDto);
    }

    @ApiDesc("订单统计")
    @GetMapping("/order")
    public Result getOrderStatistics(@RequestParam LocalDate startTime,
                                     @RequestParam LocalDate endTime) {
        if (null == startTime || null == endTime) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<OrderStatisticsDto> orderStatisticsDtos =  mallOrderService.getOrderStatistics(startTime,endTime);
        return Result.success("data",orderStatisticsDtos);
    }
}
