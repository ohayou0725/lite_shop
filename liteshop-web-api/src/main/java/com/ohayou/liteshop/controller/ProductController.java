package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.entity.SysFreightConfig;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.MemberUserDetails;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MallTopicService;
import com.ohayou.liteshop.service.MemCollectService;
import com.ohayou.liteshop.service.SysFreightConfigService;
import com.ohayou.liteshop.vo.GoodsDetailVo;
import com.ohayou.liteshop.vo.HotGoodsVo;
import com.ohayou.liteshop.vo.TopicGoodsListVo;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author liyan
 * @date 2020/12/7 下午9:05
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    MallTopicService topicService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    SysFreightConfigService sysFreightConfigService;

    @Autowired
    MemCollectService memCollectService;

    @ApiDesc("查询主题下商品")
    @GetMapping("/list")
    public Result getTopicGoodsList(@RequestParam("topicId") Long topicId,
                                    @RequestParam(value = "page",defaultValue = "1") int page,
                                    @RequestParam(value = "size",defaultValue = "5") int size){
        if (null == topicId) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        TopicGoodsListVo topicGoodsListVo = topicService.getTopicGoodsListVo(topicId,page,size);
        return Result.success("data",topicGoodsListVo);
    }

    @ApiDesc("查询分类下商品")
    @GetMapping("/category")
    public Result getGoodsListByCategory(@RequestParam("categoryId") Long categoryId,
                                         @RequestParam(value = "page",defaultValue = "1") int page,
                                         @RequestParam(value = "size",defaultValue = "5") int size) {
        if (null == categoryId) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<HotGoodsVo> hotGoodsVoList = goodsSpuService.getGoodsPageByCategoryId(categoryId,page,size);
        return Result.success("list",hotGoodsVoList);
    }

    @ApiDesc("获取商品详情")
    @GetMapping("/detail/{goodsId}")
    public Result getGoodsDetail(@PathVariable("goodsId") Long goodsId) {
        if (null == goodsId || goodsId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        GoodsDetailVo goodsDetailVo;
        try {
            goodsDetailVo = goodsSpuService.getGoodsDetail(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(ErrorCodeMsg.GOODS_DETAIL_ERROR);
        }
        return Result.success("detail",goodsDetailVo);
    }

    @ApiDesc("获取包邮价格")
    @GetMapping("/freeShippingPrice")
    public Result getFreeShippingPrice() {
        List<SysFreightConfig> list = sysFreightConfigService.list();
        BigDecimal reliefAmount = list.get(0).getReliefAmount();
        return Result.success("freeShippingPrice",reliefAmount);
    }

    @ApiDesc("查询是否收藏商品")
    @GetMapping("/collect/{id}")
    public Result hasCollect(@PathVariable("id") Long goodsId, Authentication authentication) {
        if (null == goodsId || goodsId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        boolean result = memCollectService.hasCollectByUser(goodsId,memberUserDetails.getId());
        return Result.success("result",result);
    }

    @ApiDesc("收藏商品")
    @PostMapping("/collect/{id}")
    public Result doCollect(@PathVariable("id") Long goodsId, Authentication authentication) {
        if (null == goodsId || goodsId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        boolean result = memCollectService.addCollect(goodsId, memberUserDetails.getId());

        return result ? Result.success() : Result.error(ErrorCodeMsg.GOODS_COLLECT_ERROR);
    }

    @ApiDesc("取消收藏")
    @DeleteMapping("/collect/{id}")
    public Result removeCollect(@PathVariable("id") Long goodsId, Authentication authentication) {
        if (null == goodsId || goodsId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        MemberUserDetails memberUserDetails =  (MemberUserDetails)authentication.getPrincipal();
        boolean result = memCollectService.deleteCollect(goodsId,memberUserDetails.getId());
        return result ? Result.success() : Result.error(ErrorCodeMsg.REMOVE_COLLECT_ERROR);
    }


}

