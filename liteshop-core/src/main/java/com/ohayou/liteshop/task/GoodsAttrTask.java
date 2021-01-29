package com.ohayou.liteshop.task;

import com.ohayou.liteshop.dto.AttrValueDto;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.vo.GoodsAttrVo;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * @author liyan
 * @date 2021/1/17 下午1:31
 */
public class GoodsAttrTask implements Callable<List<GoodsAttrVo>> {

    private final Long goodsId;

    private final MallGoodsSpuService goodsSpuService;

    public GoodsAttrTask(Long goodsId, MallGoodsSpuService goodsSpuService) {
        this.goodsId = goodsId;
        this.goodsSpuService = goodsSpuService;
    }

    @Override
    public List<GoodsAttrVo> call() throws Exception {
        return goodsSpuService.getGoodsAttrVo(goodsId);
    }
}
