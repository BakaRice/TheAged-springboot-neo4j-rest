package com.ricemarch;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Moment {

    @Id
    @GeneratedValue
    private Long id;

    //通过uuid进行唯一标识
    private String MomentUuid;

    private String title;

    private String content;

    private Timestamp sharetime;

    private ArrayList<String> imgUrls;

    private int likeNum = 0;

    @Relationship(type = "BE_COMMENTED", direction = Relationship.INCOMING)
    private Set<Comment> comments;

    void addBeComments(Comment comment) {
        if (comments == null) comments = new HashSet<>();
        comments.add(comment);
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(ArrayList<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Timestamp getSharetime() {
        return sharetime;
    }

    public void setSharetime(Timestamp sharetime) {
        this.sharetime = sharetime;
    }


    public String getMomentUuid() {
        return MomentUuid;
    }

    public void setMomentUuid(String momentUuid) {
        MomentUuid = momentUuid;
    }

    public Moment(String title, String content) {
        MomentUuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        this.title = title;
        this.content = content;
    }
}
