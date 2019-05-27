package com.example.lekh.grommer.Navigator.FragmentNovosti;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelNovosti {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("news_id")
    @Expose
    private String newsId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

}
