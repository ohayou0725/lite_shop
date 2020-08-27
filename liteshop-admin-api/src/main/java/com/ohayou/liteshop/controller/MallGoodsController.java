package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.GoodsDetailDto;
import com.ohayou.liteshop.dto.GoodsFormDto;
import com.ohayou.liteshop.dto.MallGoodsSpuDto;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallGoodsSpuService;
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
 * @date 2020/8/15 下午11:04
 */
@RestController
@RequestMapping("/product/goods")
public class MallGoodsController {

    @Autowired
    MallGoodsSpuService goodsSpuService;

    @Autowired
    UploadService qiniuUploadService;


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
    @ApiDesc("/添加商品")
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

    @ApiDesc("/上传商品图片")
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

    @ApiDesc("/上传商品图片")
    @PostMapping("/upload/gallery")
    public Result updateGallery(@RequestParam("file")MultipartFile file) {
        String fileName = "product/gallery/";
        String url = qiniuUploadService.upload(file, fileName);
        return Result.success("url",url);
    }
}
