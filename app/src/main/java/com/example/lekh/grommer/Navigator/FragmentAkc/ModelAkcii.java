package com.example.lekh.grommer.Navigator.FragmentAkc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAkcii {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("action_id")
    @Expose
    private String actionId;
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

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
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
