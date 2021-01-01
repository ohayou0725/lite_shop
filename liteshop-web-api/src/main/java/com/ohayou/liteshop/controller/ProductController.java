package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MallTopicService;
import com.ohayou.liteshop.vo.HotGoodsVo;
import com.ohayou.liteshop.vo.TopicGoodsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

