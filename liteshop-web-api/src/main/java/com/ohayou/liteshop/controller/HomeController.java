package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.MallGoodsSpuDto;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.MallTopicService;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.BannerVo;
import com.ohayou.liteshop.vo.CategoryVo;
import com.ohayou.liteshop.vo.FeaturedTopicDto;
import com.ohayou.liteshop.vo.HotGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
        List<FeaturedTopicDto> featuredTopicDto = topicService.getFeaturedTopic();
        return Result.success("featuredTopic",featuredTopicDto);
    }

    @ApiDesc("获取热门推荐")
    @GetMapping("/list")
    public Result getGoodsList(@RequestParam("pageNo") int page, @RequestParam("pageSize") int size) {
        PageUtils pageUtils = goodsSpuService.getHotGoodsList(page,size);
        return Result.success("list",pageUtils);
    }
}
