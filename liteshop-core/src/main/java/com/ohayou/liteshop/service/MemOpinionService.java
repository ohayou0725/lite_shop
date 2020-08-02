package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemHistoryDto;
import com.ohayou.liteshop.dto.MemOpinionDto;
import com.ohayou.liteshop.entity.MemOpinion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

/**
 * <p>
 * 意见反馈表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MemOpinionService extends IService<MemOpinion> {

    PageUtils opinionQueryPage(MemOpinionDto opinionDto, IPage<MemOpinion> page);
}
