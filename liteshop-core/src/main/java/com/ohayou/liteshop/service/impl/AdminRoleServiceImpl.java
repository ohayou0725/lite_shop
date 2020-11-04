package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.constant.AdminRoleStatus;
import com.ohayou.liteshop.dto.AdminRoleDto;
import com.ohayou.liteshop.entity.*;
import com.ohayou.liteshop.dao.AdminRoleMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    AdminUserRoleRelationService adminUserRoleRelationService;

    @Autowired
    AdminMenuService adminMenuService;

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    AdminRoleMenuRelatioinService adminRoleMenuRelatioin;

    @Autowired
    AdminRoleResourceRelationService adminRoleResourceRelation;

    @Override
    public List<AdminRole> roleListByUser(AdminUser user) {
        return baseMapper.findListByUser(user);
    }

    /**
     *
     * @param adminRoleDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(AdminRoleDto adminRoleDto, IPage<AdminRole> page) {
        LambdaQueryWrapper<AdminRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(adminRoleDto.getRoleName()),AdminRole::getRoleName,adminRoleDto.getRoleName());

        this.page(page,wrapper);
        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {

            List<AdminRoleDto> collect = page.getRecords().stream()
                    .map(adminRole -> {
                        AdminRoleDto newAdminRoleDto = new AdminRoleDto();
                        BeanUtils.copyProperties(adminRole, newAdminRoleDto);
                        int count = adminUserRoleRelationService.count(
                                new LambdaQueryWrapper<AdminUserRoleRelation>()
                                        .eq(AdminUserRoleRelation::getRoleId, adminRole.getId()));
                        newAdminRoleDto.setCount(count);
                        return newAdminRoleDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 更改角色状态
     * @param adminRoleDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeStatus(AdminRoleDto adminRoleDto) {
        Integer enabled = adminRoleDto.getEnabled();
        if (null == enabled) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        Long id = adminRoleDto.getId();
        AdminRole role = this.getById(id);
        if (null == role) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        if (role.getRoleName().equals("超级管理员")) {
            return false;
        }

        role.setEnabled(adminRoleDto.getEnabled());
        return this.updateById(role);
    }

    /**
     * 添加角色
     * @param adminRoleDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRole(AdminRoleDto adminRoleDto) {
        String roleName = adminRoleDto.getRoleName();
        AdminRole one = this.getOne(new LambdaQueryWrapper<AdminRole>().eq(AdminRole::getRoleName, roleName));
        if (null != one) {
            throw new GlobalException(ErrorCodeMsg.ROLE_EXIST);
        }
        AdminRole adminRole = new AdminRole();

        if (null == adminRoleDto.getEnabled()) {
            adminRole.setEnabled(AdminRoleStatus.ENABLED.getStatus());
        }
        BeanUtils.copyProperties(adminRoleDto,adminRole);
        return save(adminRole);
    }

    /**
     * 变更角色
     * @param adminRoleDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(AdminRoleDto adminRoleDto) {
        Long id = adminRoleDto.getId();
        AdminRole role = this.getById(id);
        if (null == role) {
            throw new GlobalException(ErrorCodeMsg.ROLE_NOT_FOUND);
        }

        AdminRole adminRole = new AdminRole();
        BeanUtils.copyProperties(adminRoleDto,adminRole);

        return this.updateById(adminRole);
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRole(Long roleId) {
        AdminRole one = this.getById(roleId);
        if (null == one) {
            throw new GlobalException(ErrorCodeMsg.ROLE_NOT_FOUND);
        }

        //查询是否有用户拥有该角色,如有则无法删除
        List<AdminUser> users = adminUserService.findUserByRoleId(roleId);
        if (CollectionUtil.isNotEmpty(users)) {
            throw new GlobalException(ErrorCodeMsg.USER_HAS_ROLE);
        }
        boolean remove = this.removeById(one.getId());
        if (remove) {
            LambdaQueryWrapper<AdminRoleMenuRelatioin> menuWrapper = new LambdaQueryWrapper<>();
            menuWrapper.eq(AdminRoleMenuRelatioin::getRoleId,roleId);

            LambdaQueryWrapper<AdminRoleResourceRelation> resourceWrapper = new LambdaQueryWrapper<>();
            resourceWrapper.eq(AdminRoleResourceRelation::getRoleId,roleId);
            List<AdminRoleMenuRelatioin> menus = adminRoleMenuRelatioin.list(menuWrapper);
            List<AdminRoleResourceRelation> resources = adminRoleResourceRelation.list(resourceWrapper);
            if (CollectionUtil.isEmpty(menus) && CollectionUtil.isEmpty(resources)) {
                return true;
            }
            if (CollectionUtil.isNotEmpty(menus)) {
                return adminRoleResourceRelation.remove(resourceWrapper);
            } else if (CollectionUtil.isNotEmpty(resources)) {
                return adminRoleMenuRelatioin.remove(menuWrapper);
            } else {
                return adminRoleResourceRelation.remove(resourceWrapper) && adminRoleMenuRelatioin.remove(menuWrapper);
            }

        }
        return false;
    }


}
