package com.ohayou.liteshop.task;

import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.service.MallGoodsSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

/**
 * @author liyan
 * @date 2021/1/2 上午11:10
 */
public class GoodsSpuTask implements Callable<MallGoodsSpu> {
    private Long goodsId;

    private MallGoodsSpuService mallGoodsSpuService;

    public GoodsSpuTask(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public MallGoodsSpu call() throws Exception {
        return mallGoodsSpuService.getById(goodsId);
    }
}
