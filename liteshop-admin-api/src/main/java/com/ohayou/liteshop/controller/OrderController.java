package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.constant.ShipChannelCode;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    ExpressTrackService expressTrackService;


    /**
     * 条件查询订单列表
     * @param orderDto
     * @param queryParam
     * @return
     */
    @ApiDesc("查询订单列表")
    @GetMapping("/list")
    public Result orderList(OrderDto orderDto, Map<String, Object> queryParam) {
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

    @ApiDesc("查询订单物流轨迹")
    @GetMapping("/queryExpressTrack/{id}")
    public Result getExpressTrack(@PathVariable("id") Long orderId) {
        if (null == orderId || orderId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        Map<String,Object> result = orderService.queryExpressTrack(orderId);
        boolean isSuccess = (Boolean)result.get("Success");
        if (isSuccess) {
            return Result.success("data",result);
        }
        return Result.error(200,String.valueOf(result.get("Reason")));
    }
}
