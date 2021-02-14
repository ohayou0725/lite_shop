package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.async.event.UserRegisterEvent;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.CaptchaKey;
import com.ohayou.liteshop.cache.cachekey.MemberUserTokenKey;
import com.ohayou.liteshop.constant.MemberRank;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.dao.MemUserMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.exception.UnAuthenticationException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.MemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.DateTimeUtil;
import com.ohayou.liteshop.utils.LoginCaptchaUtil;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 会员表
 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MemUserServiceImpl extends ServiceImpl<MemUserMapper, MemUser> implements MemUserService, ApplicationEventPublisherAware {

    @Autowired
    RedisService redisService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemUserService memUserService;


    @Value("${portal.sessionExpireTime}")
    private long sessionExpireTime;

    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 根据条件获取用户列表
     *
     * @param memUserDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(MemUserDto memUserDto, IPage<MemUser> page) {
        LambdaQueryWrapper<MemUser> eq = new LambdaQueryWrapper<MemUser>()
                .eq(StringUtils.isNotBlank(memUserDto.getMobile()), MemUser::getMobile, memUserDto.getMobile())
                .eq(StringUtils.isNotBlank(memUserDto.getNickname()), MemUser::getNickname, memUserDto.getNickname())
                .eq(StringUtils.isNotBlank(memUserDto.getRank()), MemUser::getRank, memUserDto.getRank())
                .eq(StringUtils.isNotBlank(memUserDto.getGender()), MemUser::getGender, memUserDto.getGender())
                .eq(StringUtils.isNotBlank(memUserDto.getStatus()), MemUser::getStatus, memUserDto.getStatus())
                .apply(null != memUserDto.getRegisterDate(),
                        DateTimeUtil.sqlDateFormat("create_time") + "= {0}", memUserDto.getRegisterDate());
        //查询page
        this.page(page,eq);
        PageUtils pageUtils = new PageUtils(page);
//        entity转换dto
        if (page.getRecords() != null && page.getRecords().size() > 0) {
            List<MemUserDto> collect = page.getRecords().stream()
                    .map(memUser -> {
                        MemUserDto memUserDto1 = new MemUserDto();
                        BeanUtils.copyProperties(memUser, memUserDto1);
                        memUserDto1.setStatus(String.valueOf(memUser.getStatus()));
                        memUserDto1.setRegisterDate(memUser.getCreateTime().toLocalDate());
                        return memUserDto1;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }

        return pageUtils;
    }

    /**
     * 改变用户状态
     * @param memUserDto
     * @return result
     */
    @Override
    public boolean changeStatus(MemUserDto memUserDto) {
        if (memUserDto.getId() != null && memUserDto.getStatus() != null) {
            MemUser memUser = this.getById(memUserDto.getId());
            if (memUser == null) {
                throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
            }
            memUser.setStatus(Integer.parseInt(memUserDto.getStatus()));
            return this.updateById(memUser);
        }
        return false;
    }



    @Override
    public Long getMemIdByMobile(String mobile) {
        MemUser one = this.getUserByMobile(mobile);
        return null != one ? one.getId() :0;
    }

    @Override
    public MemUser getUserByMobile(String mobile) {
        return this.getOne(new LambdaQueryWrapper<MemUser>().eq(MemUser::getMobile,mobile));
    }

    /**
     * 查询统计每月用户增量
     * @param year
     * @return
     */
    @Override
    public MemberStatisticsDto getMemberIncrementStatistics(Integer year) {

        MemberStatisticsDto memberStatisticsDto = new MemberStatisticsDto();
        memberStatisticsDto.setYear(year);
        memberStatisticsDto.setTotal(this.count());
        List<MemberMonthStatisticsDto> memberStatistics = new ArrayList<>(12);
        LambdaQueryWrapper<MemUser> wrapper;

        for (int i = 1; i <= 12; i++) {
            MemberMonthStatisticsDto memberMonthStatisticsDto = new MemberMonthStatisticsDto();
            memberMonthStatisticsDto.setMonth(String.valueOf(i));
            LocalDate currentMonth = LocalDate.of(year, i, 1);
            wrapper = new LambdaQueryWrapper<MemUser>()
                    .between(MemUser::getCreateTime, currentMonth, LocalDate.of(year, i, currentMonth.lengthOfMonth()));
            int count = this.count(wrapper);
            memberMonthStatisticsDto.setTotal(count);
            memberStatistics.add(memberMonthStatisticsDto);
        }

        for (int i = 0; i < 12; i++) {
            MemberMonthStatisticsDto currentMonth = memberStatistics.get(i);
            if (i != 0) {
                currentMonth.setIncrement(currentMonth.getTotal()-memberStatistics.get(i-1).getTotal());
            } else {
                currentMonth.setIncrement(0);
            }
        }
        memberStatisticsDto.setMemberMonthStatisticsDtos(memberStatistics);
        return memberStatisticsDto;

    }

    /**
     * 前台会员登录
     * @param memberLoginFormDto 登录表单
     * @return token
     */
    @Override
    public String login(MemberLoginFormDto memberLoginFormDto) {
        boolean result = this.verifyCaptcha(memberLoginFormDto.getCaptcha(), memberLoginFormDto.getCaptchaId());
        if (!result) {
            throw new GlobalException(ErrorCodeMsg.CAPTCHA_ERROR);
        }
        //验证码通过后进行账户认证
        MemUser user = memUserService.getUserByMobile(memberLoginFormDto.getMobile());
        if (null == user) {
            throw new GlobalException(ErrorCodeMsg.MEMBER_AUTH_ERROR);
        }
        if (1 != user.getStatus()) {
            throw new GlobalException(ErrorCodeMsg.MEMBER_DISABLED);
        }

        if (!passwordEncoder.matches(memberLoginFormDto.getPassword(),user.getPassword())) {
            throw new UnAuthenticationException(ErrorCodeMsg.MEMBER_AUTH_ERROR);
        }
        //生成token存入redis
        String token = TokenUtil.generateToken(user.getMobile());
        MemberUserTokenKey memberUserTokenKey = new MemberUserTokenKey(token);
        if(!redisService.set(memberUserTokenKey.getPrefix(),user.getMobile(),sessionExpireTime)) {
            throw new GlobalException(ErrorCodeMsg.SERVER_ERROR);
        }
        return token;
    }

    @Override
    public boolean registry(RegisterFormDto registerFormDto) {
        boolean result = this.verifyCaptcha(registerFormDto.getCaptcha(), registerFormDto.getCaptchaId());
        if (!result) {
            throw new GlobalException(ErrorCodeMsg.CAPTCHA_ERROR);
        }
        //校验两次输入密码是否一致
        String password = registerFormDto.getPassword();
        String confirmPassword = registerFormDto.getConfirmPassword();
        if (!password.equals(confirmPassword)) {
            throw new GlobalException(ErrorCodeMsg.TWO_PASSWORD_NOT_EQUALS);
        }
        //检查该手机是否已经注册
        int count = this.count(new LambdaQueryWrapper<MemUser>().eq(MemUser::getMobile, registerFormDto.getMobile()));
        if (count > 0) {
            throw new GlobalException(ErrorCodeMsg.MEMBER_EXIST);
        }
        MemUser memUser = new MemUser();
        memUser.setMobile(registerFormDto.getMobile());
        memUser.setPassword(passwordEncoder.encode(registerFormDto.getPassword()));
        memUser.setStatus(1);
        memUser.setRank(MemberRank.GENERAL_USER.getRank());
        memUser.setNickname(registerFormDto.getMobile());
        boolean save = this.save(memUser);
        if (save) {
            applicationEventPublisher.publishEvent(new UserRegisterEvent(this,memUser.getId()));
        }
        return save;
    }

    private boolean verifyCaptcha(String captcha, String captchaId) {
        //校验验证码是否正确
        if (StringUtils.isBlank(captcha) || StringUtils.isBlank(captchaId)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        CaptchaKey captchaKey = new CaptchaKey(captchaId);
        if (!redisService.hasKey(captchaKey.getPrefix())) {
            throw new GlobalException(ErrorCodeMsg.CAPTCHA_EXPIRED);
        }
        String result = (String)redisService.get(captchaKey.getPrefix());
        return LoginCaptchaUtil.verify(result,captcha);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


}



