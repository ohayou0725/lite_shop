package com.ohayou.liteshop.dto;

import com.ohayou.liteshop.entity.MallGoodsCommentReply;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/9/16 下午9:50
 */
public class CommentDetailDto {

    private Long commentId;

    private String content;

    private Integer likes;

    private String[] imgs;

    private String avatar;

    private String nickName;

    private List<CommentReplyDto> replies;

    private LocalDateTime createTime;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String[] getImgs() {
        return imgs;
    }

    public void setImgs(String[] imgs) {
        this.imgs = imgs;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<CommentReplyDto> getReplies() {
        return replies;
    }

    public void setReplies(List<CommentReplyDto> replies) {
        this.replies = replies;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
