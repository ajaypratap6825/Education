package com.example.projects.education;

public class Videos {
    String url, id;

    public Videos() {
    }

    public Videos(String url, String id) {
        this.url = url;
        this.id = id;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
