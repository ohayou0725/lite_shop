package com.ohayou.liteshop.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.dto.CommentDetailDto;
import com.ohayou.liteshop.dto.GoodsCommentDto;
import com.ohayou.liteshop.entity.MallGoodsComment;
import com.ohayou.liteshop.dao.MallGoodsCommentMapper;
import com.ohayou.liteshop.entity.MallGoodsSku;
import com.ohayou.liteshop.entity.MallGoodsSpu;
import com.ohayou.liteshop.entity.MemUser;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ohayou.liteshop.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品评论表 服务实现类
 * </p>
 *
 * @author ohayou
 * @since 2020-07-15
 */
@Service
public class MallGoodsCommentServiceImpl extends ServiceImpl<MallGoodsCommentMapper, MallGoodsComment> implements MallGoodsCommentService {
    @Autowired
    MallGoodsSpuService spuService;

    @Autowired
    MemUserService userService;

    @Autowired
    MallGoodsSkuService skuService;

    @Autowired
    MallGoodsCommentReplyService replyService;



    /**
     * 条件查询商品评论信息
     * @param commentDto
     * @param page
     * @return
     */
    @Override
    public PageUtils getPage(GoodsCommentDto commentDto, IPage<MallGoodsComment> page) {
        LambdaQueryWrapper<MallGoodsComment> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(commentDto.getGoodsSn())) {
            MallGoodsSpu one = spuService.getOne(new LambdaQueryWrapper<MallGoodsSpu>().eq(MallGoodsSpu::getGoodsSn, commentDto.getGoodsSn()));
            if (null == one) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MallGoodsComment::getGoodsId,one.getId());
        }

        if (StringUtils.isNotBlank(commentDto.getUserMobile())) {
            MemUser one = userService.getOne(new LambdaQueryWrapper<MemUser>().eq(MemUser::getMobile, commentDto.getUserMobile()));
            if (null == one) {
                return new PageUtils(page);
            }
            queryWrapper.eq(MallGoodsComment::getUserId,one.getId());
        }
        queryWrapper.eq(null != commentDto.getScore(),MallGoodsComment::getScore,commentDto.getScore());

        this.page(page,queryWrapper);
        PageUtils pageUtils = new PageUtils(page);

        if (CollectionUtil.isNotEmpty(page.getRecords())) {
            List<Long> goodsIds = page.getRecords().stream()
                    .map(MallGoodsComment::getGoodsId).collect(Collectors.toList());
            Collection<MallGoodsSpu> mallGoodsSpus = spuService.listByIds(goodsIds);


            List<GoodsCommentDto> collect = page.getRecords().stream()
                    .map(mallGoodsComment -> {
                        GoodsCommentDto goodsCommentDto = new GoodsCommentDto();
                        BeanUtils.copyProperties(mallGoodsComment, goodsCommentDto);
                        Optional<MallGoodsSpu> first = mallGoodsSpus.stream().filter(goodsSpu -> {
                            return goodsSpu.getId().equals(goodsCommentDto.getGoodsId());
                        }).findFirst();
                        if (first.isPresent()) {
                            goodsCommentDto.setGoodsSn(first.get().getGoodsSn());
                            goodsCommentDto.setGoodsTitle(first.get().getTitle());
                            goodsCommentDto.setSpecAndValue(skuService.getSpecAndValue(mallGoodsComment.getSpecSn()));
                            Long userId = mallGoodsComment.getUserId();
                            MemUser user = userService.getById(userId);
                            goodsCommentDto.setUserMobile(user.getMobile());
                            return goodsCommentDto;
                        } else {
                            return null;
                        }

                    }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

    /**
     * 根据品论id获取评论详情
     * @param id
     * @return
     */
    @Override
    public CommentDetailDto getDetail(Long id) {
        MallGoodsComment comment = this.getById(id);
        if (null == comment) {
            throw new GlobalException(ErrorCodeMsg.COMMENT_NOT_FOUND);
        }
        CommentDetailDto commentDetailDto = new CommentDetailDto();
        BeanUtils.copyProperties(comment,commentDetailDto);
        String[] imgs = StringUtils.isNotEmpty(comment.getImg()) ? comment.getImg().split(",") : null;
        commentDetailDto.setImgs(imgs);

        MemUser user = userService.getById(comment.getId());
        if (null == user) {
            throw new GlobalException(ErrorCodeMsg.USER_NOT_FOUND);
        }
        commentDetailDto.setCommentId(comment.getId());
        commentDetailDto.setAvatar(user.getAvatar());
        commentDetailDto.setNickName(user.getNickname());
        commentDetailDto.setReplies(replyService.getReplyTree(comment.getId()));
        return commentDetailDto;
    }
}
