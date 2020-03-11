package com.ricemarch.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

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

    //发送人名（唯一值）,迫不得已的做法 感觉并不妥当
    private String name;

    private String title;

    private String content;

    private Long sharetime;

    private ArrayList<String> imgUrls;

    private int likeNum = 0;

    @Relationship(type = "BE_COMMENTED", direction = Relationship.INCOMING)
    private Set<Comment> comments;

    public void addBeComments(Comment comment) {
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

    public Long getSharetime() {
        return sharetime;
    }

    public void setSharetime(Long sharetime) {
        this.sharetime = sharetime;
    }

    public String getMomentUuid() {
        return MomentUuid;
    }

    public void setMomentUuid(String momentUuid) {
        MomentUuid = momentUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Moment(String name, String title, String content) {
        MomentUuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
