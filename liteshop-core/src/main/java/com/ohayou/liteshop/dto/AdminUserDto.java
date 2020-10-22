package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.entity.AdminRole;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/10/18 下午9:22
 */
public class AdminUserDto {
    public interface AddUser{};

    public interface UpdateUser{};

    @NotNull(groups = UpdateUser.class,message = "用户id不能为空")
    @Min(value = 0,message = "id不合法",groups = UpdateUser.class)
    @Max(value = Long.MAX_VALUE,message = "id不合法",groups = UpdateUser.class)
    private Long id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull(groups = UpdateUser.class,message = "用户状态不能为空")
    private Integer status;

    private String avatar;

    private LocalDateTime createTime;

    @NotNull(message = "至少分配一个角色")
    private List<AdminRole> role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public List<AdminRole> getRole() {
        return role;
    }

    public void setRole(List<AdminRole> role) {
        this.role = role;
    }
}
