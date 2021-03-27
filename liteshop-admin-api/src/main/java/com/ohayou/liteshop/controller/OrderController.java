package com.ohayou.liteshop.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.AfterSaleDetailDto;
import com.ohayou.liteshop.dto.OrderAfterSaleDto;
import com.ohayou.liteshop.dto.OrderDetailDto;
import com.ohayou.liteshop.dto.OrderDto;
import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.ExpressTrackService;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/9/17 下午9:57
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    MallOrderService orderService;

    @Autowired
    @Qualifier("expressTrackServiceImpl")
    ExpressTrackService expressTrackService;


    /**
     * 条件查询订单列表
     * @param orderDto
     * @param queryParam
     * @return
     */
    @ApiDesc("查询订单列表")
    @GetMapping("/list")
    public Result orderList(OrderDto orderDto,@RequestParam Map<String, Object> queryParam) {
        PageQuery<MallOrder> pageQuery = new PageQuery<>();
        IPage<MallOrder> page = pageQuery.getPage(queryParam);

        PageUtils pageUtils = orderService.queryPage(orderDto, page);
        return Result.success("page", pageUtils);
    }

    /**
     * 根据iD查询订单详情
     * @param orderId
     * @return
     */
    @ApiDesc("订单详情")
    @GetMapping("/detail/{id}")
    public Result orderDetail(@PathVariable("id") Long orderId) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        OrderDetailDto orderDetailDto = orderService.getOrderDetail(orderId);
        return Result.success("detail", orderDetailDto);
    }

    /**
     * 对已付款的订单进行发货
     */
    @ApiDesc("订单发货")
    @PostMapping("/ship")
    public Result ship(@Valid @RequestBody OrderDetailDto orderDetailDto) {

        boolean result = orderService.ship(orderDetailDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.ORDER_ERROR);
    }

    /**
     * 取消当前订单
     * @param orderId
     * @return
     */
    @ApiDesc("删除订单")
    @PostMapping("/delete/{id}")
    public Result deleteOrder(@PathVariable("id") Long orderId) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = orderService.deleteOrder(orderId);
        return result ? Result.success() : Result.error(ErrorCodeMsg.ORDER_NOT_DELETE);
    }

    /**
     * 查询物流轨迹
     * @param orderId
     * @return
     */
    @ApiDesc("查询订单物流轨迹")
    @GetMapping("/queryExpressTrack/{id}")
    public Result getExpressTrack(@PathVariable("id") Long orderId) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<Map<String, String>> maps = orderService.queryExpressTrack(orderId);
        if (CollectionUtil.isNotEmpty(maps)) {
            return Result.success("data",maps);
        }
        return Result.error(ErrorCodeMsg.TRACK_NOT_EXIST);
    }

    @ApiDesc("查询申请售后列表")
    @GetMapping("/afterSale/list")
    public Result afterSaleList(OrderAfterSaleDto afterSaleDto, Map<String,Object> queryParam) {
        PageQuery<MallOrder> pageQuery = new PageQuery<>();
        IPage<MallOrder> page = pageQuery.getPage(queryParam);

        PageUtils pageUtils = orderService.afterSalePage(afterSaleDto,page);
        return Result.success("page",pageUtils);
    }

    @ApiDesc("查询退款详情")
    @GetMapping("/afterSale/detail/{id}")
    public Result afterSaleDetail(@PathVariable("id") Long orderId) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        AfterSaleDetailDto afterSaleDetailDto = orderService.afterSaleDetail(orderId);
        return Result.success("detail",afterSaleDetailDto);
    }

    @ApiDesc("退款审核通过")
    @PostMapping("/afterSale/passed/{id}")
    public Result afterSalePassed(@PathVariable("id") Long orderId) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        boolean result = orderService.approvedOrder(orderId);
        return result ? Result.success() : Result.error(ErrorCodeMsg.AUDIT_ERROR);
    }

    @ApiDesc("退款未通过")
    @PostMapping("/afterSale/refuse/{id}")
    public Result refuse(@PathVariable("id") Long orderId) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = orderService.refuseOrder(orderId);
        return result ? Result.success() : Result.error(ErrorCodeMsg.AUDIT_ERROR);
    }

}
