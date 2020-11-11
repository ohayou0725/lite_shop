package com.ohayou.liteshop.service.impl;

import com.ohayou.liteshop.entity.SysOrderConfig;
import com.ohayou.liteshop.dao.SysOrderConfigMapper;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.SysOrderConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单设置表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class SysOrderConfigServiceImpl extends ServiceImpl<SysOrderConfigMapper, SysOrderConfig> implements SysOrderConfigService {

    @Override
    public boolean updateOrderConfig(SysOrderConfig sysOrderConfig) {
        Long id = sysOrderConfig.getId();
        SysOrderConfig one = this.getById(id);
        if (null == one) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }

        return this.updateById(sysOrderConfig);
    }
}
