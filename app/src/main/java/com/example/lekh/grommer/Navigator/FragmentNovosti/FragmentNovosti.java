package com.example.lekh.grommer.Navigator.FragmentNovosti;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.lekh.grommer.Navigator.Category.AdapterCategory;
import com.example.lekh.grommer.Navigator.Category.ModelCategory;
import com.example.lekh.grommer.Navigator.Category.PodCategory.ActivityPodCategory;
import com.example.lekh.grommer.Navigator.Category.PodCategory.AdapterPodCategory;
import com.example.lekh.grommer.Navigator.Category.Products.ActivityProducts;
import com.example.lekh.grommer.Navigator.Category.Products.AdapterProducts;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ActivityDetailsProductNew;
import com.example.lekh.grommer.Navigator.Category.Products.ModelListProducts;
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentNovosti extends Fragment {

    private List<ModelNovosti> mModelNovosti;
    private List<ModelListNovosti> mModelListNovosti;
    private ModelNovosti modelNovosti;
    private AdapterNovosti mAdapter;
    private RecyclerView imageGridView;
    private GridLayoutManager gridLayoutManager;
    public FragmentNovosti() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_fragment_novosti, container, false);
        View retView = inflater.inflate(R.layout.fragment_fragment_novosti, container, false);

        mModelNovosti = new ArrayList<>();
        modelNovosti = new ModelNovosti();
        mModelListNovosti = new ArrayList<>();

        imageGridView = retView.findViewById(R.id.recyclerViewResNovosti);
/*
       GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        imageGridView.setLayoutManager(gridLayoutManager);

        mAdapter = new AdapterNovosti(getContext(), Glide.with(this), mModelNovosti ) {
            @Override
            public void onItemClickimageViewNovosti(ModelNovosti view, int position) {

            }

        };
        imageGridView.setAdapter(mAdapter);*/

        userGetNovosti();
        return retView;

    }
    private void userGetNovosti() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetNovosti()
                .enqueue(new Callback<ModelListNovosti>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListNovosti> call,
                                           @NonNull Response<ModelListNovosti> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListNovosti modelListNovosti = response.body();

                            mModelNovosti.size();
                            mModelNovosti = modelListNovosti.getNews();
                            mAdapter = new AdapterNovosti(getContext(),Glide.with(getContext()),mModelNovosti) {
                                @Override
                                public void onItemClickimageViewNovosti(ModelNovosti view, int position) {
                                }
                            };
                            gridLayoutManager = new GridLayoutManager(getContext(), 1);
                            imageGridView.setLayoutManager(gridLayoutManager);
                            imageGridView.setAdapter(mAdapter);

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ModelListNovosti> call, @NonNull Throwable t) {

                    }
                });

    }


}
