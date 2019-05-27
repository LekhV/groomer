package com.example.lekh.grommer.Retrofit;

import android.app.Application;

import com.example.lekh.grommer.Interface.ApiCategory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCategory extends Application {

    public static final String BASE_URL = "https://groomer.com.ua/";
    private static RetrofitCategory sInstanceCat;
    private Retrofit mRetrofitCat;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstanceCat = this;
    }

    private RetrofitCategory() {

        mRetrofitCat = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitCategory getInstance() {
        if (sInstanceCat == null) {
            sInstanceCat = new RetrofitCategory();
        }
        return sInstanceCat;
    }

    public ApiCategory getApi() {
        return mRetrofitCat.create(ApiCategory.class);
    }
}

