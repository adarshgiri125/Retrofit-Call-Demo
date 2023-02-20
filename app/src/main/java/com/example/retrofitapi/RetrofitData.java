package com.example.retrofitapi;

import com.google.gson.annotations.SerializedName;

public class RetrofitData {

    private int userId;
    private int id;
    private String title;

    @SerializedName("body") //use this when you change the name of tag from the API by itself---->>
    private String subTitle;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
