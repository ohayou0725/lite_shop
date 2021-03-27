package com.ohayou.liteshop.security;

import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.exception.UnAuthenticationException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import org.springframework.security.core.Authentication;

/**
 * @author liyan
 * @date 2020/7/20 下午8:12
 */
public class SecurityUtil {

    public static AdminUserDetails getAdminUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        try {
            return (AdminUserDetails) principal;
        }catch (Exception e) {
            throw new UnAuthenticationException(ErrorCodeMsg.TOKEN_EXPIRED);
        }
    }

    public static MemberUserDetails getMemberUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();

        try {
            return (MemberUserDetails) principal;
        }catch (Exception e) {
            throw new UnAuthenticationException(ErrorCodeMsg.TOKEN_EXPIRED);
        }
    }
}
