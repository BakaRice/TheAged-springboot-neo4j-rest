package com.ricemarch;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

import java.util.HashSet;
import java.util.Set;

public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //针对 moment 点赞
    @Relationship(type = "LIKE_IN")
    public Set<Moment> likes;

    public void addlikes(Moment moment) {
        if (likes == null) {
            likes = new HashSet<>();
        }
        likes.add(moment);
    }

    //发表 moment
    @Relationship(type = "PUBLISH")
    public Set<Moment> moments;

    public void addMoments(Moment moment) {
        if (moments == null) {
            moments = new HashSet<>();
        }
        moments.add(moment);
    }

    //发表 comment
    @Relationship(type = "COMMENT")
    public Set<Comment> comments;

    public void addComments(Comment comment) {
        if (comments == null) {
            comments = new HashSet<>();
        }
        comments.add(comment);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }
}
