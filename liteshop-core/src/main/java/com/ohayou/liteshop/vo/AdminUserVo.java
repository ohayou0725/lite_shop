package com.ohayou.liteshop.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/7/15 下午12:45
 */
public class AdminUserVo {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 16, message = "用户名必须为5到16位之间")
    private String username;


    @Length(min = 5, max = 16, message = "密码必须为5到16位之间")
    private String password;


    private String avatar;

    private List<String> role;

    private List<AdminMenuVo> menu;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime lastLoginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public List<AdminMenuVo> getMenu() {
        return menu;
    }

    public void setMenu(List<AdminMenuVo> menu) {
        this.menu = menu;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
