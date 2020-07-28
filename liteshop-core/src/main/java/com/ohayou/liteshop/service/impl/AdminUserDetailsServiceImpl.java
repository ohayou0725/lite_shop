package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.AdminUserDetailsKey;
import com.ohayou.liteshop.entity.AdminResource;
import com.ohayou.liteshop.entity.AdminUser;
import com.ohayou.liteshop.exception.UnAuthenticationException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.security.AdminUserDetails;
import com.ohayou.liteshop.service.AdminResourceService;
import com.ohayou.liteshop.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyan
 * @date 2020/7/15 下午9:22
 */
@Service("adminUserDetailsService")
public class AdminUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private AdminResourceService adminResourceService;

    @Autowired
    private RedisService redisService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //先从redis里获取用户信息，如果没有则进行数据库查询
        AdminUserDetailsKey adminUserDetailsKey = new AdminUserDetailsKey(s);
        Object result = redisService.get(adminUserDetailsKey.getPrefix());
        if (null != result) {
            return (AdminUserDetails) result;
        }
        //没有缓存则进行数据库查询
        AdminUser user = adminUserService.getOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getUsername, s));
        if (user == null) {
            throw new UnAuthenticationException(ErrorCodeMsg.UNAUTHENTICATED_ERROR);
        }
        AdminUserDetails adminUserDetails = new AdminUserDetails();
        adminUserDetails.setId(user.getId());
        adminUserDetails.setUsername(user.getUsername());
        adminUserDetails.setPassword(user.getPassword());
        adminUserDetails.setIsEnabled(0);
        adminUserDetails.setAvatar(user.getAvatar());
        adminUserDetails.setLastLoginTime(user.getLastLoginTime());
//        List<SimpleGrantedAuthority> collect = adminResourceService.findResourceListByUser(user).stream()
//                .map(resource -> {
//                    return new SimpleGrantedAuthority(resource.getUrl());
//                })
//                .collect(Collectors.toList());
//        adminUserDetails.setAuthorities(collect);
        List<AdminResource> resource = adminResourceService.findResourceListByUser(user);
        String[] resources = resource.stream()
                .map(AdminResource::getUrl)
                .toArray(String[]::new);

        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(resources);
        adminUserDetails.setAuthorities(authorityList);

        //将结果存入到redis
        redisService.set(adminUserDetailsKey.getPrefix(),adminUserDetails);

        return adminUserDetails;
    }
}
