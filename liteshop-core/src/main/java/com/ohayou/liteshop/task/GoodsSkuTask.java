package com.ohayou.liteshop.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.dto.GoodsSkuDto;
import com.ohayou.liteshop.dto.SpecAndValueDto;
import com.ohayou.liteshop.entity.MallGoodsSku;
import com.ohayou.liteshop.entity.MallGoodsSpec;
import com.ohayou.liteshop.entity.MallGoodsSpecValue;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.service.MallGoodsSkuService;
import com.ohayou.liteshop.service.MallGoodsSpecService;
import com.ohayou.liteshop.service.MallGoodsSpecValueService;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.vo.SkuVo;
import com.ohayou.liteshop.vo.SpecValueVo;
import com.ohayou.liteshop.vo.SpecVo;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * @author liyan
 * @date 2021/1/3 上午10:39
 */
public class GoodsSkuTask implements Callable<SkuVo> {

    private Long goodsId;


    private MallGoodsSkuService mallGoodsSkuService;




    public GoodsSkuTask(Long goodsId, MallGoodsSkuService mallGoodsSkuService) {
        this.goodsId = goodsId;
        this.mallGoodsSkuService = mallGoodsSkuService;

    }

    @Override
    public SkuVo call() throws Exception {
        return mallGoodsSkuService.getGoodsSkuVo(goodsId);
    }


}
