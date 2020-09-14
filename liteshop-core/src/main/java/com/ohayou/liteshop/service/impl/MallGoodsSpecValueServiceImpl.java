package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.ohayou.liteshop.entity.MallGoodsAttr;
import com.ohayou.liteshop.entity.MallGoodsSpecValue;
import com.ohayou.liteshop.dao.MallGoodsSpecValueMapper;
import com.ohayou.liteshop.service.MallGoodsAttrService;
import com.ohayou.liteshop.service.MallGoodsSpecValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品规格值表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallGoodsSpecValueServiceImpl extends ServiceImpl<MallGoodsSpecValueMapper, MallGoodsSpecValue> implements MallGoodsSpecValueService {

    @Override
    public List<MallGoodsSpecValue> listByGoodsId(Long id) {
        if (null == id || id < 1) {
            return null;
        }
        return baseMapper.listByGoodsId(id);
    }
}
