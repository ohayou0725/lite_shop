package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemUserDto;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.dao.MemUserMapper;
import com.ohayou.liteshop.service.MemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.DateTimeUtil;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
public class MemUserServiceImpl extends ServiceImpl<MemUserMapper, MemUser> implements MemUserService {

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
            memUser.setStatus(Integer.parseInt(memUserDto.getStatus()));
            return this.updateById(memUser);
        }
        return false;
    }



    @Override
    public Long getMemIdByMobile(String mobile) {
        MemUser one = this.getOne(new LambdaQueryWrapper<MemUser>().eq(MemUser::getMobile, mobile));
        return null != one ? one.getId() :0;
    }

}



