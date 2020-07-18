package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.exception.UnAuthenticationException;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.AdminUserService;
import com.ohayou.liteshop.vo.AdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author liyan
 * @date 2020/7/15 上午11:44
 */
@RestController
@RequestMapping("/user")
public class AdminUserController {


    @Autowired
    AdminUserService adminUserService;

    /**
     * 用户登录
     *
     * @param adminUserVo
     * @return Result
     */
    @ApiDesc("后台用户登录")
    @PostMapping("/login")
    public Result login(@Valid @RequestBody AdminUserVo adminUserVo, HttpServletRequest request, HttpServletResponse response) {

        return Result.success("userInfo", adminUserService.login(adminUserVo, request, response));
    }

    @ApiDesc("后台用户注销")
    @PostMapping("/logout")
    public Result logout(Authentication authentication, HttpServletRequest httpServletRequest) {
        adminUserService.logout(authentication,httpServletRequest);
        return Result.success();
    }
}
