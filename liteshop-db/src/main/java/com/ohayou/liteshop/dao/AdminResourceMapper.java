package com.ohayou.liteshop.dao;

import com.ohayou.liteshop.entity.AdminResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 后台资源表 Mapper 接口
 * </p>
 *
 * @author ohayou
 * @since 2020-07-18
 */
public interface AdminResourceMapper extends BaseMapper<AdminResource> {
    List<AdminResource> findResourceByRole(Long id);
}
