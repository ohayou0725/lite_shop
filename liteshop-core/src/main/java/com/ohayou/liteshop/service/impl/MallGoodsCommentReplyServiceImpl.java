package com.ohayou.liteshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ohayou.liteshop.dto.CommentReplyDto;
import com.ohayou.liteshop.entity.MallGoodsCommentReply;
import com.ohayou.liteshop.dao.MallGoodsCommentReplyMapper;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.service.MallGoodsCommentReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.service.MemUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-09-14
 */
@Service
public class MallGoodsCommentReplyServiceImpl extends ServiceImpl<MallGoodsCommentReplyMapper, MallGoodsCommentReply> implements MallGoodsCommentReplyService {

    @Autowired
    MemUserService userService;

    /**
     * 根据评论ID以树的形式获取所有回复
     *
     * @param id
     * @return
     */
    @Override
    public List<CommentReplyDto> getReplyTree(Long commentId) {
        //获取所有根回复
        List<MallGoodsCommentReply> all = this.list(new LambdaQueryWrapper<MallGoodsCommentReply>().eq(MallGoodsCommentReply::getCommentId, commentId));
        List<MallGoodsCommentReply> root = all.stream()
                .filter(mallGoodsCommentReply -> {
                    return mallGoodsCommentReply.getParentId().equals(0L);
                }).collect(Collectors.toList());

        List<CommentReplyDto> collect = root.stream()
                .map(reply -> {
                    CommentReplyDto commentReplyDto = new CommentReplyDto();
                    commentReplyDto.setCommentId(commentId);
                    BeanUtils.copyProperties(reply, commentReplyDto);
                    MemUser one = userService.getById(reply.getUserId());
                    if (null != one) {
                        commentReplyDto.setAvatar(one.getAvatar());
                        commentReplyDto.setNickName(one.getNickname());
                    }
                    commentReplyDto.setReplies(getChildren(reply.getId(), all));
                    return commentReplyDto;
                }).sorted((t1, t2) -> {
                    if (t1.getCreateTime().isAfter(t2.getCreateTime())) {
                        return 1;
                    } else if (t1.getCreateTime().isAfter(t2.getCreateTime())) {
                        return -1;
                    } else {
                        return 0;
                    }
                }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 递归查询子回复
     * @param replyId
     * @param all
     * @return
     */
    private List<CommentReplyDto> getChildren(Long replyId, List<MallGoodsCommentReply> all) {
        List<CommentReplyDto> collect = all.stream().filter(reply -> {
            return reply.getParentId().equals(replyId);
        }).map(reply -> {
            CommentReplyDto commentReplyDto = new CommentReplyDto();
            commentReplyDto.setCommentId(reply.getId());
            BeanUtils.copyProperties(reply, commentReplyDto);
            MemUser one = userService.getById(reply.getUserId());
            if (null != one) {
                commentReplyDto.setAvatar(one.getAvatar());
                commentReplyDto.setNickName(one.getNickname());
            }
            commentReplyDto.setReplies(getChildren(reply.getId(), all));
            return commentReplyDto;
        }).sorted((t1, t2) -> {
            if (t1.getCreateTime().isAfter(t2.getCreateTime())) {
                return 1;
            } else if (t1.getCreateTime().isAfter(t2.getCreateTime())) {
                return -1;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());
        return collect;
    }
}
