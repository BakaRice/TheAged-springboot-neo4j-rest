package com.ricemarch.Dto;

import java.util.ArrayList;

public class MinioMultUploadDto {
    private ArrayList<String> names;
    private ArrayList<String> urls;

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }
}
