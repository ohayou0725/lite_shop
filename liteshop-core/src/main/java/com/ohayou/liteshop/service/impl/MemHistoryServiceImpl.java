package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.async.event.GetGoodsDetailEvent;
import com.ohayou.liteshop.dto.MemHistoryDto;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.entity.MemHistory;
import com.ohayou.liteshop.dao.MemHistoryMapper;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MemHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 浏览历史表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MemHistoryServiceImpl extends ServiceImpl<MemHistoryMapper, MemHistory> implements MemHistoryService , ApplicationListener<GetGoodsDetailEvent> {

    @Autowired
    MemUserService memUserService;

    @Autowired
    MallGoodsSpuService mallGoodsSpuService;

    @Override
    public PageUtils historyQueryPage(MemHistoryDto historyDto, IPage<MemHistory> page) {
        LambdaQueryWrapper<MemHistory> queryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(historyDto.getMobile())) {
            MemUser one = memUserService.getOne(new LambdaQueryWrapper<MemUser>().eq(MemUser::getMobile, historyDto.getMobile()));
            if (null == one) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MemHistory::getUserId,one.getId());
        }

        if (StringUtils.isNotBlank(historyDto.getSpuSn())) {
            MallGoodsSpu one = mallGoodsSpuService.getOne(new LambdaQueryWrapper<MallGoodsSpu>().eq(MallGoodsSpu::getGoodsSn, Long.valueOf(historyDto.getSpuSn())));
            if (null == one) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MemHistory::getSpuId,one.getId());
        }

        this.page(page,queryWrapper);
        PageUtils pageUtils = new PageUtils(page);

        if (null != page.getRecords() && page.getRecords().size() > 0) {
            List<MemHistoryDto> collect = page.getRecords().stream()
                    .map(memHistory -> {
                        MemHistoryDto memHistoryDto = new MemHistoryDto();
                        memHistoryDto.setBrowserTime(memHistory.getCreateTime());
                        MemUser user = memUserService.getById(memHistory.getUserId());
                        if (null != user) {
                            memHistoryDto.setMobile(user.getMobile());

                        }
                        MallGoodsSpu spu = mallGoodsSpuService.getById(memHistory.getSpuId());
                        if (null != spu) {
                            memHistoryDto.setSpuSn(String.valueOf(spu.getGoodsSn()));
                        }
                        return memHistoryDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addHistory(Long goodsId, Long userId) {
        if (null == this.mallGoodsSpuService.getById(goodsId) || null == this.memUserService.getById(userId)) {
            return false;
        }
        MemHistory one = this.getOne(new LambdaQueryWrapper<MemHistory>().eq(MemHistory::getSpuId, goodsId).eq(MemHistory::getUserId, userId));
        boolean remove = true;
        if (null != one) {
            remove = this.removeById(one.getId());
        }
        if (remove) {
            MemHistory memHistory = new MemHistory();
            memHistory.setUserId(userId);
            memHistory.setSpuId(goodsId);
            return this.save(memHistory);
        }
        return false;
    }


    @Override
    @Async
    public void onApplicationEvent(GetGoodsDetailEvent getGoodsDetailEvent) {
        Long goodsId = getGoodsDetailEvent.getGoodsId();
        Long userId = getGoodsDetailEvent.getUserId();
        this.addHistory(goodsId,userId);
    }
}
