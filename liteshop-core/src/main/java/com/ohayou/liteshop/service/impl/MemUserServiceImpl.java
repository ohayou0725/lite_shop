package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.MemUserQueryDto;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.dao.MemUserMapper;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.PageQuery;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 会员表
 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MemUserServiceImpl extends ServiceImpl<MemUserMapper, MemUser> implements MemUserService {


    @Override
    public Result queryList(MemUserQueryDto memUserQueryDto, Map<String, Object> queryParam) {
        PageQuery<MemUser> pageQuery = new PageQuery<>();
        IPage<MemUser> page = pageQuery.getPage(queryParam);
        //
        return null;
    }
}
