package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.SysFreightConfig;
import com.ohayou.liteshop.dao.SysFreightConfigMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.SysFreightConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 运费设置表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class SysFreightConfigServiceImpl extends ServiceImpl<SysFreightConfigMapper, SysFreightConfig> implements SysFreightConfigService {

    @Override
    public boolean updateFreightConfig(SysFreightConfig sysFreightConfig) {
        Long id = sysFreightConfig.getId();
        SysFreightConfig one = this.getById(id);
        if (null == one) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        return this.updateById(sysFreightConfig);
    }
}
