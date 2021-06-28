package com.example.testforvrgsoft.models;

import androidx.fragment.app.Fragment;

public class Publications {
    public String getAuthor_fullname() {
        return author_fullname;
    }

    public String getThumbnail() {
        return thumbnail;
    }


    public Integer getNum_comments() {
        return num_comments;
    }

    public long getCreated() {
        return (long) (created / 86400000);
    }

    private String author_fullname;
    private String thumbnail;
    private Integer num_comments;
    private double created;
}
