package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.OrderDto;
import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.dao.MallOrderMapper;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.service.MallOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品订单表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallOrderServiceImpl extends ServiceImpl<MallOrderMapper, MallOrder> implements MallOrderService {

    @Autowired
    MemUserService userService;
    /**
     * 根据查询查询订单列表
     * @param orderDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(OrderDto orderDto, IPage<MallOrder> page) {
        LambdaQueryWrapper<MallOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(orderDto.getOrderSn()),MallOrder::getOrderSn,orderDto.getOrderSn());
        queryWrapper.eq(null != orderDto.getStatus(),MallOrder::getStatus,orderDto.getStatus());

        if (StringUtils.isNotBlank(orderDto.getUserMobile())) {
            MemUser user = userService.getUserByMobile(orderDto.getUserMobile());
            if (null == user) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MallOrder::getUserId,user.getId());
        }
        queryWrapper.between(null != orderDto.getStartTime() && null != orderDto.getEndTime(),
                            MallOrder::getCreateTime,orderDto.getStartTime(),orderDto.getEndTime());

        this.page(page,queryWrapper);

        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<OrderDto> collect = page.getRecords().stream()
                    .map(mallOrder -> {
                        OrderDto newOrderDto = new OrderDto();
                        BeanUtils.copyProperties(mallOrder, newOrderDto);
                        newOrderDto.setOrderId(mallOrder.getId());
                        Long userId = mallOrder.getUserId();
                        MemUser user = userService.getById(userId);
                        if (null != user) {
                            newOrderDto.setUserMobile(user.getMobile());
                        }
                        return newOrderDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }
}
