package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.MallOrder;
import com.ohayou.liteshop.dao.MallOrderMapper;
import com.ohayou.liteshop.service.MallOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
