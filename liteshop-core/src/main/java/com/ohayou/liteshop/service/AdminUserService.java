package com.ohayou.liteshop.service;

import com.ohayou.liteshop.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.vo.AdminUserVo;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 管理员用户表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface AdminUserService extends IService<AdminUser> {

    boolean login(AdminUserVo adminUserVo, HttpServletRequest request, HttpServletResponse response);

    void logout(Authentication authentication, HttpServletRequest request);

    AdminUserVo getUserInfo(Authentication authentication);
}
