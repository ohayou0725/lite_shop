package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.entity.AdminMenu;
import com.ohayou.liteshop.dao.AdminMenuMapper;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.entity.AdminRoleMenuRelatioin;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.AdminMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.AdminRoleMenuRelatioinService;
import com.ohayou.liteshop.service.AdminRoleService;
import com.ohayou.liteshop.utils.ListUtil;
import com.ohayou.liteshop.vo.AdminMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    AdminRoleMenuRelatioinService adminRoleMenuRelatioinService;


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
            adminMenuSet.addAll(baseMapper.listAdminMenuByRole(role));
        });

        //获取该角色下的所有一级菜单
        List<AdminMenu> rootMenu = getRootMenu(adminMenuSet);
        //获取所有菜单

        return rootMenu.stream()
                .map(adminMenu -> {
                    AdminMenuVo adminMenuVo = new AdminMenuVo();
                    adminMenuVo.setId(adminMenu.getId());
                    adminMenuVo.setTitle(adminMenu.getTitle());
                    adminMenuVo.setName(adminMenu.getName());
                    adminMenuVo.setHidden(adminMenu.getHidden() == 0);
                    adminMenuVo.setIcon(adminMenu.getIcon());
                    adminMenuVo.setLevel(adminMenu.getLevel());
                    adminMenuVo.setSort(adminMenu.getSort());
                    adminMenuVo.setChildren(getChildrenMenu(adminMenu, adminMenuSet));
                    return adminMenuVo;
                })
                .collect(Collectors.toList());

    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    @Override
    public List<AdminMenuVo> allMenuTree() {
        List<AdminMenu> list = this.list();
        List<AdminMenu> rootMenu = this.getRootMenu(list);

        return rootMenu.stream()
                .map(menu -> {
                    AdminMenuVo adminMenuVo = new AdminMenuVo();
                    adminMenuVo.setId(menu.getId());
                    adminMenuVo.setTitle(menu.getTitle());
                    adminMenuVo.setName(menu.getName());
                    adminMenuVo.setHidden(menu.getHidden() == 0);
                    adminMenuVo.setIcon(menu.getIcon());
                    adminMenuVo.setLevel(menu.getLevel());
                    adminMenuVo.setSort(menu.getSort());
                    adminMenuVo.setChildren(this.getChildrenMenu(menu, list));
                    return adminMenuVo;
                }).sorted(Comparator.comparing(AdminMenuVo::getSort))
                .collect(Collectors.toList());
    }

    @Override
    public List<AdminMenu> menuListByRoleId(Long id) {
        AdminRole role = adminRoleService.getById(id);
        if (null == role) {
            throw new GlobalException(ErrorCodeMsg.ROLE_NOT_FOUND);
        }
        return this.baseMapper.listAdminMenuByRole(role);
    }

    /**
     * 更新角色菜单
     *
     * @param roleId
     * @param roleIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRoleMenu(Long roleId, List<Long> menuIds) {
        AdminRole role = adminRoleService.getById(roleId);
        if (null == role) {
            throw new GlobalException(ErrorCodeMsg.ROLE_NOT_FOUND);
        }
        List<AdminRoleMenuRelatioin> menuList = adminRoleMenuRelatioinService.list(new LambdaQueryWrapper<AdminRoleMenuRelatioin>()
                .eq(AdminRoleMenuRelatioin::getRoleId, roleId));
        if (CollectionUtil.isEmpty(menuList)) {
            List<AdminRoleMenuRelatioin> collect = menuIds.stream()
                    .map(id -> {
                        AdminRoleMenuRelatioin adminRoleMenuRelatioin = new AdminRoleMenuRelatioin();
                        adminRoleMenuRelatioin.setMenuId(id);
                        adminRoleMenuRelatioin.setRoleId(roleId);
                        return adminRoleMenuRelatioin;
                    }).collect(Collectors.toList());
            return adminRoleMenuRelatioinService.saveBatch(collect);

        }
        List<Long> currentMenuIds = menuList
                .stream()
                .sorted(Comparator.comparing(AdminRoleMenuRelatioin::getMenuId))
                .map(AdminRoleMenuRelatioin::getMenuId)
                .collect(Collectors.toList());
        menuIds = menuIds.stream()
                .sorted(Long::compare).collect(Collectors.toList());
        if (ListUtil.equals(currentMenuIds, menuIds)) {
            return true;
        }
        //如果所要更新ID没有新增和删除
        if (currentMenuIds.size() == menuIds.size()) {
            return this.updateRoleMenuBySameSize(menuList,currentMenuIds,menuIds);
        }

        //减少菜单
        if (currentMenuIds.size() > menuIds.size()) {
            int deleteCount = currentMenuIds.size() - menuIds.size();
            List<AdminRoleMenuRelatioin> newMenuList = menuList.
                    stream().
                    limit(menuList.size() - deleteCount).collect(Collectors.toList());

            List<Long> collect = menuList.stream()
                    .filter(id -> {
                        return !newMenuList.contains(id);
                    })
                    .map(AdminRoleMenuRelatioin::getId)
                    .collect(Collectors.toList());
            if (adminRoleMenuRelatioinService.removeByIds(collect)) {
                List<Long> collect1 = newMenuList.stream().map(AdminRoleMenuRelatioin::getMenuId).collect(Collectors.toList());
                return this.updateRoleMenuBySameSize(newMenuList,collect1,menuIds);
            }
        }

        //增加菜单
        if (currentMenuIds.size() < menuIds.size()) {
            int addCount = menuIds.size() - currentMenuIds.size();
            List<Long> subtractList = CollectionUtil.subtractToList(menuIds, currentMenuIds);
            List<AdminRoleMenuRelatioin> menuRelatioins = new ArrayList<>(addCount);

            List<Long> addIds = new ArrayList<>();
            for (int i = 0; i < addCount; i++) {
                AdminRoleMenuRelatioin menuRelatioin = new AdminRoleMenuRelatioin();
                menuRelatioin.setRoleId(roleId);
                menuRelatioin.setMenuId(subtractList.get(i));
                addIds.add(subtractList.get(i));
                menuRelatioins.add(menuRelatioin);
            }
            if (adminRoleMenuRelatioinService.saveBatch(menuRelatioins)) {
                   List<Long> newRoleIds = CollectionUtil.subtractToList(menuIds, addIds);
                   return this.updateRoleMenuBySameSize(menuList,currentMenuIds,newRoleIds);
            }

        }

        return false;
    }

    private boolean updateRoleMenuBySameSize(List<AdminRoleMenuRelatioin> menuList,
                                             List<Long> currentMenuIds,
                                             List<Long> menuIds) {
        if (ListUtil.equals(currentMenuIds,menuIds)) {
            return true;
        }
        List<AdminRoleMenuRelatioin> notExistList = new ArrayList<>();
        menuList.forEach(r -> {
            if (!menuIds.contains(r.getMenuId())) {
                AdminRoleMenuRelatioin menuRelatioin = new AdminRoleMenuRelatioin();
                menuRelatioin.setId(r.getId());
                menuRelatioin.setMenuId(0L);
                notExistList.add(menuRelatioin);
            }
        });
        Collection<Long> union = CollectionUtil.union(currentMenuIds, menuIds);

        Collection<Long> intersection = CollectionUtil.intersection(union, menuIds);
        List<Long> intersectionList = new ArrayList<>(intersection);
        for (int i = 0; i < notExistList.size(); i++) {
            notExistList.get(i).setMenuId(intersectionList.get(i));
        }
        return adminRoleMenuRelatioinService.updateBatchById(notExistList);

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
    private List<AdminMenuVo> getChildrenMenu(AdminMenu root, Collection<AdminMenu> all) {

        return all.stream().filter(adminMenu -> {
            return adminMenu.getParentId().equals(root.getId());
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
    }


}
