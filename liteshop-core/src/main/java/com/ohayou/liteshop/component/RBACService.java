package com.ohayou.liteshop.component;

import com.ohayou.liteshop.security.AdminUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyan
 * @date 2020/7/18 下午4:43
 */

/**
 * 动态权限控制
 */
@Component("rbacService")
public class RBACService {

    @Value("${server.servlet.context-path}")
    private String baseUrl;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (AdminUserDetails) principal;
            String requestURI = request.getRequestURI();
            return userDetails.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> {
                        return antPathMatcher.matchStart(baseUrl + grantedAuthority.getAuthority(), requestURI);
                    });
        }
        return false;
    }
}
