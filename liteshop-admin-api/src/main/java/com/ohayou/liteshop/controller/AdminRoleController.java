package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyan
 * @date 2020/10/20 下午9:41
 */
@RestController
@RequestMapping("system/userRole")
public class AdminRoleController {

    @Autowired
    AdminRoleService roleService;

    @ApiDesc("查询所有角色")
    @GetMapping("/all")
    public Result allRole() {
        return Result.success("list",roleService.list());
    }

}
