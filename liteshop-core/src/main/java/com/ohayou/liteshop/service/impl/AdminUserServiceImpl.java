package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.AdminLoginTimeAndIpKey;
import com.ohayou.liteshop.cache.cachekey.AdminUserDetailsKey;
import com.ohayou.liteshop.cache.cachekey.InvalidTokenKey;
import com.ohayou.liteshop.constant.AdminUserStatus;
import com.ohayou.liteshop.dto.AdminUserDto;
import com.ohayou.liteshop.entity.AdminRole;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.dao.AdminUserMapper;
import com.ohayou.liteshop.entity.AdminUserRoleRelation;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.exception.UnAuthenticationException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.security.AdminUserDetails;
import com.ohayou.liteshop.security.JWTTokenUtil;
import com.ohayou.liteshop.security.SecurityUtil;
import com.ohayou.liteshop.service.AdminMenuService;
import com.ohayou.liteshop.service.AdminRoleService;
import com.ohayou.liteshop.service.AdminUserRoleRelationService;
import com.ohayou.liteshop.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.ListUtil;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.AdminUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.*;
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

    @Autowired
    AdminUserRoleRelationService adminUserRoleRelationService;



    @Value("${keyPrefix.expireTime.invalidToken}")
    private long expireTime;

    @Value("${admin.initialPassword}")
    private String initialPassword;

    @Override
    public boolean  login(AdminUserVo adminUserVo, HttpServletRequest request , HttpServletResponse response) {
        if (StringUtils.isBlank(adminUserVo.getUsername()) || StringUtils.isBlank(adminUserVo.getPassword())) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        AdminUserDetails user = (AdminUserDetails)adminUserDetailsService.loadUserByUsername(adminUserVo.getUsername());
        if (!user.isEnabled()) {
            if (!user.isAccountNonLocked()) {
                throw new UnAuthenticationException(ErrorCodeMsg.USER_LOCKED);
            } else {
                throw new UnAuthenticationException(ErrorCodeMsg.USER_NOT_ENABLED_ERROR);
            }
        }

        if (!passwordEncoder.matches(adminUserVo.getPassword(),user.getPassword())) {
            throw new UnAuthenticationException(ErrorCodeMsg.UNAUTHENTICATED_ERROR);
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        String token = jwtTokenUtil.generateToken(user);
        response.setHeader("Access-Token",token);
        AdminUser adminUser = new AdminUser();
        AdminLoginTimeAndIpKey adminLoginTimeAndIpKey = new AdminLoginTimeAndIpKey(user.getUsername());

        LocalDateTime loginTime = (LocalDateTime)redisService.hget(adminLoginTimeAndIpKey.getPrefix(),"loginTime");
        String ip = String.valueOf(redisService.hget(adminLoginTimeAndIpKey.getPrefix(),"ip"));
        adminUser.setLastLoginTime(loginTime);
        adminUser.setLastLoginIp(ip);
        this.update(adminUser,new UpdateWrapper<AdminUser>().lambda().eq(AdminUser::getUsername,user.getUsername()));
        Map<String,Object> loginTimeAndIp = new HashMap<>();
        loginTimeAndIp.put("loginTime",LocalDateTime.now());
        loginTimeAndIp.put("ip",request.getRemoteHost());
        redisService.hmset(adminLoginTimeAndIpKey.getPrefix(),loginTimeAndIp);
        return true;

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

    @Override
    public AdminUserVo getUserInfo(Authentication authentication) {
        AdminUserDetails userDetails = SecurityUtil.getAdminUser(authentication);
        if (userDetails == null) {
            throw new GlobalException(ErrorCodeMsg.USER_INFO_ERROR);
        }
        AdminUser adminUser = this.getById(userDetails.getId());

        AdminUser currentAdminUser = new AdminUser();

        currentAdminUser.setId(adminUser.getId());
        List<AdminRole> adminRoles = adminRoleService.roleListByUser(currentAdminUser);

        List<String> collect = adminRoles.stream()
                .map(AdminRole::getRoleName)
                .collect(Collectors.toList());
        AdminUserVo adminUserVo = new AdminUserVo();
        adminUserVo.setId(adminUser.getId());
        adminUserVo.setUsername(adminUser.getUsername());
        adminUserVo.setName(adminUser.getName());
        adminUserVo.setEmail(adminUser.getEmail());
        adminUserVo.setRole(collect);
        adminUserVo.setPassword(null);
        adminUserVo.setAvatar(adminUser.getAvatar());
        adminUserVo.setLastLoginTime(adminUser.getLastLoginTime());
        adminUserVo.setMenu(adminMenuService.ListAdminMenuTree(currentAdminUser));
        return adminUserVo;
    }

    /**
     * 分页查询管理员
     * @param adminUserDto
     * @param page
     * @return
     */
    @Override
    public PageUtils queryPage(AdminUserDto adminUserDto, IPage<AdminUser> page) {
        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(adminUserDto.getUsername()),AdminUser::getUsername,adminUserDto.getUsername());
        queryWrapper.eq(null != adminUserDto.getStatus(),AdminUser::getStatus,adminUserDto.getStatus());
        if (null != adminUserDto.getCreateTime()) {
            queryWrapper.between(AdminUser::getCreateTime,
                    adminUserDto.getCreateTime().toLocalDate().minusDays(1L),adminUserDto.getCreateTime().toLocalDate().plusDays(1L));
        }

        this.page(page,queryWrapper);
        PageUtils pageUtils = new PageUtils(page);
        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<AdminUserDto> collect = page.getRecords().stream()
                    .map(user -> {
                        AdminUserDto userDto = new AdminUserDto();
                        BeanUtils.copyProperties(user, userDto);
                        userDto.setRole(adminRoleService.roleListByUser(user));
                        return userDto;
                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 新增用户
     * @param adminUserDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(AdminUserDto adminUserDto) {
        int count = this.count(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getUsername, adminUserDto.getUsername()));
        if (count > 0) {
            throw new GlobalException(ErrorCodeMsg.USER_EXIST);
        }

        List<AdminRole> roleList = adminUserDto.getRole();
        if (CollectionUtil.isEmpty(roleList)) {
            throw new GlobalException(ErrorCodeMsg.USER_NO_ROLE);
        }

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserDto,adminUser);
        adminUser.setPassword(passwordEncoder.encode(initialPassword));
        adminUser.setStatus(AdminUserStatus.NORMAL.getStatus());
        boolean save = this.save(adminUser);
        if (save) {
            List<AdminUserRoleRelation> collect = roleList.stream().map(role -> {
                Long id = role.getId();
                AdminUserRoleRelation adminUserRoleRelation = new AdminUserRoleRelation();
                adminUserRoleRelation.setRoleId(id);
                adminUserRoleRelation.setUserId(adminUser.getId());
                return adminUserRoleRelation;
            }).collect(Collectors.toList());
            return adminUserRoleRelationService.saveBatch(collect);
        }
        return false;
    }

    /**
     * 重置后台用户密码
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean resetPassword(Long id) {
        AdminUser user = this.getById(id);
        if (null == user) {
            throw new GlobalException(ErrorCodeMsg.USER_NOT_FOUND);
        }
        //判断是否为当前登录用户重置自己密码，如果不是则可以重置密码
        AdminUserDetails adminUser = SecurityUtil.getAdminUser(SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication());
        if (null == adminUser || user.getId().equals(adminUser.getId())) {
            throw new GlobalException(ErrorCodeMsg.USER_CANT_RESET);
        }

        user.setPassword(passwordEncoder.encode(initialPassword));
        if (user.getStatus().equals(AdminUserStatus.LOCKED.getStatus())) {
            user.setStatus(AdminUserStatus.NORMAL.getStatus());
        }
        boolean result = this.updateById(user);
        if (result) {
            AdminUserDetailsKey adminUserDetailsKey = new AdminUserDetailsKey(user.getUsername());
            if (redisService.hasKey(adminUserDetailsKey.getPrefix())) {
                redisService.del(adminUserDetailsKey.getPrefix());
            }
        }
        return result;
    }

    /**
     * 修改用户
     * @param adminUserDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(AdminUserDto adminUserDto) {
        Long id = adminUserDto.getId();
        AdminUser user = this.getById(id);
        if (null == user) {
            throw new GlobalException(ErrorCodeMsg.USER_NOT_FOUND);
        }

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserDto,adminUser);

        List<AdminRole> roles = adminUserDto.getRole();
        List<Long> rolesId = roles
                .stream().map(AdminRole::getId).collect(Collectors.toList());
        List<AdminRole> currentRoles = adminRoleService.roleListByUser(user);
        List<Long> currentRolesId = currentRoles
                .stream().map(AdminRole::getId).collect(Collectors.toList());
        boolean update = this.updateById(adminUser);

        if (update && !ListUtil.equals(rolesId,currentRolesId)) {
            List<AdminUserRoleRelation> adminUserRoleRelations = new ArrayList<>();

            currentRolesId.forEach(roleId->{
                LambdaQueryWrapper<AdminUserRoleRelation> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(AdminUserRoleRelation::getUserId,user.getId());
                wrapper.eq(AdminUserRoleRelation::getRoleId,roleId);
                AdminUserRoleRelation one = adminUserRoleRelationService.getOne(wrapper);
                if (null != one) {
                    adminUserRoleRelations.add(one);
                }
            });

            List<Long> relations = adminUserRoleRelations.stream()
                    .map(AdminUserRoleRelation::getId).collect(Collectors.toList());
            boolean remove = adminUserRoleRelationService.removeByIds(relations);
            if (!remove) {
                throw new GlobalException(ErrorCodeMsg.USER_UPDATE_ERROR);
            }
            List<AdminUserRoleRelation> collect = rolesId.stream().map(roleId -> {
                AdminUserRoleRelation adminUserRoleRelation = new AdminUserRoleRelation();
                adminUserRoleRelation.setUserId(user.getId());
                adminUserRoleRelation.setRoleId(roleId);
                return adminUserRoleRelation;
            }).collect(Collectors.toList());
            return adminUserRoleRelationService.saveBatch(collect);
        }
        return update;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(Long id) {
        AdminUser user = this.getById(id);
        if (null == user) {
            throw new GlobalException(ErrorCodeMsg.USER_NOT_FOUND);
        }

        boolean remove = this.removeById(id);
        if (remove) {
            List<AdminUserRoleRelation> list = adminUserRoleRelationService.list(new LambdaQueryWrapper<AdminUserRoleRelation>()
                    .eq(AdminUserRoleRelation::getUserId, user.getId()));
            List<Long> collect = list.stream()
                    .map(AdminUserRoleRelation::getId).collect(Collectors.toList());
            return adminUserRoleRelationService.removeByIds(collect);
        }

        return false;
    }

    @Override
    public List<AdminUser> findUserByRoleId(Long roleId) {
        return this.baseMapper.findUserByRoleId(roleId);
    }

    /**
     * 删除redis中拥有指定角色的用户
     * @param roleId
     */
    @Override
    public void removeCacheByRoleId(Long roleId) {
        List<AdminUser> adminUsers = this.findUserByRoleId(roleId);
        if (CollectionUtil.isNotEmpty(adminUsers)) {
            adminUsers.forEach(user->{
                AdminUserDetailsKey adminUserDetailsKey = new AdminUserDetailsKey(user.getUsername());
                redisService.del(adminUserDetailsKey.getPrefix());
            });
        }
    }

    /**
     * 修改用户密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updatePassword(Long id, String oldPassword, String newPassword) {
        AdminUser user = this.getById(id);
        if (!passwordEncoder.matches(oldPassword,user.getPassword())) {
            throw new GlobalException(ErrorCodeMsg.INVALID_OLDPASSWORD);
        }
        user.setPassword(passwordEncoder.encode(newPassword));

        return this.updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserInfo(AdminUserVo adminUserVo) {
        AdminUser user = new AdminUser();
        BeanUtils.copyProperties(adminUserVo,user);
        return this.updateById(user);
    }
}
