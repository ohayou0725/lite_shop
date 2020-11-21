package com.ohayou.liteshop.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/7/15 下午12:45
 */
public class AdminUserVo {


    public interface LoginFormGroup{}

    public interface UpdateFormGroup{}

    @NotNull(groups = UpdateFormGroup.class,message = "id不能为空")
    private Long id;

    @NotBlank(message = "用户名不能为空",groups = {LoginFormGroup.class})
    @Length(min = 5, max = 16, message = "用户名必须为5到16位之间",groups = {LoginFormGroup.class})
    private String username;


    @Length(min = 5, max = 16, message = "密码必须为5到16位之间",groups = {LoginFormGroup.class})
    private String password;


    private String avatar;

    private String name;

    private String email;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
