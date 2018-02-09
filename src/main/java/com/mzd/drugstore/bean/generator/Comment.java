package com.mzd.drugstore.bean.generator;

public class Comment {
    private String commentId;

    private String userId;

    private String productId;

    private String commentCreatetime;

    private String commentStatus;

    private String commentLevel;

    private String commentContent;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getCommentCreatetime() {
        return commentCreatetime;
    }

    public void setCommentCreatetime(String commentCreatetime) {
        this.commentCreatetime = commentCreatetime == null ? null : commentCreatetime.trim();
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus == null ? null : commentStatus.trim();
    }

    public String getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(String commentLevel) {
        this.commentLevel = commentLevel == null ? null : commentLevel.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}