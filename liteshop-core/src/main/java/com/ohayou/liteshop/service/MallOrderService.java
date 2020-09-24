package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.OrderDetailDto;
import com.ohayou.liteshop.dto.OrderDto;
import com.ohayou.liteshop.entity.MallOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 * 商品订单表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallOrderService extends IService<MallOrder> {

    PageUtils queryPage(OrderDto orderDto, IPage<MallOrder> page);

    OrderDetailDto getOrderDetail(Long orderId);

    boolean ship(OrderDetailDto orderDetailDto);

    boolean deleteOrder(Long orderId);

    Map<String, Object> queryExpressTrack(Long orderId);
}
