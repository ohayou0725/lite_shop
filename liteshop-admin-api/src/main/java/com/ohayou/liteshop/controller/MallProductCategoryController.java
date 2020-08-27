package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.MallGoodsAttrDto;
import com.ohayou.liteshop.dto.ProductCategoryDto;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallCategoryService;
import com.ohayou.liteshop.service.MallGoodsAttrService;
import com.ohayou.liteshop.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.List;

/**
 * @author liyan
 * @date 2020/8/3 下午11:00
 */

/**
 * 商品分类
 */
@RestController
@RequestMapping("/product/category")
public class MallProductCategoryController {

    @Autowired
    MallCategoryService mallCategoryService;

    @Autowired
    MallGoodsAttrService mallGoodsAttrService;

    @Autowired
    UploadService qiniuUploadService;

    /**
     * 获取商品分类树
     * @return
     */
    @ApiDesc("查询分类树")
    @GetMapping("/tree")
    public Result categoryTree() {
        List<ProductCategoryDto> tree = mallCategoryService.getTree();
        return Result.success("tree",tree);
    }

    /**
     * 模糊查找分类
     * @param key
     * @return
     */
    @ApiDesc("查询分类")
    @GetMapping("/search")
    public Result getNode(@RequestParam("key")String key) {
        return Result.success("result",mallCategoryService.findCategory(key));
    }

    /**
     * 删除分类
     * @param categoryDto
     * @return
     */
    @ApiDesc("删除分类")
    @PostMapping("/delete")
    public Result deleteCategory(@RequestBody @Valid ProductCategoryDto categoryDto) {
        Long id = categoryDto.getId();
        boolean result = mallCategoryService.deleteNode(id);
        return result ? Result.success() : Result.error(ErrorCodeMsg.HAS_CHILDREN_NODE);
    }

    /**
     * 获取单个分类详情
     * @param id
     * @return
     */
    @ApiDesc("获取分类详情")
    @GetMapping("/detail/{id}")
    public Result getDetail(@PathVariable("id")Long id) {
        if (null == id || 0 == id) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        ProductCategoryDto categoryDto = mallCategoryService.getDetail(id);
        return Result.success("detail",categoryDto);
    }

    /**
     * 获取每一级分类
     * @param level
     * @return
     */
    @ApiDesc("获取分类级别")
    @GetMapping("/level/{level}")
    public Result getCateByLevel(@PathVariable("level") Integer level) {
        if (null == level ) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<ProductCategoryDto> categoryDtoList = mallCategoryService.getCateByLevel(level);
        return Result.success("list",categoryDtoList);
    }

    /**
     * 上传分类图片
     * @param file
     * @return
     */
    @ApiDesc("上传分类图片")
    @PostMapping("/upload")
    public Result upload(@RequestParam("file")MultipartFile file) {
        String filePath = "product/category/";
        String url = qiniuUploadService.upload(file, filePath);
        return Result.success("url",url);
    }

    /**
     * 更新商品分类
     * @param categoryDto
     * @return
     */
    @ApiDesc("更新分类")
    @PostMapping("/update")
    public Result update(@RequestBody @Valid ProductCategoryDto categoryDto) {
        boolean result = mallCategoryService.updateCategory(categoryDto);
        if (result) {
            return Result.success();
        }
        return Result.error(ErrorCodeMsg.CATEGORY_UPDATE_ERROR);
    }

    /**
     * 添商品分类
     * 添商品分类
     * @param categoryDto
     * @return
     */

    @ApiDesc("添加分类")
    @PostMapping("/add")
    public Result add(@RequestBody @Valid ProductCategoryDto categoryDto) {
        ProductCategoryDto result = mallCategoryService.addCategory(categoryDto);
        return result != null ? Result.success(result):Result.error(ErrorCodeMsg.CATEGORY_SAVE_ERROR);
    }

    /**
     * 添加商品分类属性
     * @param mallGoodsAttrDto
     * @return
     */
    @ApiDesc("添加分类属性")
    @PostMapping("/attr/add")
    public Result addAttr(@RequestBody @Valid MallGoodsAttrDto mallGoodsAttrDto) {
        Long categoryId = mallGoodsAttrDto.getCategoryId();
        if (null == categoryId ||  categoryId <= 0) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        mallGoodsAttrService.addGoodsAttr(mallGoodsAttrDto);
        return Result.success();
    }

    /**
     * 修改属性
     * @param mallGoodsAttrDto
     * @return
     */

    @ApiDesc("修改属性")
    @PostMapping("/attr/update")
    public Result updateAddr(@RequestBody @Valid MallGoodsAttrDto mallGoodsAttrDto) {
        if (mallGoodsAttrDto == null) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = mallGoodsAttrService.updateAttr(mallGoodsAttrDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.GOODS_ATTR_UPDATE_ERROR);
    }

    /**
     * 删除分类属性
     * @param mallGoodsAttrDto
     * @return
     */

    @ApiDesc("删除属性")
    @PostMapping("/attr/delete")
    public Result deleteAddr(@RequestBody @Valid MallGoodsAttrDto mallGoodsAttrDto) {
        if (mallGoodsAttrDto.getCategoryId() == null || mallGoodsAttrDto.getId() == null) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = mallGoodsAttrService.deleteAttr(mallGoodsAttrDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.GOODS_ATTR_DELETE_ERROR);
    }

    /**
     * 查询属性列表
     * @return
     */
    @ApiDesc("查询所有属性列表")
    @GetMapping("/attr/list")
    public Result attrList() {
        List<String> attrList = mallGoodsAttrService.attrList();
        return Result.success("list",attrList);
    }

}
