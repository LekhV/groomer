package com.example.lekh.grommer.Navigator.FragmentAkcTov;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ActivityDetailsProductNew;
import com.example.lekh.grommer.Navigator.Category.Products.ModelListProducts;
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.Navigator.FragmentHome.AdapterLidersBig;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentAkcTov extends Fragment {

    private  boolean isUpdate;

    private String productIdId;
    private String nameAkcTovDetail;
    private List<ModelProduct> mModelProductAkcTov;
    private List<ModelListProducts> mModelListProductsAkcTov;
    private AdapterLidersBig mAdapter;

    private LinearLayoutManager layoutManager1;
    private RecyclerView recyclerViewAkcTov;

    public FragmentAkcTov() {
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
      //  return inflater.inflate(R.layout.fragment_fragment_akc_tov, container, false);

        View retView = inflater.inflate(R.layout.fragment_fragment_akc_tov, container, false);

        mModelProductAkcTov = new ArrayList<>();
        mModelListProductsAkcTov = new ArrayList<>();
        recyclerViewAkcTov = retView.findViewById(R.id.recyclerViewResAkciTov);
        userGetProductAkcTov();

        return retView;
    }
    private void userGetProductAkcTov() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProdLid("action")
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts modelListProductsList = response.body();

                            modelListProductsList.getProductTotal();
                            final int pageN = Integer.parseInt(modelListProductsList.getProductTotal());
                            mModelProductAkcTov.size();
                            mModelProductAkcTov = modelListProductsList.getProducts();
                            mAdapter = new AdapterLidersBig(getContext(), Glide.with(getContext()),mModelProductAkcTov) {
                                @Override
                                public void onItemClickimageViewLidss(ModelProduct view, int position) {
                                    productIdId = mModelProductAkcTov.get(position).getProductId();
                                    nameAkcTovDetail = mModelProductAkcTov.get(position).getName();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameAkcTovDetail);
                                    startActivity(intentKat);
                                }

                                @Override
                                public void onItemClickimageViewCatNLidss(ModelProduct view, int position) {

                                }


                            };

                            layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                            recyclerViewAkcTov.setLayoutManager(layoutManager1);

                            recyclerViewAkcTov.setAdapter(mAdapter);

                            recyclerViewAkcTov.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                @Override
                                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                                    int first = layoutManager1.findFirstVisibleItemPosition();
                                    int last2 = layoutManager1.findLastVisibleItemPosition();
                                    int count = recyclerView.getChildCount();
                                    int adapt = mAdapter.getItemCount();
                                    if (newState == RecyclerView.SCROLL_STATE_IDLE
                                            && ( adapt <= pageN )
                                            && (pageN/20 > 1)){
                                        int ost = adapt%20;
                                        int pS =  (adapt/20) - ost + 2 ;
                                        String pSString = String.valueOf(pS);
                                        getNextPage(pSString);
                                        isUpdate = true;
                                    }
                                    super.onScrollStateChanged(recyclerView, newState);
                                }

                                @Override
                                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                                    super.onScrolled(recyclerView, dx, dy);
                                }
                            });
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ModelListProducts> call, @NonNull Throwable t) {

                    }
                });
    }

    private void getNextPage(String pageS) {
        String page = pageS;
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProdLid("action",page)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts mModelProductAdd = response.body();
                            mModelProductAkcTov.addAll(response.body().getProducts());
                            mModelProductAkcTov.size();
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ModelListProducts> call, @NonNull Throwable t) {
                        isUpdate = false;
                    }
                });

    }

}

