package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemCollectDto;
import com.ohayou.liteshop.entity.MemCollect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

/**
 * <p>
 * 用户收藏表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MemCollectService extends IService<MemCollect> {

    PageUtils collectQueryPage(MemCollectDto collectDto, IPage<MemCollect> page);

    boolean hasCollectByUser(Long goodsId, Long id);

    boolean addCollect(Long goodsId, Long id);

    boolean deleteCollect(Long goodsId, Long id);
}
