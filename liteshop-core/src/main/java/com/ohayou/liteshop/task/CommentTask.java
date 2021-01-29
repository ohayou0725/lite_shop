package com.ohayou.liteshop.task;

import cn.hutool.core.collection.CollectionUtil;
import com.ohayou.liteshop.entity.MallGoodsComment;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.service.MallGoodsCommentService;
import com.ohayou.liteshop.service.MemUserService;
import com.ohayou.liteshop.utils.RateUtil;
import com.ohayou.liteshop.vo.CommentItemVo;
import com.ohayou.liteshop.vo.CommentVo;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * @author liyan
 * @date 2021/1/2 上午11:22
 */
public class CommentTask implements Callable<CommentVo> {
    private final Long goodsId;

    private final MallGoodsCommentService mallGoodsCommentService;


    public CommentTask(Long goodsId, MallGoodsCommentService mallGoodsCommentService) {
        this.goodsId = goodsId;
        this.mallGoodsCommentService = mallGoodsCommentService;
    }

    @Override
    public CommentVo call() throws Exception {
        return mallGoodsCommentService.getCommentVo(goodsId);
    }
}
