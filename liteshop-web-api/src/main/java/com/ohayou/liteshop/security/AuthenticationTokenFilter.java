package com.ohayou.liteshop.security;

import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.MemberUserTokenKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liyan
 * @date 2020/11/24 下午9:34
 */
@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    RedisService redisService;

    @Autowired
    UserDetailsService memberUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("Token");
        if (null != token) {
            MemberUserTokenKey memberUserTokenKey = new MemberUserTokenKey(token);
            if (redisService.hasKey(memberUserTokenKey.getPrefix())) {
                String mobile = String.valueOf(redisService.get(memberUserTokenKey.getPrefix()));
                UserDetails userDetails = memberUserDetailService.loadUserByUsername(mobile);
                if (null != userDetails && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,null);
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        //没有token字段则进行放行
        this.doFilter(httpServletRequest,httpServletResponse,filterChain);
    }
}
