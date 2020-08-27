package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.AttrValueDto;
import com.ohayou.liteshop.dto.GoodsDetailDto;
import com.ohayou.liteshop.dto.GoodsFormDto;
import com.ohayou.liteshop.dto.MallGoodsSpuDto;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

import java.util.List;

/**
 * <p>
 * 商品spu信息表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallGoodsSpuService extends IService<MallGoodsSpu> {

    PageUtils getPage(MallGoodsSpuDto mallGoodsSpuDto, IPage<MallGoodsSpu> page);

    GoodsDetailDto getDetail(Long goodsId);

    public List<AttrValueDto> getAllAttrAndValue(Long goodsId);

    boolean addGoodsSpu(GoodsFormDto goodsFormDto);
}
