package com.ohayou.liteshop.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyan
 * @date 2020/9/16 下午10:29
 */
public class CommentReplyDto {

    private Long id;

    private Long commentId;

    private String avatar;

    private String nickName;

    private String content;

    private Long parentId;

    private List<CommentReplyDto> replies;

    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<CommentReplyDto> getReplies() {
        return replies;
    }

    public void setReplies(List<CommentReplyDto> replies) {
        this.replies = replies;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
