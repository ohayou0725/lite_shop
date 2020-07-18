package com.ohayou.liteshop.service;

import com.ohayou.liteshop.entity.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.entity.AdminUser;

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
}
