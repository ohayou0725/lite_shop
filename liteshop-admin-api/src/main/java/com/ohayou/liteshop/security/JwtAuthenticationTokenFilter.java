package com.ohayou.liteshop.security;

import com.ohayou.liteshop.cache.RedisService;
import com.ohayou.liteshop.cache.cachekey.InvalidTokenKey;
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
 * @date 2020/7/15 上午11:12
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService adminUserDetailsService;

    @Autowired
    private RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获取header token字段
        String token = jwtTokenUtil.getTokenFromHeader(httpServletRequest);
        if (token != null) {
            //在redis里查询该token是否已经注销
            if (!redisService.hasKey(new InvalidTokenKey(token).getPrefix()) ){
                String username = jwtTokenUtil.getUserNameFromToken(token);
                //如果解析到用户存在，并且没有认证
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = adminUserDetailsService.loadUserByUsername(username);
                    if ((jwtTokenUtil.validateToken(token, userDetails))) {
                        //判断是否需要刷新token
                        if (jwtTokenUtil.canRefresh(token)) {
                            String refreshToken = jwtTokenUtil.refreshToken(token);
                            httpServletResponse.setHeader("Refresh-Token", refreshToken);
                        }
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        //设置认证用户的请求信息
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
            }
        }
        //没有token字段则为登录行为直接放行
        doFilter(httpServletRequest,httpServletResponse,filterChain);
    }
}
