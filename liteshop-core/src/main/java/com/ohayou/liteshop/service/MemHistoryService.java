package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.async.event.GetGoodsDetailEvent;
import com.ohayou.liteshop.dto.MemHistoryDto;
import com.ohayou.liteshop.entity.MemHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

/**
 * <p>
 * 浏览历史表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MemHistoryService extends IService<MemHistory> {

    PageUtils historyQueryPage(MemHistoryDto historyDto, IPage<MemHistory> page);

    boolean addHistory(Long GoodsId, Long userId);


}
