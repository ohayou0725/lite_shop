package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.InvalidTokenKey;
import com.ohayou.liteshop.component.RBACService;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.dao.AdminUserMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.exception.UnAuthenticationException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.security.AdminUserDetails;
import com.ohayou.liteshop.security.JWTTokenUtil;
import com.ohayou.liteshop.service.AdminMenuService;
import com.ohayou.liteshop.service.AdminRoleService;
import com.ohayou.liteshop.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.vo.AdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 管理员用户表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Autowired
    UserDetailsService adminUserDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RedisService redisService;

    @Autowired
    JWTTokenUtil jwtTokenUtil;

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminMenuService adminMenuService;



    @Value("${keyPrefix.expireTime.invalidToken}")
    private long expireTime;

    @Override
    public AdminUserVo login(AdminUserVo adminUserVo, HttpServletRequest request , HttpServletResponse response) {
        if (adminUserVo.getUsername() == null || adminUserVo.getPassword() == null) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        AdminUserDetails user = (AdminUserDetails)adminUserDetailsService.loadUserByUsername(adminUserVo.getUsername());
        if (!user.isEnabled()) {
            throw new UnAuthenticationException(ErrorCodeMsg.USER_NOT_ENABLED_ERROR);
        }
        if (!passwordEncoder.matches(adminUserVo.getPassword(),user.getPassword())) {
            throw new UnAuthenticationException(ErrorCodeMsg.UNAUTHENTICATED_ERROR);
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        String token = jwtTokenUtil.generateToken(user);
        AdminUser adminUser1 = new AdminUser();
        adminUser1.setId(user.getId());
        List<AdminRole> adminRoles = adminRoleService.roleListByUser(adminUser1);

        List<String> collect = adminRoles.stream()
                .map(AdminRole::getRoleName)
                .collect(Collectors.toList());
        adminUserVo.setRole(collect);
        adminUserVo.setPassword(null);
        adminUserVo.setAvatar(user.getAvatar());
        adminUserVo.setLastLoginTime(user.getLastLoginTime());
        adminUserVo.setMenu(adminMenuService.ListAdminMenuTree(adminUser1));
        response.setHeader("Access-Token",token);
        //更新用户上次登录时间和ip
        AdminUser adminUser = new AdminUser();
        adminUser.setLastLoginTime(LocalDateTime.now());
        adminUser.setLastLoginIp(request.getRemoteHost());
        this.update(adminUser,new UpdateWrapper<AdminUser>().lambda().eq(AdminUser::getUsername,user.getUsername()));
        return adminUserVo;
    }

    @Override
    public void logout(Authentication authentication, HttpServletRequest request) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.getTokenFromHeader(request);
        if (token == null) {
            throw new UnAuthenticationException(ErrorCodeMsg.INVALID_TOKEN);
        }
        //将失效token信息存入到redis,以后再访问时则需要查看redis中是否有此token,如有则说明该token已失效
        InvalidTokenKey invalidTokenKey = new InvalidTokenKey(token,expireTime);
        redisService.set(invalidTokenKey.getPrefix(),userDetails.getUsername(), expireTime);
        authentication.setAuthenticated(false);
    }


}
