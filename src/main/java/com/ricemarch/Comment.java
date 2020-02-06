package com.ricemarch;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

//@NodeEntity
public class Comment {

    @Id
    @GeneratedValue
    private Long Id;

    //评论内容
    private String conetnt;

    //用来找到发送人
    private String UserId;

    //对 comment 发表 comment
    @Relationship(type = "COMMENT_IN_COMMENT")
    private  Set<Comment> comments;
    void  addCommenToComment(Comment comment){
        if (comments == null) comments = new HashSet<>();
        comments.add(comment);
    }
//        //对 Moment 发布 comment
//    @Relationship(type = "COMMENT_IN_MOMENT")
//    private Set<Moment> moments;
//    void  addCommentToMoment(Moment moment){
//        if (moments == null) moments = new HashSet<>();
//        moments.add(moment);
//    }

//    // comment 被 评论
//    @Relationship(type = "COMMENT_BE_COMMENTED")
//    private  Set<Comment> beComments;
//    private void  addBeComment(Comment comment){
//        if (beComments == null) beComments = new HashSet<>();
//        beComments.add(comment);
//    }


    public String getConetnt() {
        return conetnt;
    }

    public void setConetnt(String conetnt) {
        this.conetnt = conetnt;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public Comment(String c) {
        conetnt = c;
    }
}
