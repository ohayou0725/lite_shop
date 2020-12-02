package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.MemberUserDetailsKey;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.security.MemberUserDetails;
import com.ohayou.liteshop.service.MemUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author liyan
 * @date 2020/11/24 下午9:13
 */
@Service("memberUserDetailService")
public class MemberUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    MemUserService memUserService;

    @Autowired
    RedisService redisService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MemberUserDetailsKey memberUserDetailsKey = new MemberUserDetailsKey(s);
        Object user = redisService.get(memberUserDetailsKey.getPrefix());
        if (null != user) {
            return (MemberUserDetails)user;
        }
        MemUser currentUser = memUserService.getUserByMobile(s);
        if (null != currentUser) {
            MemberUserDetails memberUserDetails = new MemberUserDetails();
            BeanUtils.copyProperties(currentUser,memberUserDetails);
            redisService.set(memberUserDetailsKey.getPrefix(),memberUserDetails);
            return memberUserDetails;
        }
        return null;
    }
}
