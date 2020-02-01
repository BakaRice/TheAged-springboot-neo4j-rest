package com.ricemarch;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.util.ArrayList;

public class Moment {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private ArrayList<String> imgUrls;

    private int likeNum = 0;

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

    public Moment(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
