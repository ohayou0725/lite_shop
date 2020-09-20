package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.OrderDto;
import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallOrderService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @ApiDesc("查询订单列表")
    @GetMapping("/list")
    public Result orderList(OrderDto orderDto, Map<String, Object> queryParam) {
        PageQuery<MallOrder> pageQuery = new PageQuery<>();
        IPage<MallOrder> page = pageQuery.getPage(queryParam);

        PageUtils pageUtils = orderService.queryPage(orderDto, page);
        return Result.success("page", pageUtils);
    }
}
