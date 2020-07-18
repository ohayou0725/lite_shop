package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminUser user = adminUserService.getOne(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getUsername, s));
        if (user == null) {
            throw new UnAuthenticationException(ErrorCodeMsg.UNAUTHENTICATED_ERROR);
        }
        AdminUserDetails adminUserDetails = new AdminUserDetails();
        adminUserDetails.setId(user.getId());
        adminUserDetails.setUsername(user.getUsername());
        adminUserDetails.setPassword(user.getPassword());
        adminUserDetails.setIsEnabled(0);
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
        return adminUserDetails;
    }
}
