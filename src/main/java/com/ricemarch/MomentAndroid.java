package com.ricemarch;

import java.util.ArrayList;

public class MomentAndroid {

    ArrayList<String> imgs;
    String name;
    String title;
    String content;

    public ArrayList<String> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<String> imgs) {
        this.imgs = imgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public MomentAndroid(ArrayList<String> imgs, String name, String title, String content) {
        this.imgs = imgs;
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public MomentAndroid() {
    }
}