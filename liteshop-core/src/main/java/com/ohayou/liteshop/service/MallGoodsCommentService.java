package com.ohayou.liteshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.CommentDetailDto;
import com.ohayou.liteshop.dto.GoodsCommentDto;
import com.ohayou.liteshop.entity.MallGoodsComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ohayou.liteshop.utils.PageUtils;

/**
 * <p>
 * 商品评论表 服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
public interface MallGoodsCommentService extends IService<MallGoodsComment> {

    PageUtils getPage(GoodsCommentDto commentDto, IPage<MallGoodsComment> page);

    CommentDetailDto getDetail(Long id);
}
