package com.ohayou.liteshop.task;

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
    private Long goodsId;

    private MallGoodsCommentService mallGoodsCommentService;

    private MemUserService memUserService;

    @Override
    public CommentVo call() throws Exception {
        List<MallGoodsComment> comments = mallGoodsCommentService.getCommentByGoodsId(goodsId);
        CommentVo commentVo = new CommentVo();
        commentVo.setGoodsId(goodsId);
        commentVo.setNum(comments.size());
        List<CommentItemVo> commentItemVoList = comments.stream()
                .sorted(Comparator.comparing(MallGoodsComment::getUserId))
                .map(comment -> {
                    CommentItemVo commentItemVo = new CommentItemVo();
                    commentItemVo.setCommentId(comment.getId());
                    commentItemVo.setContent(comment.getContent());
                    if (StringUtils.isNotEmpty(comment.getImg())) {
                        commentItemVo.setImgs(comment.getImg().split(","));
                    }
                    commentItemVo.setScore(comment.getScore());
                    commentItemVo.setTime(comment.getCreateTime());
                    return commentItemVo;
                }).collect(Collectors.toList());

        //计算好评率
        long count = comments.stream()
                .filter(mallGoodsComment -> {
                    Integer score = mallGoodsComment.getScore();
                    return score > 4;
                }).count();
        String rate = RateUtil.getRate((int) count,comments.size());
        commentVo.setRate(rate);
        List<Long> userIds =
                comments.stream()
                        .map(MallGoodsComment::getUserId)
                        .collect(Collectors.toList());
        List<MemUser> memUsers = memUserService.getBaseMapper().selectBatchIds(userIds);
        memUsers.sort(Comparator.comparing(MemUser::getId));

        for (int i = 0; i < memUsers.size(); i++) {
            MemUser memUser = memUsers.get(i);
            CommentItemVo commentItemVo = commentItemVoList.get(0);
            commentItemVo.setAvatar(memUser.getAvatar());
            commentItemVo.setUsername(memUser.getNickname());
        }

        commentItemVoList.stream()
                .sorted(Comparator.comparing(CommentItemVo::getTime))

        return null;
    }
}
