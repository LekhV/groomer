package com.example.lekh.grommer.Navigator.FragmentLiders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.ActivityDetailProducts;
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


public class FragmentLiders extends Fragment {
    private  boolean isUpdate;

    private String productIdId;
    private String nameProductDetail;
    private List<ModelProduct> mModelProductLids;
    private List<ModelListProducts> mModelListProductsLids;
    private AdapterLidersBig mAdapter;

    private LinearLayoutManager layoutManager1;
    private RecyclerView recyclerViewLids;
    public FragmentLiders() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_liders, container, false);

        View retView = inflater.inflate(R.layout.fragment_fragment_liders, container, false);

        mModelProductLids = new ArrayList<>();
        mModelListProductsLids = new ArrayList<>();
        recyclerViewLids = retView.findViewById(R.id.recyclerViewResLidersBig);
        userGetProductLids();

        return retView;
    }
    private void userGetProductLids() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProdLid("bestseller")
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts modelListProductsList = response.body();

                            modelListProductsList.getProductTotal();
                            final int pageN = Integer.parseInt(modelListProductsList.getProductTotal());
                            mModelProductLids.size();
                            mModelProductLids = modelListProductsList.getProducts();
                            mAdapter = new AdapterLidersBig(getContext(),Glide.with(getContext()),mModelProductLids) {
                                @Override
                                public void onItemClickimageViewLidss(ModelProduct view, int position) {
                                    productIdId = mModelProductLids.get(position).getProductId();
                                    nameProductDetail = mModelProductLids.get(position).getName();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameProductDetail);
                                    startActivity(intentKat);
                                }

                                @Override
                                public void onItemClickimageViewCatNLidss(ModelProduct view, int position) {

                                }


                            };

                            layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                            recyclerViewLids.setLayoutManager(layoutManager1);

                            recyclerViewLids.setAdapter(mAdapter);

                            recyclerViewLids.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                .getIdProdLid("bestseller",page)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts mModelProductAdd = response.body();
                            mModelProductLids.addAll(response.body().getProducts());
                            mModelProductLids.size();
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
