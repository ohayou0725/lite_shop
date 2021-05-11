package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.MemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.UserMessageVo;

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

    String login(MemberLoginFormDto memberLoginFormDto);

    boolean registry(RegisterFormDto registerFormDto);

    UserMessageVo getServiceChatRecordByOrder(String userMobile, Long orderId);
}
