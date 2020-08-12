package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.GoodsAttrDto;
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

    List<GoodsAttrDto> listAttrByGroupId(Long attrGroupId,Long id);

    void addGoodsAttr(GoodsAttrDto goodsAttrDto);

    boolean updateAttr(GoodsAttrDto goodsAttrDto);

    boolean deleteAttr(GoodsAttrDto goodsAttrDto);

    List<String> attrList();
}
