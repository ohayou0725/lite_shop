package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.AdminLog;
import com.ohayou.liteshop.dao.AdminLogMapper;
import com.ohayou.liteshop.service.AdminLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户操作日志表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-12
 */
@Service
public class AdminLogServiceImpl extends ServiceImpl<AdminLogMapper, AdminLog> implements AdminLogService {

}
