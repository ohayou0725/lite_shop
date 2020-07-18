package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.dao.AdminRoleMapper;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.service.AdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色表
 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {

    @Autowired
    AdminRoleMapper roleMapper;

    @Override
    public List<AdminRole> roleListByUser(AdminUser user) {
        return roleMapper.findListByUser(user);
    }
}
