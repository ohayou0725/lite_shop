package com.ohayou.liteshop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.dto.CommentDetailDto;
import com.ohayou.liteshop.dto.GoodsCommentDto;
import com.ohayou.liteshop.entity.MallGoodsComment;
import com.ohayou.liteshop.exception.GlobalException;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.service.MallGoodsCommentService;
import com.ohayou.liteshop.utils.PageQuery;
import com.ohayou.liteshop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liyan
 * @date 2020/9/14 下午3:49
 */
@RestController
@RequestMapping("/product/comment")
public class MallGoodsCommentController {

    @Autowired
    MallGoodsCommentService mallGoodsCommentService;

    @ApiDesc("查询商品评论")
    @GetMapping("/list")
    public Result commentList(GoodsCommentDto commentDto, Map<String,Object> pageParam) {
        PageQuery<MallGoodsComment> commentPageQuery = new PageQuery<>();
        IPage<MallGoodsComment> page = commentPageQuery.getPage(pageParam);
        PageUtils pageUtils = mallGoodsCommentService.getPage(commentDto,page);
        return Result.success("list",pageUtils);
    }


    @ApiDesc("查询评论详情")
    @GetMapping("/detail/{id}")
    public Result commentDetail(@PathVariable("id") Long id) {
        if (null == id || id < 1) {
            throw new GlobalException(ErrorCodeMsg.PARAMETER_VALIDATED_ERROR);
        }
        CommentDetailDto commentDetailDto = mallGoodsCommentService.getDetail(id);
        return Result.success("detail",commentDetailDto);
    }
}
