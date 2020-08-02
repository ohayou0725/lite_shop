package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.constant.OpinionType;
import com.ohayou.liteshop.dto.MemOpinionDto;
import com.ohayou.liteshop.entity.MemOpinion;
import com.ohayou.liteshop.dao.MemOpinionMapper;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.service.MemOpinionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 意见反馈表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MemOpinionServiceImpl extends ServiceImpl<MemOpinionMapper, MemOpinion> implements MemOpinionService {
    @Autowired
    MemUserService memUserService;

    @Override
    public PageUtils opinionQueryPage(MemOpinionDto opinionDto, IPage<MemOpinion> page) {
        LambdaQueryWrapper<MemOpinion> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(opinionDto.getMobile())) {
            MemUser one = memUserService.getOne(new LambdaQueryWrapper<MemUser>().eq(MemUser::getMobile, opinionDto.getMobile()));
            if (null != one) {
                queryWrapper.eq(MemOpinion::getUserId,one.getId());
            }
        }
        queryWrapper.eq(StringUtils.isNotBlank(opinionDto.getOpinionType()),MemOpinion::getOpinionType, opinionDto.getOpinionType());
        this.page(page,queryWrapper);

        PageUtils pageUtils = new PageUtils(page);
        if (null != page.getRecords() && page.getRecords().size() > 0) {
            List<Object> collect = page.getRecords().stream()
                    .map(memOpinion -> {
                        MemOpinionDto memOpinionDto = new MemOpinionDto();
                        BeanUtils.copyProperties(memOpinion, memOpinionDto);
                        memOpinionDto.setOpinionType(String.valueOf(memOpinion.getOpinionType()));
                        memOpinionDto.setOpinionTime(memOpinion.getCreateTime());
                        MemUser one = memUserService.getById(memOpinion.getUserId());
                        if (null != one) {
                            memOpinionDto.setMobile(one.getMobile());
                            memOpinionDto.setNickName(one.getNickname());
                        }
                        return memOpinionDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }
}
