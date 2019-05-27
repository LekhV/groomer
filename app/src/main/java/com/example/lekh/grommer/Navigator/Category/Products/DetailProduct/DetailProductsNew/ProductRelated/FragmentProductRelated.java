package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductRelated;

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
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ActivityDetailsProductNew;
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

public class FragmentProductRelated extends Fragment {

    private List<ModelProductSimilar> mModelProductSimilar;
    private List<ModelListProductSimilar> mModelListProductSimilar;
    private ModelProductSimilar modelProductSimilar;
    private AdapterProductSimilar mAdapter;
    private RecyclerView imageGridView;
    private GridLayoutManager gridLayoutManager;
    private String productIdIdTab;
    private String productIdId;

    public FragmentProductRelated() {
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
       // return inflater.inflate(R.layout.fragment_product_related, container, false);

        View retView = inflater.inflate(R.layout.fragment_product_related, container, false);
        productIdIdTab = getArguments().getString("productIdIdTab");
        mModelProductSimilar = new ArrayList<>();
        modelProductSimilar = new ModelProductSimilar();
        mModelListProductSimilar = new ArrayList<>();

        imageGridView = retView.findViewById(R.id.recyclerViewResProductRelated);
        userGetProductRelate();
        return retView;


    }

    private void userGetProductRelate() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetProductRelate(productIdIdTab)
                .enqueue(new Callback<ModelListProductSimilar>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProductSimilar> call,
                                           @NonNull Response<ModelListProductSimilar> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProductSimilar modelListNovosti = response.body();

                            mModelProductSimilar.size();
                            mModelProductSimilar = modelListNovosti.getProducts();
                            mAdapter = new AdapterProductSimilar(getContext(),Glide.with(getContext()),mModelProductSimilar) {

                                @Override
                                public void onItemClickimageViewProductSimilar(ModelProductSimilar view, int position) {
                                    productIdId = mModelProductSimilar.get(position).getProductId();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);

                                    startActivity(intentKat);
                                }

                                @Override
                                public void onItemClickimageViewProductSimilarName(ModelProductSimilar view, int position) {
                                    productIdId = mModelProductSimilar.get(position).getProductId();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);

                                    startActivity(intentKat);
                                }
                            };
                            gridLayoutManager = new GridLayoutManager(getContext(), 2);
                            imageGridView.setLayoutManager(gridLayoutManager);
                            imageGridView.setAdapter(mAdapter);

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ModelListProductSimilar> call, @NonNull Throwable t) {

                    }
                });

    }

}