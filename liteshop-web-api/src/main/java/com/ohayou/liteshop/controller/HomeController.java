package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.cache.RedisService;

import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.service.MallGoodsSkuService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MallTopicService;
import com.ohayou.liteshop.vo.BannerVo;
import com.ohayou.liteshop.vo.CategoryVo;
import com.ohayou.liteshop.vo.FeaturedTopicVo;
import com.ohayou.liteshop.vo.HotGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liyan
 * @date 2020/11/26 下午1:32
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    MallTopicService mallTopicService;

    @Autowired
    MallCategoryService categoryService;

    @Autowired
    MallTopicService topicService;

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    RedisService redisService;

    @Autowired
    MallGoodsSkuService skuService;


    @ApiDesc("获取首页轮播图")
    @GetMapping("/banner")
    public Result getBanner() {
        List<BannerVo> bannerVo = mallTopicService.getBanner();
        return Result.success("banner",bannerVo);
    }

    @ApiDesc("获取首页分类")
    @GetMapping("/category")
    public Result getCategoryList() {
        List<CategoryVo> categoryVos = categoryService.getRootCategoryList();
        return Result.success("category",categoryVos);
    }

    @ApiDesc("获取精选专场专题")
    @GetMapping("/topic")
    public Result getTopic() {
        List<FeaturedTopicVo> featuredTopicVo = topicService.getFeaturedTopic();
        return Result.success("featuredTopic", featuredTopicVo);
    }

    @ApiDesc("获取热门推荐")
    @GetMapping("/list")
    public Result getGoodsList(@RequestParam("pageNo") int page, @RequestParam("pageSize") int size) {
        List<HotGoodsVo> list = goodsSpuService.getHotGoodsList(page, size);
        return Result.success("list",list);
    }

//    /**
//     * 初始化controller时将热门推荐商品存入到redis
//     * 并且将商品库存加载到redis
//     * @throws Exception
//     */
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        List<HotGoodsVo> hotGoodsVoList = goodsSpuService.getAllHotGoodsList();
//        HotGoodsVoListKey hotGoodsVoListKey = new HotGoodsVoListKey();
//        redisService.del(hotGoodsVoListKey.getPrefix());
//        redisService.lSet(hotGoodsVoListKey.getPrefix(),hotGoodsVoList.toArray());
//
//        List<MallGoodsSku> list = skuService.list();
//        Map<String,Object> stockMap = new HashMap<>();
//        list.forEach(mallGoodsSku -> {
//            stockMap.put(String.valueOf(mallGoodsSku.getId()),mallGoodsSku.getStock());
//        });
//        redisService.hmset(new GoodsStockKey().getPrefix(),stockMap);
//    }
}
