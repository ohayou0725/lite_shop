package com.ohayou.liteshop.service;

import com.ohayou.liteshop.dto.CommentReplyDto;
import com.ohayou.liteshop.entity.MallGoodsCommentReply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ohayou
 * @since 2020-09-14
 */
public interface MallGoodsCommentReplyService extends IService<MallGoodsCommentReply> {


    List<CommentReplyDto> getReplyTree(Long id);
}
