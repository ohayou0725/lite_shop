package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.service.MallTopicService;
import com.ohayou.liteshop.vo.CategoryContentVo;
import com.ohayou.liteshop.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyan
 * @date 2020/12/3 下午3:15
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    MallCategoryService categoryService;

    @Autowired
    MallTopicService topicService;

    @ApiDesc("查询商品一级分类")
    @GetMapping("/items")
    public Result getRootCategory() {
        List<CategoryVo> rootCategoryList = categoryService.getRootCategoryList();
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setName("热门推荐");
        categoryVo.setCategoryId(0L);
        rootCategoryList.add(0,categoryVo);
        return Result.success("items",rootCategoryList);
    }

    @ApiDesc("获取二级分类详情")
    @GetMapping("/content")
    public Result getContent(@RequestParam("categoryId") Long id) {
        if (null == id || id < 0) {
            return Result.error(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        CategoryContentVo categoryContent = categoryService.getCategoryContent(id);
        return Result.success("content",categoryContent);
    }

    @ApiDesc("获取分类下所有三级分类")
        @GetMapping("/children/{categoryId}")
    public Result getChildren(@PathVariable("categoryId") Long categoryId) {
        if (null == categoryId || categoryId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<CategoryVo> categoryVoList = categoryService.getChildren(categoryId);
        return Result.success("categories",categoryVoList);
    }

}
