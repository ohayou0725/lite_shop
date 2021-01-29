package com.ohayou.liteshop.task;

import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import com.ohayou.liteshop.vo.GoodsInfoVo;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

/**
 * @author liyan
 * @date 2021/1/2 上午11:10
 */
public class GoodsSpuTask implements Callable<GoodsInfoVo> {
    private Long goodsId;

    private MallGoodsSpuService mallGoodsSpuService;

    public GoodsSpuTask(Long goodsId, MallGoodsSpuService mallGoodsSpuService) {
        this.goodsId = goodsId;
        this.mallGoodsSpuService = mallGoodsSpuService;
    }

    @Override
    public GoodsInfoVo call() throws Exception {
        return mallGoodsSpuService.getGoodsInfoVo(goodsId);
    }
}
