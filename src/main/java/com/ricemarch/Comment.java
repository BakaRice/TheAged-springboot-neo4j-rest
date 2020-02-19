package com.ricemarch;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

//@NodeEntity
public class Comment {

    @Id
    @GeneratedValue
    private Long Id;

    private String CommentUuid;

    //评论内容
    private String content;

    //发送人姓名 用来找到发送人
    private String name;

    //对 comment 发表 comment
    @Relationship(type = "COMMENT_IN_COMMENT")
    private Set<Comment> comments;

    public void addCommenToComment(Comment comment) {
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

    public String getCommentUuid() {
        return CommentUuid;
    }

    public void setCommentUuid(String commentUuid) {
        CommentUuid = commentUuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comment(String c) {
        CommentUuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        content = c;
    }
}
