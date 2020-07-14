package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.dao.AdminUserMapper;
import com.ohayou.liteshop.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员用户表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-12
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

}
