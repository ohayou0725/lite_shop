package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.AdminRoleDto;
import com.ohayou.liteshop.entity.AdminMenu;
import com.ohayou.liteshop.entity.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.utils.PageUtils;

import java.util.List;

/**
 * <p>
 * 用户角色表
 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface AdminRoleService extends IService<AdminRole> {

    List<AdminRole> roleListByUser(AdminUser user);

    PageUtils queryPage(AdminRoleDto adminRoleDto, IPage<AdminRole> page);

    boolean changeStatus(AdminRoleDto adminRoleDto);

    boolean addRole(AdminRoleDto adminRoleDto);

    boolean updateRole(AdminRoleDto adminRoleDto);

    boolean deleteRole(Long roleId);
}
