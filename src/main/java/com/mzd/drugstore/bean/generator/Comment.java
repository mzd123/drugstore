package com.mzd.drugstore.bean.generator;

public class Comment {
    private String commentId;

    private String userId;

    private String productId;

    private String commentCreatetime;

    private String 
commentContent;

    private String commentStatus;

    private String commentImg;

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

    public String get
commentContent() {
        return 
commentContent;
    }

    public void set
commentContent(String 
commentContent) {
        this.
commentContent = 
commentContent == null ? null : 
commentContent.trim();
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus == null ? null : commentStatus.trim();
    }

    public String getCommentImg() {
        return commentImg;
    }

    public void setCommentImg(String commentImg) {
        this.commentImg = commentImg == null ? null : commentImg.trim();
    }
}