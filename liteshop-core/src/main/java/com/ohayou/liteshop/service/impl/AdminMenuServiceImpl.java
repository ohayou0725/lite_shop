package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.AdminMenu;
import com.ohayou.liteshop.dao.AdminMenuMapper;
import com.ohayou.liteshop.service.AdminMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-12
 */
@Service
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements AdminMenuService {

}
