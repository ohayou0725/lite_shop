package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.MallBrandCategoryDto;
import com.ohayou.liteshop.dto.MallBrandDto;
import com.ohayou.liteshop.entity.MallBrand;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallBrandService;
import com.ohayou.liteshop.service.UploadService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/8/12 下午1:55
 */
@RestController()
@RequestMapping("/product/brand")
public class MallBrandController {

    @Autowired
    MallBrandService brandService;

    @Autowired
    UploadService qiniuUploadService;

    /**
     * 查询品牌列表
     * @param mallBrandDto
     * @param queryParams
     * @return
     */

    @ApiDesc("查询品牌列表")
    @GetMapping("/list")
    public Result branList(MallBrandDto mallBrandDto, Map<String,Object> queryParams) {
        PageQuery<MallBrand> mallBrandPageQuery = new PageQuery<>();
        PageUtils pageUtils = brandService.queryPage(mallBrandDto,mallBrandPageQuery.getPage(queryParams,"create_time",true));
        return Result.success("page",pageUtils);
    }

    /**
     * 上传品牌logo
     * @param file
     * @return
     */

    @ApiDesc("上传品牌商logo图片")
    @PostMapping("/upload")
    public Result upload(@RequestParam("file")MultipartFile file) {
        String url = qiniuUploadService.upload(file);
        return Result.success("url",url);
    }

    /**
     * 添加品牌信息
     * @param mallBrandDto
     * @return
     */
    @ApiDesc("添加品牌信息")
    @PostMapping("/add")
    public Result addBrand(@RequestBody @Valid MallBrandDto mallBrandDto) {
        boolean result = brandService.addBrand(mallBrandDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.SAVE_BRAND_ERROR);
    }

    /**
     * 更新品牌信息
     */
    @ApiDesc("更新品牌信息")
    @PostMapping("/update")
    public Result updateBrand(@RequestBody @Valid MallBrandDto mallBrandDto) {
        if (null == mallBrandDto.getId() || mallBrandDto.getId() < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = brandService.updateBrand(mallBrandDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.BRAND_UPDATE_ERROR);
    }

    /**
     * 删除品牌商
     * @param brandId
     * @return
     */
    @ApiDesc("删除品牌商")
    @PostMapping("/delete/{brandId}")
    public Result deleteBrand(@PathVariable("brandId") Long brandId) {
        if (null == brandId || brandId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        brandService.deleteBrand(brandId);
        return Result.success();
    }

    /**
     * 添加品牌分类
     * @param mallBrandCategoryDto
     * @return
     */
    @ApiDesc("添加品牌商分类")
    @PostMapping("/addCategory")
    public Result addCateGory(@RequestBody @Valid MallBrandCategoryDto mallBrandCategoryDto) {
        brandService.addCategory(mallBrandCategoryDto.getBrandId(), mallBrandCategoryDto.getCategoryId());
        return Result.success();
    }

    @ApiDesc("删除品牌商分类")
    @PostMapping("/deleteCategory")
    public Result deleteCategory( @RequestBody @Valid MallBrandCategoryDto mallBrandCategoryDto) {
        brandService.deleteCategory(mallBrandCategoryDto.getBrandId(), mallBrandCategoryDto.getCategoryId());
        return Result.success();
    }
}
