package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.AdminResource;
import com.ohayou.liteshop.dao.AdminResourceMapper;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.AdminResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class AdminResourceServiceImpl extends ServiceImpl<AdminResourceMapper, AdminResource> implements AdminResourceService {

    @Autowired
    AdminRoleService adminRoleService;


    @Override
    public List<AdminResource> findResourceListByUser(AdminUser user) {
        if (user == null && null != user.getId()) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<AdminRole> adminRoles = adminRoleService.roleListByUser(user);
        List<Long> roleIds = adminRoles.stream()
                .map(AdminRole::getId)
                .collect(Collectors.toList());
        return roleIds.stream()
                .flatMap(id -> {
                    return findResourceListByRoleId(id).stream();
                })
                .distinct()
                .collect(Collectors.toList());
    }

    //根据角色id查询角色下所有权限
    public List<AdminResource> findResourceListByRoleId(Long roleId) {
        return baseMapper.findResourceByRole(roleId);
    }
}
