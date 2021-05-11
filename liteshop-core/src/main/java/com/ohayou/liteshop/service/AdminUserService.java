package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.AdminUserDto;
import com.ohayou.liteshop.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.AdminUserVo;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    PageUtils queryPage(AdminUserDto adminUserDto, IPage<AdminUser> page);

    boolean addUser(AdminUserDto adminUserDto);

    boolean resetPassword(Long id);

    boolean updateUser(AdminUserDto adminUserDto);

    boolean deleteUser(Long id);

    List<AdminUser> findUserByRoleId(Long roleId);

    void removeCacheByRoleId(Long roleId);

    boolean updatePassword(Long id, String oldPassword, String newPassword);

    boolean updateUserInfo(AdminUserVo adminUserVo);

    void readChatRecord(long id, String userMobile);

}
