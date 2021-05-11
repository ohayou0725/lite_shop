package com.ohayou.liteshop.controller;

import com.ohayou.liteshop.aop.ApiDesc;
import com.ohayou.liteshop.response.ErrorCodeMsg;
import com.ohayou.liteshop.response.Result;
import com.ohayou.liteshop.security.MemberUserDetails;
import com.ohayou.liteshop.security.SecurityUtil;
import com.ohayou.liteshop.service.MallGoodsCommentService;
import com.ohayou.liteshop.service.UploadService;
import com.ohayou.liteshop.vo.CommentFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * @author liyan
 * @date 2021/4/5 上午10:45
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    UploadService qiniuUploadService;

    @Autowired
    MallGoodsCommentService commentService;

    @ApiDesc("用户上传评论晒图")
    @PostMapping("/upload")
    public Result uploadImg(@RequestParam("file") MultipartFile file) {
        String fileName = "comment/";
        String url = qiniuUploadService.upload(file,fileName);
        return Result.success("url",url);
    }

    @ApiDesc("用户发表评论")
    @PostMapping("/commit")
    public Result commitComment(@RequestBody @Valid CommentFormVo commentFormVo, Authentication authentication) {
        MemberUserDetails memberUser = SecurityUtil.getMemberUser(authentication);
        boolean result = commentService.commit(commentFormVo,memberUser.getId());
        return result ? Result.success():Result.error(ErrorCodeMsg.COMMENT_ERROR);
    }
}
