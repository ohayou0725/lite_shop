package com.ohayou.liteshop.security;

import org.springframework.security.core.Authentication;

/**
 * @author liyan
 * @date 2020/7/20 下午8:12
 */
public class SecurityUtil {

    public static AdminUserDetails getAdminUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof AdminUserDetails) {
            return (AdminUserDetails) principal;
        }
        return null;
    }
}
