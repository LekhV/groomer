package com.example.lekh.grommer.Navigator.FragmentNovosti;

import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelListNovosti {

    @SerializedName("news")
    @Expose
    private List<ModelNovosti> news = null;

    public List<ModelNovosti> getNews() {
        return news;
    }

    public void setNews(List<ModelNovosti> news) {
        this.news = news;
    }
}
