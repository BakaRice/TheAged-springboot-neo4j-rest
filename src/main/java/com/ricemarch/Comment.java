package com.ricemarch;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Comment {

    @Id
    @GeneratedValue
    private Long Id;

    //评论内容
    private String Cconetnt;

    //对 Moment 发布 comment
    @Relationship(type = "COMMENT_IN_MOMENT")
    private Set<Moment> moments;
    private void  addCommentToMoment(Moment moment){
        if (moments == null) moments = new HashSet<>();
        moments.add(moment);
    }
    //对 comment 发表 comment
    @Relationship(type = "COMMENT_IN_COMMENT")
    private  Set<Comment> comments;
    private void  addCommenToComment(Comment comment){
        if (comments == null) comments = new HashSet<>();
        comments.add(comment);
    }

    public Comment(String cconetnt) {
        Cconetnt = cconetnt;
    }
}
