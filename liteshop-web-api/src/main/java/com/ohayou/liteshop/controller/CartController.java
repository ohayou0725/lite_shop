package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.AddCartDto;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.MemberUserDetails;
import com.ohayou.liteshop.service.MallCartItemService;
import com.ohayou.liteshop.service.MallCartService;
import com.ohayou.liteshop.vo.CartVo;
import com.ohayou.liteshop.vo.CheckResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyan
 * @date 2021/1/31 下午10:30
 */
@RestController
@RequestMapping("/shoppingCart")
public class CartController {

    @Autowired
    MallCartItemService cartItemService;

    @Autowired
    MallCartService cartService;

    @ApiDesc("获取购物车商品数量")
    @GetMapping("/num")
    public Result getCartGoodsItemNum(Authentication authentication) {
        MemberUserDetails user = (MemberUserDetails) authentication.getPrincipal();
        int num = cartItemService.getCountByUser(user.getId());
        return Result.success("num",num);
    }

    @ApiDesc("购物车添加商品")
    @PostMapping("/add")
    public Result cartAdd(@RequestBody @Valid AddCartDto addCart , Authentication authentication) {
        if (null == addCart.getNum() || addCart.getNum() < 1) {
            addCart.setNum(1);
        }
        MemberUserDetails user = (MemberUserDetails) authentication.getPrincipal();
        addCart.setUserId(user.getId());
        boolean result = this.cartItemService.addGoods(addCart);
        return result ? Result.success() : Result.error(ErrorCodeMsg.CART_ADD_ERROR);
    }

    @ApiDesc("查询购物车商品")
    @GetMapping("/list")
    public Result getCartList(Authentication authentication) {
        MemberUserDetails user = (MemberUserDetails) authentication.getPrincipal();
        CartVo cart = cartItemService.getItemList(user.getId());
        return Result.success("cart",cart);
    }

    @ApiDesc("移除购物车商品")
    @DeleteMapping("/{id}")
    public Result deleteCartItem(@PathVariable("id") Long id, Authentication authentication) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails user = (MemberUserDetails) authentication.getPrincipal();
        BigDecimal totalPrice = cartItemService.deleteCartItem(id, user.getId());
        return null != totalPrice ? Result.success("amount",totalPrice) : Result.error(ErrorCodeMsg.CART_REMOVE_ITEM_ERROR);
    }

    @ApiDesc("选中购物车商品")
    @PostMapping("/checked")
    public Result checkedOrUnChecked(@RequestBody List<Long> cartItemIds, Authentication authentication) {
        MemberUserDetails user = (MemberUserDetails) authentication.getPrincipal();
        CheckResultVo checkResultVo = cartItemService.checkedOrUnchecked(cartItemIds, user.getId());
        return Result.success("result",checkResultVo);
    }


    @ApiDesc("更改购物车商品数量")
    @PostMapping("/changeNum")
    public Result changeItemNum(@RequestBody AddCartDto addCartDto,Authentication authentication) {
        if (null == addCartDto.getCartItemId() || addCartDto.getCartItemId() < 1 || null == addCartDto.getNum() || addCartDto.getNum() < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails user = (MemberUserDetails) authentication.getPrincipal();
        addCartDto.setUserId(user.getId());
        BigDecimal totalPrice = cartItemService.changeNum(addCartDto);
        return null != totalPrice ? Result.success("amount",totalPrice) : Result.error(ErrorCodeMsg.CART_CHANGE_NUM_ERROR);
    }
}
