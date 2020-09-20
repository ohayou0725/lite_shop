package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.OrderDto;
import com.ohayou.liteshop.entity.MallOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

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
}
