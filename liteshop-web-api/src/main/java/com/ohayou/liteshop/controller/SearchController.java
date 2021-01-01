package com.ohayou.liteshop.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.es.service.EsGoodsService;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.SearchService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import com.ohayou.liteshop.vo.HotGoodsVo;
import com.ohayou.liteshop.vo.HotSearchKeyWordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/12/5 下午9:18
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @Autowired
    EsGoodsService esGoodsService;

    @ApiDesc("查询热门搜索")
    @RequestMapping("/hotList")
    public Result getHotList() {
        List<HotSearchKeyWordsVo> searchKeyWordsVo = searchService.getHotSearchKeyWords();
        if (CollectionUtil.isNotEmpty(searchKeyWordsVo)) {
            return Result.success("hotList",searchKeyWordsVo);
        }
        return Result.success("hotList",null);
    }

    @ApiDesc("关键字搜索商品")
    @RequestMapping("/result")
    public Result searchGoodsList(@RequestParam int size, @RequestParam int page
            ,@RequestParam("key") String key) {
//        PageQuery<MallGoodsSpu> pageQuery = new PageQuery<>();
//        IPage<MallGoodsSpu> page = pageQuery.getPage(pageParam);
//        PageUtils pageUtils = searchService.searchGoodsListByKeyWords(page,key);
        List<HotGoodsVo> hotGoodsVos = searchService.searchGoodsByKeyWords(key, page, size);
        if (CollectionUtil.isNotEmpty(hotGoodsVos)){
            //将搜索关键词存入到redis，统计热搜词频
            searchService.saveHotSearchKeyCount(key);
        }
        return Result.success("list",hotGoodsVos);
    }

    @ApiDesc("获取三级分类下所有商品")
    @GetMapping("/resultByCategory")
    public Result searchGoodsListByCategory(@RequestParam Map<String,Object> pageParam,
                                   @RequestParam("categoryId") Long categoryId) {
        PageQuery<MallGoodsSpu> pageQuery = new PageQuery<>();
        IPage<MallGoodsSpu> page = pageQuery.getPage(pageParam);
        PageUtils pageUtils = searchService.searchGoodsListByCategory(page,categoryId);
        return Result.success("list",pageUtils);
    }

}
