package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.AddCartDto;
import com.ohayou.liteshop.entity.MallCartItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.vo.CartVo;
import com.ohayou.liteshop.vo.CheckResultVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 购物车商品 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallCartItemService extends IService<MallCartItem> {

    int getCountByUser(Long userId);

    boolean addGoods(AddCartDto addCart);

    boolean updateItemPrice(Long skuId, BigDecimal price);

    CartVo getItemList(Long id);

    BigDecimal deleteCartItem(Long skuId,Long userId);

    CheckResultVo checkedOrUnchecked(List<Long> cartItemIds, Long id);

    BigDecimal getAmount(Long userId);

    BigDecimal changeNum(AddCartDto addCartDto);
}
