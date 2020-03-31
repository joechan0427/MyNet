package com.joe.entity;

import java.util.Date;

public class Comment {
    private String commentId;

    private String userId;

    private Date createTime;

    private String content;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                '}';
    }

    public Comment(String commentId, String userId, Date createTime, String content) {
        this.commentId = commentId;
        this.userId = userId;
        this.createTime = createTime;
        this.content = content;
    }

    public Comment() {
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}