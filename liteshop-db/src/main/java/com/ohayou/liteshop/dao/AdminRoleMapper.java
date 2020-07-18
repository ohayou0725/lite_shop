package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ohayou.liteshop.entity.AdminUser;

import java.util.List;

/**
 * <p>
 * 用户角色表
 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    List<AdminRole> findListByUser(AdminUser user);
}
