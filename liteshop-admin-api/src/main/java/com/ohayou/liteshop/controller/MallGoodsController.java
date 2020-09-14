package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.*;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallGoodsSkuService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.service.UploadService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @date 2020/8/15 下午11:04
 */
@RestController
@RequestMapping("/product/goods")
public class MallGoodsController {

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    UploadService qiniuUploadService;

    @Autowired
    MallGoodsSkuService goodsSkuService;


    /**
     * 条件查询商品列表
     * @param mallGoodsSpuDto
     * @param pageParam
     * @return
     */
    @ApiDesc("查询商品列表")
    @GetMapping("/list")
    public Result goodsSpuList(MallGoodsSpuDto mallGoodsSpuDto,Map<String,Object> pageParam) {
        PageQuery<MallGoodsSpu> goodsSpuPageQuery = new PageQuery<>();
        IPage<MallGoodsSpu> page = goodsSpuPageQuery.getPage(pageParam, "create_time", false);
        PageUtils result = goodsSpuService.getPage(mallGoodsSpuDto,page);
        return Result.success("list",result);
    }

    /**
     * 根据商品spuId获取商品详细信息
     * @param goodsId
     * @return
     */
    @ApiDesc("获取商品详情")
    @GetMapping("/detail/{goodsId}")
    public Result goodsDetail(@PathVariable("goodsId") Long goodsId) {
        if (goodsId == null || goodsId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        GoodsDetailDto goodsDetailDto = goodsSpuService.getDetail(goodsId);
        return Result.success("detail",goodsDetailDto);
    }


    /**
     * 新增商品
     * @return
     */
    @ApiDesc("添加商品")
    @PostMapping("/add")
    public Result addGoods(@RequestBody @Valid GoodsFormDto goodsFormDto) {
        boolean result = goodsSpuService.addGoodsSpu(goodsFormDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.SAVE_GOODS_ERROR);
    }

    /**
     * 上传商品图片
     * @param file
     * @return
     */

    @ApiDesc("上传商品图片")
    @PostMapping("/upload")
    public Result uploadTitleImg(@RequestParam("file")MultipartFile file) {
        String fileName = "product/img/";
        String url = qiniuUploadService.upload(file, fileName);
        return Result.success("url",url);
    }

    /**
     * 上传商品轮播图
     * @param file
     * @return
     */

    @ApiDesc("上传商品轮播图")
    @PostMapping("/upload/gallery")
    public Result uploadGallery(@RequestParam("file")MultipartFile file) {
        String fileName = "product/gallery/";
        String url = qiniuUploadService.upload(file, fileName);
        return Result.success("url",url);
    }

    /**
     * 修改商品基本信息
     * @param goodsFormDto
     * @return
     */
    @ApiDesc("修改商品基本信息")
    @PostMapping("/update/basicInfo")
    public Result updateBasicInfo(@RequestBody @Valid GoodsFormDto goodsFormDto) {
        boolean result = goodsSpuService.updateBasicInfo(goodsFormDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_GOODS_INFO_ERROR);
    }

    /**
     * 修改商品属性
     * @param goodsFormDto
     * @return
     */
    @ApiDesc("修改商品属性")
    @PostMapping("/update/attr")
    public Result updateAttr(@RequestBody GoodsFormDto goodsFormDto) {
        boolean result = goodsSpuService.updateAttr(goodsFormDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_GOODS_ATTR_ERROR);
    }

    /**
     * 修改商品规格
     * @param goodsFormDto
     * @return
     */
    @ApiDesc("修改商品规格")
    @PostMapping("/update/spec")
    public Result updateSpec(@RequestBody GoodsFormDto goodsFormDto) {
        boolean result = goodsSpuService.updateSpec(goodsFormDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_GOODS_SPEC_ERROR);
    }

//    /**
//     * 修改商品在售状态
//     * @param goodsFormDto
//     * @return
//     */
//    @ApiDesc("修改商品状态")
//    @PostMapping("changeStatus")
//    public Result changeStatus(@RequestBody GoodsFormDto goodsFormDto) {
//        boolean result = goodsSpuService.changeStatus(goodsFormDto);
//        return result ? Result.success() : Result.error(ErrorCodeMsg.CHANGE_GOODS_STATUS_ERROR);
//    }

    /**
     * 修改商品详情页信息
     * @param goodsFormDto
     * @return
     */
    @ApiDesc("修改商品详情页")
    @PostMapping("update/detail")
    public Result updateDetail(@RequestBody GoodsFormDto goodsFormDto) {
        boolean result = goodsSpuService.updateDetail(goodsFormDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.UPDATE_GOODS_INFO_ERROR);
    }

    @ApiDesc("获取商品所有规格")
    @GetMapping("/specs/{id}")
    public Result getSpecs(@PathVariable("id") Long id) {
        if (id == null || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<MallGoodsSpecDto> spec = goodsSpuService.getSpecsById(id);
        return Result.success("list",spec);
    }

    @ApiDesc("删除商品")
    @PostMapping("/delete/{id}")
    public Result deleteGoods(@PathVariable("id") Long id) {
        if (id == null || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = goodsSpuService.deleteGoods(id);
        return result ? Result.success() : Result.error(ErrorCodeMsg.DELETE_GOODS_ERROR);
    }

    /**
     * 获取商品下的sku信息
     * @param spuId
     * @return
     */
    @ApiDesc("获取商品下所有sku")
    @GetMapping("/sku")
    public Result skuList(@RequestParam("goodsSn") String goodsSn) {
        List<GoodsSkuDto> goodsSkuDtoList = goodsSkuService.getSkuByGoodsSn(goodsSn);
        return Result.success("list",goodsSkuDtoList);
    }

    /**
     * 根据sn获取商品所有规格信息
     * @param goodsSn
     * @return
     */
    @ApiDesc("获取商品规格信息")
    @GetMapping("/getSpec")
    public Result specList(@RequestParam("goodsSn") String goodsSn) {
        if (StringUtils.isBlank(goodsSn)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        List<MallGoodsSpecDto> goodsSpecDtos = goodsSpuService.specListByGoodsSn(goodsSn);
        return Result.success("list",goodsSpecDtos);
    }

    /**
     * 上架单品
     * @param goodsSkuDto
     * @return
     */
    @ApiDesc("添加商品Sku信息")
    @PostMapping("/sku/add")
    public Result addSku(@RequestBody @Validated(value = GoodsSkuDto.AddSkuValid.class) GoodsSkuDto goodsSkuDto) {
        boolean result = goodsSkuService.addGoodsSku(goodsSkuDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.GOODS_ADD_SKU_ERROR);

    }

    /**
     * 修改sku信息
     * @param goodsSkuDto
     * @return
     */
    @ApiDesc("修改sku信息")
    @PostMapping("/sku/update")
    public Result updateSku(@RequestBody @Validated(value = GoodsSkuDto.UpdateSkuValid.class) GoodsSkuDto goodsSkuDto) {
        boolean result = goodsSkuService.updateGoodsSku(goodsSkuDto);
        return result ? Result.success() : Result.error(ErrorCodeMsg.GOODS_SKU_UPDATE_ERROR);
    }

    /**
     * 根据skuId删除单品
     * @param skuId
     * @return
     */
    @ApiDesc("下架单品")
    @PostMapping("/sku/offShelf/{id}")
    public Result offShelfSku(@PathVariable("id") Long skuId) {
        if (null == skuId || skuId < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean  result = goodsSkuService.deleteSku(skuId);
        return result ? Result.success() : Result.error(ErrorCodeMsg.GOODS_SKU_DELETE_ERROR);
    }

    /**
     * 根据goods_sn下架该商品下所有单品
     * @param spuId
     * @return
     */
    @ApiDesc("下架全部单品")
    @PostMapping("/sku/allOffShelf/{goodsSn}")
    public Result allOffShelf(@PathVariable("goodsSn") String goodsSn) {
        if (StringUtils.isBlank(goodsSn)) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        boolean result = goodsSkuService.deleteAllSku(goodsSn);
        return result ? Result.success() : Result.error(ErrorCodeMsg.GOODS_SKU_DELETE_ERROR);
    }
}
