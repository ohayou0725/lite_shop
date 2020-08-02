package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemCollectDto;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.entity.MemCollect;
import com.ohayou.liteshop.dao.MemCollectMapper;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MemCollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户收藏表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MemCollectServiceImpl extends ServiceImpl<MemCollectMapper, MemCollect> implements MemCollectService {
    @Autowired
    MemUserService memUserService;

    @Autowired
    MallGoodsSpuService mallGoodsSpuService;

    @Override
    public PageUtils collectQueryPage(MemCollectDto collectDto, IPage<MemCollect> page) {
        LambdaQueryWrapper<MemCollect> queryWrapper = new LambdaQueryWrapper<>();

        //如果查询参数有mobile字段，拼接mobile查询条件
        if (StringUtils.isNotBlank(collectDto.getMobile())) {
            MemUser one = memUserService.getOne(new LambdaQueryWrapper<MemUser>().
                    eq(MemUser::getMobile, collectDto.getMobile()));
            if (null == one) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MemCollect::getUserId, one.getId());
        }
        //如果查询参数有spuSn字段，拼接spuSn查询条件
        if (StringUtils.isNotBlank(collectDto.getSpuSn())) {
            MallGoodsSpu one = mallGoodsSpuService.getOne(new LambdaQueryWrapper<MallGoodsSpu>()
                    .eq(MallGoodsSpu::getGoodsSn, Long.parseLong(collectDto.getSpuSn())));;
            if (null == one) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MemCollect::getSpuId, one.getId());
        }
        this.page(page, queryWrapper);
        PageUtils pageUtils = new PageUtils(page);

        if (page.getRecords() != null && page.getRecords().size() > 0) {
            List<MemCollectDto> collect = page.getRecords().stream()
                    .map(memCollect -> {
                        MemCollectDto memCollectDto = new MemCollectDto();
                        memCollectDto.setJoinTime(memCollect.getCreateTime());
                        MemUser user = memUserService.getById(memCollect.getUserId());
                        if (null != user) {
                            memCollectDto.setMobile(user.getMobile());
                        }
                        MallGoodsSpu spu = mallGoodsSpuService.getById(memCollect.getSpuId());
                        if (null != spu) {
                            memCollectDto.setSpuSn(String.valueOf(spu.getGoodsSn()));
                        }
                        return memCollectDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }

        return pageUtils;
    }
}
