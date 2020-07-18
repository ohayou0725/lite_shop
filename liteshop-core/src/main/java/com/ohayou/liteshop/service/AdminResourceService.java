package com.ohayou.liteshop.service;

import com.ohayou.liteshop.entity.AdminResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.entity.AdminUser;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface AdminResourceService extends IService<AdminResource> {

    List<AdminResource> findResourceListByUser(AdminUser user);

    List<AdminResource> findResourceListByRoleId(Long roleId);
}
