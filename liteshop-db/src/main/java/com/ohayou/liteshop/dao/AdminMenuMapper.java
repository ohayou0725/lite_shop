package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.AdminMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ohayou.liteshop.entity.AdminRole;

import java.util.List;

/**
 * <p>
 * 后台菜单表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface AdminMenuMapper extends BaseMapper<AdminMenu> {

    List<AdminMenu> listAdminMenuByRole(AdminRole role);
}
