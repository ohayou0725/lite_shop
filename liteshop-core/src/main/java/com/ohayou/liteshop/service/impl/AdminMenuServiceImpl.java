package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.AdminMenu;
import com.ohayou.liteshop.dao.AdminMenuMapper;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.AdminMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.AdminRoleService;
import com.ohayou.liteshop.vo.AdminMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements AdminMenuService {

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminMenuMapper adminMenuMapper;


    //获取角色拥有的菜单
    @Override
    public List<AdminMenuVo> ListAdminMenuTree(AdminUser adminUser) {
        if (adminUser == null || adminUser.getId() == null) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<AdminRole> adminRoles = adminRoleService.roleListByUser(adminUser);
        //获取当前用户下的角色的所有菜单
        Set<AdminMenu> adminMenuSet = new HashSet<>();
        adminRoles.forEach(role -> {
            adminMenuSet.addAll(adminMenuMapper.listAdminMenuByRole(role));
        });

        //获取该角色下的所有一级菜单
        List<AdminMenu> rootMenu = getRootMenu(adminMenuSet);
        //获取所有菜单
        List<AdminMenuVo> collect = rootMenu.stream()
                .map(adminMenu -> {
                    AdminMenuVo adminMenuVo = new AdminMenuVo();
                    adminMenuVo.setId(adminMenu.getId());
                    adminMenuVo.setTitle(adminMenu.getTitle());
                    adminMenuVo.setName(adminMenu.getName());
                    adminMenuVo.setHidden(adminMenu.getHidden() == 0);
                    adminMenuVo.setIcon(adminMenu.getIcon());
                    adminMenuVo.setLevel(adminMenu.getLevel());
                    adminMenuVo.setSort(adminMenu.getSort());
                    adminMenuVo.setChildren(getChildrenMenu(adminMenu,adminMenuSet));
                    return adminMenuVo;
                })
                .collect(Collectors.toList());
        return collect;

    }

    //获取所有一级菜单
    private List<AdminMenu> getRootMenu(Collection<AdminMenu> adminMenus) {
        return adminMenus.stream()
                .filter(adminMenu -> {
                    return adminMenu.getLevel() == 0;
                })
                .sorted(Comparator.comparing(AdminMenu::getSort))
                .collect(Collectors.toList());
    }

    //递归查找所有子菜单
    private List<AdminMenuVo> getChildrenMenu(AdminMenu root ,Collection<AdminMenu> all) {
        List<AdminMenuVo> collect = all.stream().filter(adminMenu -> {
            return adminMenu.getParentId() == root.getId();
        }).map(children -> {
            AdminMenuVo adminMenuVo = new AdminMenuVo();
            adminMenuVo.setId(children.getId());
            adminMenuVo.setTitle(children.getTitle());
            adminMenuVo.setName(children.getName());
            adminMenuVo.setHidden(children.getHidden() == 0);
            adminMenuVo.setIcon(children.getIcon());
            adminMenuVo.setLevel(children.getLevel());
            adminMenuVo.setSort(children.getSort());
            adminMenuVo.setChildren(getChildrenMenu(children, all));
            return adminMenuVo;
        }).sorted(Comparator.comparing(AdminMenuVo::getSort))
                .collect(Collectors.toList());
        return collect;
    }


}
