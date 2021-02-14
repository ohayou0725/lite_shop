package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.constant.GoodsStatus;
import com.ohayou.liteshop.dto.AddCartDto;
import com.ohayou.liteshop.entity.MallCart;
import com.ohayou.liteshop.entity.MallCartItem;
import com.ohayou.liteshop.dao.MallCartItemMapper;
import com.ohayou.liteshop.entity.MallGoodsSku;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.vo.CartItemVo;
import com.ohayou.liteshop.vo.CartVo;
import com.ohayou.liteshop.vo.CheckResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 购物车商品 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallCartItemServiceImpl extends ServiceImpl<MallCartItemMapper, MallCartItem> implements MallCartItemService{


    @Autowired
    MallCartService cartService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    MallGoodsSkuService goodsSkuService;


    /**
     * 根据用户ID查询用户购物车商品数量
     * @param userId
     * @return 返回商品数量
     */
    @Override
    public int getCountByUser(Long userId) {
        MallCart cart = cartService.getOne(new LambdaQueryWrapper<MallCart>().eq(MallCart::getUserId, userId));
        if (null == cart) {
            return 0;
        }
        return this.count(new LambdaQueryWrapper<MallCartItem>().eq(MallCartItem::getCartId,cart.getId()));
    }

    /**
     * 添加购物车商品
     * @param addCart 购物车商品
     * @return  添加结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addGoods(AddCartDto addCart) {
        Long userId = addCart.getUserId();
        Long goodsId = addCart.getGoodsId();
        Long skuId = addCart.getSkuId();
        MallGoodsSpu goodsSpu = goodsSpuService.getById(goodsId);
        if (null == goodsSpu) {
            throw new GlobalException(ErrorCodeMsg.GOODS_NOT_FOUND);
        }
        MallGoodsSku sku = goodsSkuService.getById(skuId);
        if (null == sku) {
            throw new GlobalException(ErrorCodeMsg.GOODS_SPEC_NOT_EXIST);
        }
        //检查添加数量是否已超过单品剩余库存
        if (sku.getStock() - addCart.getNum() < 0) {
            throw new GlobalException(ErrorCodeMsg.GOODS_INVENTORY_SHORTAGE);
        }
        //查询用户购物车是否已经存在，如不存在则直接添加用户购物车记录
        MallCart cart = this.cartService.getOne(new LambdaQueryWrapper<MallCart>().eq(MallCart::getUserId, userId));

        Long currentCartId = 0L;
        if (null != cart) {
            //判断用户购物车是否已添加该商品
            currentCartId = cart.getId();
            LambdaQueryWrapper<MallCartItem> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(MallCartItem::getCartId,cart.getId());
            queryWrapper.eq(MallCartItem::getGoodsId,goodsId);
            MallCartItem one = this.getOne(queryWrapper);
            if (one != null) {
                throw new GlobalException(ErrorCodeMsg.GOODS_HAS_IN_CART);
            }

        } else {
            //如果用户第一次添加购物车商品，则先创建购物车,后添加商品记录
            MallCart cart1 = new MallCart();
            cart1.setUserId(userId);
            this.cartService.save(cart1);
            currentCartId = cart1.getId();
        }
        //第一次添加该商品，则直接添加购物车
        MallCartItem mallCartItem = new MallCartItem();
        mallCartItem.setCartId(currentCartId);
        mallCartItem.setNumber(addCart.getNum());
        mallCartItem.setGoodsId(addCart.getGoodsId());
        mallCartItem.setGoodsImg(sku.getImg());
        mallCartItem.setGoodsName(goodsSpu.getTitle());
        mallCartItem.setPrice(sku.getPrice());
        mallCartItem.setSpecSn(sku.getSpecSn());
        mallCartItem.setSkuId(sku.getId());
        if (this.save(mallCartItem)) {
            MallCart cart1 = cartService.getById(currentCartId);
            cart1.setTotalPrice(this.getAmount(userId));
            return cartService.updateById(cart1);
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateItemPrice(Long skuId, BigDecimal price) {
        List<MallCartItem> list = this.list(new LambdaQueryWrapper<MallCartItem>().eq(MallCartItem::getSkuId, skuId));
        if (CollectionUtil.isNotEmpty(list)) {
            List<MallCartItem> collect = list.stream().peek(mallCartItem -> {
                MallCartItem mallCartItem1 = new MallCartItem();
                BeanUtils.copyProperties(mallCartItem, mallCartItem1);
                mallCartItem1.setPrice(price);
            }).collect(Collectors.toList());
            return this.updateBatchById(collect);
        }
        return true;
    }

    /**
     * 获取用户当前购物车商品列表
     * @param userId  用户Id
     * @return 商品列表
     */
    @Override
    public CartVo getItemList(Long userId) {
        List<MallCartItem> list = this.baseMapper.listByUser(userId);
        if (CollectionUtil.isEmpty(list)) {
            CartVo cartVo = new CartVo();
            cartVo.setAmount(BigDecimal.ZERO);
            cartVo.setList(ListUtil.empty());
            return cartVo;
        }
        CartVo cartVo = new CartVo();
        List<CartItemVo> collect = list.stream()
                .filter(mallCartItem -> {
                    MallGoodsSpu spu = goodsSpuService.getById(mallCartItem.getGoodsId());
                    return spu.getStatus().equals(GoodsStatus.IN_STOCK.getStatus());
                })
                .sorted((t1, t2) -> {
                    if (t1.getCreateTime().isEqual(t2.getCreateTime())) {
                        return 0;
                    }
                    if (t2.getCreateTime().isAfter(t1.getCreateTime())) {
                        return 1;
                    }
                    return -1;
                })
                .map(mallCartItem -> {
                    CartItemVo cartItemVo = new CartItemVo();
                    cartItemVo.setId(mallCartItem.getId());
                    cartItemVo.setGoodsId(mallCartItem.getGoodsId());
                    cartItemVo.setChecked(mallCartItem.getChecked() == 1);
                    cartItemVo.setSkuId(mallCartItem.getSkuId());
                    cartItemVo.setTitle(mallCartItem.getGoodsName());
                    cartItemVo.setImg(mallCartItem.getGoodsImg());
                    cartItemVo.setNum(mallCartItem.getNumber());
                    cartItemVo.setSpecs(this.goodsSkuService.getSpecAndValue(mallCartItem.getSpecSn()));
                    //查询当前购物车商品是否有货
                    MallGoodsSku sku = goodsSkuService.getById(mallCartItem.getSkuId());
                    cartItemVo.setSoldOut(sku.getStock() < 1);
                    cartItemVo.setPrice(mallCartItem.getPrice());
                    cartItemVo.setDiscountPrice(mallCartItem.getPrice());
                    return cartItemVo;
                }).collect(Collectors.toList());
        cartVo.setList(collect);
        cartVo.setAmount(cartService.getById(list.get(0).getCartId()).getTotalPrice());
        return cartVo;
    }

    /**
     * 删除购物车商品
     * @param Id id
     * @return 删除结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BigDecimal deleteCartItem(Long id, Long userId) {
        List<MallCartItem> cartItemList = this.baseMapper.listByUser(userId);
        Optional<MallCartItem> first = cartItemList.stream()
                .filter(mallCartItem -> {
                    return mallCartItem.getId().equals(id);
                }).findFirst();
        if (!first.isPresent()) {
            throw new GlobalException(ErrorCodeMsg.CART_NO_GOODS);
        }
        List<MallCartItem> newCartItemList = cartItemList.stream().filter(mallCartItem -> {
            return !mallCartItem.getId().equals(id);
        }).collect(Collectors.toList());

        boolean remove = this.removeById(first.get());
        //如果删除商品为被选中状态则更新选中商品总价格
        if (remove && first.get().getChecked().equals(1)) {
            MallCart cart = cartService.getOne(new LambdaQueryWrapper<MallCart>().eq(MallCart::getUserId, userId));
            cart.setTotalPrice(getAmount(newCartItemList));
            return cartService.updateById(cart) ? cart.getTotalPrice() : null;
        }
        return remove ? this.getAmount(newCartItemList) : null;
    }

    /**
     * 选中中或取消选中商品
     * @param cartItemIds 购物车商品选项ID
     * @param userId  用户Id
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public CheckResultVo checkedOrUnchecked(List<Long> cartItemIds, Long userId) {
        List<MallCartItem> cartItems = this.baseMapper.listByUser(userId);
        if (CollectionUtil.isEmpty(cartItems)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MallCart cart = cartService.getOne(new LambdaQueryWrapper<MallCart>().eq(MallCart::getUserId, userId));
        CheckResultVo checkResultVo = new CheckResultVo();
        checkResultVo.setSuccess(false);

        //如果参数为空列表，则全部商品项取消选中状态
        if (CollectionUtil.isEmpty(cartItemIds)) {
            List<MallCartItem> cartItemList = this.baseMapper.listByUser(userId);
            List<MallCartItem> collect = cartItemList.stream()
                    .filter(mallCartItem -> {
                        return mallCartItem.getChecked().equals(1);
                    })
                    .peek(mallCartItem -> {
                        mallCartItem.setChecked(0);
                    }).collect(Collectors.toList());
            if (this.updateBatchById(collect)) {
                cart.setTotalPrice(BigDecimal.ZERO);
                if (cartService.updateById(cart)) {
                    checkResultVo.setAmount(cart.getTotalPrice());
                    checkResultVo.setSuccess(true);
                } else {
                    throw new GlobalException(ErrorCodeMsg.CHECKED_FAIL);
                }
            }
            return checkResultVo;
        }
        //判断该购物车选项否为当前用户下，防止横向越权
        boolean match = cartItems.stream()
                .allMatch(mallCartItem -> {
                    return mallCartItem.getCartId().equals(cart.getId());
                });
        if (!match) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<MallCartItem> collect = cartItems.stream()
                .peek(mallCartItem -> {
                    if (cartItemIds.contains(mallCartItem.getId())) {
                        mallCartItem.setChecked(1);
                    } else {
                        mallCartItem.setChecked(0);
                    }
                }).collect(Collectors.toList());
        if (this.updateBatchById(collect) ) {
            cart.setTotalPrice(this.getAmount(userId));
            if (cartService.updateById(cart)) {
                checkResultVo.setAmount(cart.getTotalPrice());
                checkResultVo.setSuccess(true);
            } else {
                throw new GlobalException(ErrorCodeMsg.CHECKED_FAIL);
            }
        }
        return checkResultVo;
    }

    /**
     * 计算购物车已勾选商品总价
     * @param userId 用户Id
     * @return
     */
    public BigDecimal getAmount(Long userId) {
        List<MallCartItem> cartItemList = this.baseMapper.listByUser(userId);
        return cartItemList.stream()
                .filter(item->{return item.getChecked().equals(1);})
                .map(cartItem->{
                    return cartItem.getPrice().multiply(new BigDecimal(cartItem.getNumber()));
                })
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    /**
     * 计算购物车已勾选商品总价
     * @param
     * @return
     */
    public BigDecimal getAmount(List<MallCartItem> cartItemList) {
        return cartItemList.stream()
                .filter(item->{return item.getChecked().equals(1);})
                .map(cartItem->{
                    return cartItem.getPrice().multiply(new BigDecimal(cartItem.getNumber()));
                })
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    /**
     * 更新购物车选项商品数量
     * @param addCartDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BigDecimal changeNum(AddCartDto addCartDto) {
        List<MallCartItem> cartItemList = this.baseMapper.listByUser(addCartDto.getUserId());
        Optional<MallCartItem> first = cartItemList.stream()
                .filter(mallCartItem -> {
                    return mallCartItem.getId().equals(addCartDto.getCartItemId());
                }).findFirst();
        if (!first.isPresent()) {
            throw new GlobalException(ErrorCodeMsg.CART_NO_GOODS);
        }

        MallCartItem cartItem = first.get();
        //获取当前sku库存，校验商品数量书否超过sku库存
        MallGoodsSku sku = goodsSkuService.getById(cartItem.getSkuId());
        if (sku.getStock() < addCartDto.getNum()) {
            throw new GlobalException(ErrorCodeMsg.GOODS_INVENTORY_SHORTAGE);
        }

        cartItem.setNumber(addCartDto.getNum());
        boolean update = this.updateById(cartItem);
        if (update) {
            MallCart cart = cartService.getById(cartItem.getCartId());
            cart.setTotalPrice(this.getAmount(cartItemList));
            return cartService.updateById(cart) ? cart.getTotalPrice() : null;
        }
        return null;
    }
}
