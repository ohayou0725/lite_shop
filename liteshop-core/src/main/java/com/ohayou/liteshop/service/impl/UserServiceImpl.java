package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.User;
import com.ohayou.liteshop.dao.UserMapper;
import com.ohayou.liteshop.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表
 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
