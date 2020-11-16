package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemUserDto;
import com.ohayou.liteshop.dto.MemberMonthStatisticsDto;
import com.ohayou.liteshop.dto.MemberStatisticsDto;
import com.ohayou.liteshop.entity.MemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

import java.util.List;

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

    MemUser getUserByMobile(String mobile);

    MemberStatisticsDto getMemberIncrementStatistics(Integer year);
}
