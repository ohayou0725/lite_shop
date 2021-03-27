package com.ohayou.liteshop.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.dto.AdminRoleDto;
import com.ohayou.liteshop.entity.AdminMenu;
import com.ohayou.liteshop.entity.AdminResource;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.AdminMenuService;
import com.ohayou.liteshop.service.AdminResourceService;
import com.ohayou.liteshop.service.AdminRoleService;
import com.ohayou.liteshop.service.AdminUserService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.AdminMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/10/20 下午9:41
 */
@RestController
@RequestMapping("system/userRole")
public class AdminRoleController {

    @Autowired
    AdminRoleService roleService;

    @Autowired
    AdminMenuService adminMenuService;

    @Autowired
    AdminResourceService adminResourceService;

    @Autowired
    RedisService redisService;

    @Autowired
    AdminUserService adminUserService;



    @ApiDesc("查询所有角色")
    @GetMapping("/all")
    public Result allRole() {

        return Result.success("list",roleService.list(new LambdaQueryWrapper<AdminRole>().eq(AdminRole::getEnabled,1)));
    }

    @ApiDesc("条件查询角色")
    @GetMapping("/list")
    public Result list(AdminRoleDto adminRoleDto, @RequestParam Map<String,Object> queryParam) {
        PageQuery<AdminRole> pageQuery = new PageQuery<>();
        IPage<AdminRole> page = pageQuery.getPage(queryParam);
        PageUtils pageUtils = roleService.queryPage(adminRoleDto,page);

        return Result.success("page",pageUtils);
    }

    @ApiDesc("更改角色状态")
    @PostMapping("/changeStatus")
    public Result changeStatus(@RequestBody @Validated(value = AdminRoleDto.UpdateAdminRole.class) AdminRoleDto adminRoleDto) {
        boolean result = roleService.changeStatus(adminRoleDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.CHANGE_STATUS_ERROR);
    }

    @ApiDesc("添加新角色")
    @PostMapping("/add")
    public Result addRole(@RequestBody @Validated(value = AdminRoleDto.AddAdminRole.class) AdminRoleDto adminRoleDto) {
        boolean result = roleService.addRole(adminRoleDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.ADD_ROLE_ERROR);
    }

    @ApiDesc("变更角色")
    @PostMapping("/update")
    public Result updateRole(@RequestBody @Validated(value = AdminRoleDto.UpdateAdminRole.class) AdminRoleDto adminRoleDto) {
        boolean result = roleService.updateRole(adminRoleDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_ROLE_ERROR);
    }

    @ApiDesc("获取所有菜单")
    @GetMapping("/allMenu")
    public Result allMenu() {
        List<AdminMenuVo> tree = adminMenuService.allMenuTree();
        return Result.success("list",tree);
    }

    @ApiDesc("获取角色菜单")
    @GetMapping("/menu/{id}")
    public Result getMenu(@PathVariable("id") Long id) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        List<AdminMenu> adminMenus = adminMenuService.menuListByRoleId(id);
        return Result.success("list",adminMenus);
    }

    @ApiDesc("分配角色菜单")
    @PostMapping("/assignMenu/{id}")
    public Result updateMenu(@PathVariable("id") Long roleId, @RequestBody List<Long> roleIds) {
        if (null == roleId || roleId < 1 || CollectionUtil.isEmpty(roleIds)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = adminMenuService.updateRoleMenu(roleId,roleIds);
        if (result) {
            //如果修改成功，则需对redis中拥有该角色的用户缓存进行删除
            adminUserService.removeCacheByRoleId(roleId);
        }
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_ROLE_ERROR);
    }

    @ApiDesc("查询角色权限")
    @GetMapping("/resource/{id}")
    public Result getResource(@PathVariable("id") Long roleId) {
        if (null == roleId || roleId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<AdminResource> resources = adminResourceService.findResourceListByRoleId(roleId);
        return Result.success("list",resources);
    }

    @ApiDesc("获取所有权限列表")
    @GetMapping("/allResource")
    public Result allResource() {
        List<AdminResource> list = adminResourceService.list();
        return Result.success("list",list);
    }

    @ApiDesc("分配权限")
    @PostMapping("/assignResource/{id}")
    public Result updateResource(@PathVariable("id") Long roleId,@RequestBody List<Long> resourceIds ) {
        if (null == roleId || roleId < 1 || CollectionUtil.isEmpty(resourceIds)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = adminResourceService.updateRoleResource(roleId,resourceIds);
        if (result) {
            //如果修改成功，则需对redis中拥有该角色的用户缓存进行删除
            adminUserService.removeCacheByRoleId(roleId);
        }
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_ROLE_ERROR);
    }

    @ApiDesc("删除角色")
    @PostMapping("/delete/{id}")
    public Result deleteRole(@PathVariable("id") Long roleId) {
        if (null == roleId || roleId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = roleService.deleteRole(roleId);
        if (result) {
            adminUserService.removeCacheByRoleId(roleId);
        }
        return result ? Result.success() : Result.error(ErrorCodeMsg.ROLE_DELETE_ERROR);
    }
}
