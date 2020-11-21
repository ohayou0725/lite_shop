package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.AdminUserDto;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.AdminUserDetails;
import com.ohayou.liteshop.service.AdminUserService;
import com.ohayou.liteshop.service.UploadService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.AdminUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/7/15 上午11:44
 */
@RestController
public class AdminUserController {


    @Autowired
    AdminUserService adminUserService;

    @Autowired
    UploadService qiniuUploadService;

    /**
     * 用户登录
     *
     * @param adminUserVo
     * @return Result
     */
    @ApiDesc("后台用户登录")
    @PostMapping("/user/login")
    public Result login(@Validated(AdminUserVo.LoginFormGroup.class) @RequestBody AdminUserVo adminUserVo, HttpServletRequest request, HttpServletResponse response) {
        if (adminUserService.login(adminUserVo,request,response)){
            return Result.success();
        }
        return null;
    }

    @ApiDesc("后台用户注销")
    @PostMapping("/user/logout")
    public Result logout(Authentication authentication, HttpServletRequest httpServletRequest) {
        adminUserService.logout(authentication,httpServletRequest);
        return Result.success();
    }

    @ApiDesc("获取后台用户信息")
    @GetMapping("/user/info")
    public Result userInfo(Authentication authentication) {
        return Result.success("userInfo",adminUserService.getUserInfo(authentication));
    }
    @ApiDesc("查询后台管理员列表")
    @GetMapping("/system/user/list")
    public Result userList(AdminUserDto adminUserDto, Map<String,Object> queryParam) {
        PageQuery<AdminUser> adminUserPageQuery = new PageQuery<>();
        IPage<AdminUser> page = adminUserPageQuery.getPage(queryParam);
        PageUtils pageUtils = adminUserService.queryPage(adminUserDto,page);
        return Result.success("page",pageUtils);
    }

    @ApiDesc("添加用户")
    @PostMapping("/system/user/add")
    public Result addUser(@RequestBody @Valid AdminUserDto adminUserDto) {
        boolean result = adminUserService.addUser(adminUserDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.USER_ADD_ERROR);
    }

    @ApiDesc("重置用户密码")
    @PostMapping("/system/user/resetPassword/{id}")
    public Result resetPassword(@PathVariable("id") Long id) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = adminUserService.resetPassword(id);
        if (result) {
            adminUserService.removeCacheByRoleId(id);
        }
        return result ? Result.success() : Result.error(ErrorCodeMsg.USER_CANT_RESET);
    }

    @ApiDesc("上传用户头像")
    @PostMapping("/system/user/upload")
    public Result upload(@RequestParam("file")MultipartFile file) {
        String fileName = "admin/avatar/";
        String url = qiniuUploadService.upload(file, fileName);
        return Result.success("url",url);
    }

    @ApiDesc("编辑用户")
    @PostMapping("/system/user/update")
    public Result update(@RequestBody @Validated(value = AdminUserDto.UpdateUser.class) AdminUserDto adminUserDto) {
        boolean result = adminUserService.updateUser(adminUserDto);
        if (result) {
            adminUserService.removeCacheByRoleId(adminUserDto.getId());
        }
        return result ? Result.success() : Result.error(ErrorCodeMsg.USER_UPDATE_ERROR);
    }

    @ApiDesc("删除用户")
    @PostMapping("/system/user/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = adminUserService.deleteUser(id);
        return result ? Result.success() : Result.error(ErrorCodeMsg.USER_DELETE_ERROR);
    }

    @ApiDesc("修改用户密码")
    @PostMapping("/user/updatePassword/{id}")
    public Result updatePassword(@PathVariable("id") Long id, @RequestBody Map<String,String> params ) {
        String oldPassword = params.get("oldPassword");
        String newPassword = params.get("newPassword");

        if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        //验证当前账号，防止横向越权
        AdminUserDetails currentUser = (AdminUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long currentUserId = currentUser.getId();
        if (id != currentUserId) {
            throw new GlobalException(ErrorCodeMsg.ACCESS_DENIED_ERROR);
        }

        boolean result = adminUserService.updatePassword(id,oldPassword,newPassword);
        if (result) {
            adminUserService.removeCacheByRoleId(id);
        }
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_PASSWORD_ERROR);
    }

    @ApiDesc("修改用户基本信息")
    @PostMapping("/user/updateUserInfo")
    public Result updateUserInfo(@RequestBody @Validated(value = AdminUserVo.UpdateFormGroup.class) AdminUserVo adminUserVo) {
        AdminUserDetails currentUser = (AdminUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long currentUserId = currentUser.getId();
        if (adminUserVo.getId() != currentUserId) {
            throw new GlobalException(ErrorCodeMsg.ACCESS_DENIED_ERROR);
        }

        boolean result = adminUserService.updateUserInfo(adminUserVo);
        if (result) {
            adminUserService.removeCacheByRoleId(adminUserVo.getId());
        }
        return result ? Result.success() : Result.error(ErrorCodeMsg.USER_UPDATE_ERROR);
    }
}
