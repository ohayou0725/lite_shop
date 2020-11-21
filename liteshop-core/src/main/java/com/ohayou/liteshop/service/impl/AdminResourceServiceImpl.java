package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.entity.AdminResource;
import com.ohayou.liteshop.dao.AdminResourceMapper;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.entity.AdminRoleResourceRelation;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.AdminResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.AdminRoleResourceRelationService;
import com.ohayou.liteshop.service.AdminRoleService;
import com.ohayou.liteshop.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
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

    @Autowired
    AdminRoleResourceRelationService roleResourceRelationService;



    @Override
    public List<AdminResource> findResourceListByUser(AdminUser user) {
        if (user == null || null == user.getId()) {
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

    /**
     * 更新角色下权限
     * @param roleId
     * @param resourceIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRoleResource(Long roleId, List<Long> resourceIds) {
        AdminRole role = adminRoleService.getById(roleId);
        if (null == role) {
            throw new GlobalException(ErrorCodeMsg.ROLE_NOT_FOUND);
        }
        List<AdminRoleResourceRelation> resources = roleResourceRelationService
                .list(new LambdaQueryWrapper<AdminRoleResourceRelation>()
                        .eq(AdminRoleResourceRelation::getRoleId, roleId));

        //如果该角色没有任何权限，则进行新增操作
        if (CollectionUtil.isEmpty(resources)) {
            List<AdminRoleResourceRelation> collect = resourceIds.stream().map(id -> {
                AdminRoleResourceRelation adminRoleResourceRelation = new AdminRoleResourceRelation();
                adminRoleResourceRelation.setRoleId(roleId);
                adminRoleResourceRelation.setResourceId(id);
                return adminRoleResourceRelation;
            }).collect(Collectors.toList());
            return roleResourceRelationService.saveBatch(collect);
        }
        List<Long> currentResourceIds =
                resources.stream()
                        .map(AdminRoleResourceRelation::getResourceId)
                        .sorted(Long::compareTo)
                        .collect(Collectors.toList());
        resourceIds = resourceIds.stream().sorted(Long::compareTo).collect(Collectors.toList());
        if (currentResourceIds.size() == resourceIds.size()) {
            return this.updateRoleResourceBySameSize(resources,currentResourceIds,resourceIds);
        }
        if (currentResourceIds.size() > resourceIds.size()) {
            //去掉权限
            List<AdminRoleResourceRelation> newResources = resources.stream().limit(resourceIds.size()).collect(Collectors.toList());

            List<Long> collect = resources.stream()
                    .filter(r -> {
                        return !newResources.contains(r);
                    })
                    .map(AdminRoleResourceRelation::getId)
                    .collect(Collectors.toList());

            if (roleResourceRelationService.removeByIds(collect)) {
                List<Long> collect1 = newResources.stream().map(AdminRoleResourceRelation::getId).collect(Collectors.toList());
                return this.updateRoleResourceBySameSize(resources,collect1,resourceIds);
            }
        }
        //增加权限
        if (currentResourceIds.size() < resourceIds.size()) {
            int addCount = resourceIds.size() - currentResourceIds.size();
            List<Long> subtractList = CollectionUtil.subtractToList(resourceIds, currentResourceIds);

            List<AdminRoleResourceRelation> resourceRelations = new ArrayList<>(addCount);
            List<Long> addIds = new ArrayList<>();
            for (int i = 0; i < addCount; i++) {
                AdminRoleResourceRelation adminRoleResourceRelation = new AdminRoleResourceRelation();
                adminRoleResourceRelation.setRoleId(roleId);
                adminRoleResourceRelation.setResourceId(subtractList.get(i));
                addIds.add(subtractList.get(i));
                resourceRelations.add(adminRoleResourceRelation);
            }
            if (roleResourceRelationService.saveBatch(resourceRelations)) {
                List<Long> newResourceIds = CollectionUtil.subtractToList(resourceIds, addIds);
                return this.updateRoleResourceBySameSize(resources,currentResourceIds,newResourceIds);
            }
        }
        return false;
    }

    private boolean updateRoleResourceBySameSize(List<AdminRoleResourceRelation> current, List<Long> currentIds, List<Long> resourceIds ) {
        if (ListUtil.equals(currentIds,resourceIds)) {
            return true;
        }

        List<AdminRoleResourceRelation> notExistResourceId = new ArrayList<>();
        current.forEach(resource->{
            if (!resourceIds.contains(resource.getResourceId())) {
                AdminRoleResourceRelation adminRoleResourceRelation = new AdminRoleResourceRelation();
                adminRoleResourceRelation.setId(resource.getId());
                adminRoleResourceRelation.setResourceId(0L);
                notExistResourceId.add(adminRoleResourceRelation);
            }
        });
        Collection<Long> union = CollectionUtil.union(currentIds, resourceIds);
        Collection<Long> intersection = CollectionUtil.intersection(union, resourceIds);
        List<Long> ids = new ArrayList<>(intersection);
        for (int i = 0; i < notExistResourceId.size(); i++) {
            notExistResourceId.get(i).setRoleId(ids.get(i));
        }
        return roleResourceRelationService.updateBatchById(notExistResourceId);
    }
}
