package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.Address;
import com.ohayou.liteshop.dao.AddressMapper;
import com.ohayou.liteshop.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货地址表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-12
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
