package com.ohayou.liteshop.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/10/24 下午9:59
 */
public class AdminRoleDto {
    public interface UpdateAdminRole{};

    public interface AddAdminRole{};

    @NotNull(groups = UpdateAdminRole.class,message = "id不能为空")
    @Min(value = 0,message = "id不合法",groups = UpdateAdminRole.class)
    @Max(value = Long.MAX_VALUE,message = "id不合法",groups = UpdateAdminRole.class)
    private Long id;
    @NotBlank(message = "角色名不能为空",groups = AddAdminRole.class)
    private String roleName;

    @NotBlank(message = "角色描述不能为空",groups = AddAdminRole.class)
    private String description;

    private Integer enabled;

    private Integer count;

    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
