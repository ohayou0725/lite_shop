package com.ohayou.liteshop.service;

import com.ohayou.liteshop.entity.AdminMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.vo.AdminMenuVo;

import java.util.List;

/**
 * <p>
 * 后台菜单表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface AdminMenuService extends IService<AdminMenu> {

    List<AdminMenuVo> ListAdminMenuTree(AdminUser adminUser);
}
