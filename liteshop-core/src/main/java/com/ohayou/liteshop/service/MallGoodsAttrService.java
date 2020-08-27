package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.MallGoodsAttrDto;
import com.ohayou.liteshop.entity.MallGoodsAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品参数表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallGoodsAttrService extends IService<MallGoodsAttr> {

    List<MallGoodsAttrDto> listAttrByGroupId(Long attrGroupId, Long id);

    List<MallGoodsAttr> listByGroupId(Long attrGroupId);

    void addGoodsAttr(MallGoodsAttrDto mallGoodsAttrDto);

    boolean updateAttr(MallGoodsAttrDto mallGoodsAttrDto);

    boolean deleteAttr(MallGoodsAttrDto mallGoodsAttrDto);

    List<String> attrList();

    List<MallGoodsAttr> findAttrsByGoodsId(Long goodsId);
}
