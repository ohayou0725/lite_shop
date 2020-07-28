package com.ohayou.liteshop.service;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.AdminLogDto;
import com.ohayou.liteshop.entity.AdminLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

/**
 * <p>
 * 用户操作日志表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface AdminLogService extends IService<AdminLog> {

    PageUtils queryPage(IPage<AdminLog> page, AdminLogDto userLogDto);
}
