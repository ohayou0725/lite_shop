package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.MemUserQueryDto;
import com.ohayou.liteshop.entity.MemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.response.Result;

import java.util.Map;

/**
 * <p>
 * 会员表
 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MemUserService extends IService<MemUser> {

    Result queryList(MemUserQueryDto memUserQueryDto ,Map<String, Object> queryParam);
}
