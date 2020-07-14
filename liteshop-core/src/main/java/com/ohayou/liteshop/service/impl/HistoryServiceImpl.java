package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.History;
import com.ohayou.liteshop.dao.HistoryMapper;
import com.ohayou.liteshop.service.HistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 浏览历史表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-12
 */
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {

}
