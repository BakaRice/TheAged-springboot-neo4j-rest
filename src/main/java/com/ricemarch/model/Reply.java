package com.ricemarch.model;

public class Reply {
    private String id;

    private String MomentUuid;

    //回复多一条对应的commentuuid
    private String CommentUuid;

    private String name;

    private String toName;

    private String commentInfo;

    private Long createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMomentUuid() {
        return MomentUuid;
    }

    public void setMomentUuid(String momentUuid) {
        MomentUuid = momentUuid;
    }

    public String getCommentUuid() {
        return CommentUuid;
    }

    public void setCommentUuid(String commentUuid) {
        CommentUuid = commentUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
