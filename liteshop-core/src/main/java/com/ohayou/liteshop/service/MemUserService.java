package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemAddrDto;
import com.ohayou.liteshop.dto.MemCollectDto;
import com.ohayou.liteshop.dto.MemUserDto;
import com.ohayou.liteshop.entity.MemAddress;
import com.ohayou.liteshop.entity.MemCollect;
import com.ohayou.liteshop.entity.MemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;

/**
 * <p>
 * 会员表
 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MemUserService extends IService<MemUser> {

    PageUtils queryPage(MemUserDto memUserDto, IPage<MemUser> page);

    boolean changeStatus(MemUserDto memUserDto);

    Long getMemIdByMobile(String mobile);

}
