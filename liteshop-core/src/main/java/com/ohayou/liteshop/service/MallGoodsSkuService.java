package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.GoodsSkuDto;
import com.ohayou.liteshop.entity.MallGoodsSku;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.vo.OrderConfirmVo;
import com.ohayou.liteshop.vo.SkuVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品sku信息表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallGoodsSkuService extends IService<MallGoodsSku> {
    List<GoodsSkuDto> getGoodsSku(Long goodsId);

    List<GoodsSkuDto> getSkuByGoodsSn(String goodsSn);

    boolean addGoodsSku(GoodsSkuDto goodsSkuDto);

    boolean updateGoodsSku(GoodsSkuDto goodsSkuDto);

    boolean deleteSku(Long skuId);

    boolean deleteAllSku(String goodsSn);

    Map<String,String> getSpecAndValue(String specSn);

    SkuVo getGoodsSkuVo(Long goodsId);

    void synchronizeStock(OrderConfirmVo orderConfirmVo) throws Exception;

    boolean decreaseStock(Long skuId, int stock);
}
