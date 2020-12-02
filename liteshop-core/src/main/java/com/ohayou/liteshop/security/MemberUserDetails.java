package com.ohayou.liteshop.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

/**
 * @author liyan
 * @date 2020/11/23 下午10:04
 */
public class MemberUserDetails implements UserDetails {
    private Long id;

    private String mobile;

    private String password;

    private String nickName;

    private String gender;

    private LocalDate birthday;

    private String avatar;

    private String rank;

    private Integer status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.mobile;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.status == 1;
    }
}
