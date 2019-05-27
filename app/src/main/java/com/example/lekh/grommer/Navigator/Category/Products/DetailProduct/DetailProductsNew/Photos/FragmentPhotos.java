package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Photos;

import android.content.Context;
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
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.AdapterProductSimilar;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.ModelListProductSimilar;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.ModelProductSimilar;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPhotos extends Fragment {

    private List<ModelProductSimilar> mModelProductSimilar;
    private List<ModelProductSimilar.Image> imageList;
    private AdapterPhotos mAdapter;
    private RecyclerView imageGridView;
    private GridLayoutManager gridLayoutManager;
    private String productIdIdTab;
    public FragmentPhotos() {
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
        //return inflater.inflate(R.layout.fragment_fragment_photos, container, false);


        View retView = inflater.inflate(R.layout.fragment_fragment_photos, container, false);
        productIdIdTab = getArguments().getString("productIdIdTab");
        mModelProductSimilar = new ArrayList<>();

        imageGridView = retView.findViewById(R.id.recyclerViewResProductPfoto);
        userGetProductRelate();
        return retView;
    }

    private void userGetProductRelate() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetProductImg(productIdIdTab)
                .enqueue(new Callback<ModelProductSimilar>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelProductSimilar> call,
                                           @NonNull Response<ModelProductSimilar> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelProductSimilar modelListProductSimilar = response.body();

                           // mModelProductSimilar.size();
                          // mModelProductSimilar = modelListNovosti.getProducts();
                            imageList = modelListProductSimilar.getImages();
                            mAdapter = new AdapterPhotos(getContext(),Glide.with(getContext()),imageList) {

                                @Override
                                public void onItemClickimageViewPhotos(ModelProductSimilar.Image view, int position) {

                                }

                            };
                            gridLayoutManager = new GridLayoutManager(getContext(), 2);
                            imageGridView.setLayoutManager(gridLayoutManager);
                            imageGridView.setAdapter(mAdapter);

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ModelProductSimilar> call, @NonNull Throwable t) {

                    }
                });

    }

}