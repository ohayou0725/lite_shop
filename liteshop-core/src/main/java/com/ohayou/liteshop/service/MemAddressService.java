package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemAddrDto;
import com.ohayou.liteshop.entity.MemAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

/**
 * <p>
 * 收货地址表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MemAddressService extends IService<MemAddress> {

    PageUtils addrQueryPage(MemAddrDto addrDto, IPage<MemAddress> page);
}
