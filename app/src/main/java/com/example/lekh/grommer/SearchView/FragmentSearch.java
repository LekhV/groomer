package com.example.lekh.grommer.SearchView;

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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lekh.grommer.MainActivity;
import com.example.lekh.grommer.Navigator.Category.Products.AdapterProducts;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.ActivityDetailProducts;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ActivityDetailsProductNew;
import com.example.lekh.grommer.Navigator.Category.Products.ModelListProducts;
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.Navigator.FragmentHome.AdapterHomeLids;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSearch extends Fragment {
    private  boolean isUpdate;

    private String query ;
    private String productIdId;
    private String nameProductDetail;
    private List<ModelProduct> mModelProduct;
    private AdapterProducts mAdapter;
    private LinearLayoutManager layoutManager1;
    private RecyclerView recyclerView;
    private List<ModelListProducts> mModelListProducts;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_fragment_search, container, false);
        View retView = inflater.inflate(R.layout.fragment_fragment_search, container, false);

        mModelProduct = new ArrayList<>();
        mModelListProducts = new ArrayList<>();
        recyclerView = retView.findViewById(R.id.recyclerViewSearch);


        query=getArguments().getString("message");
        Toast.makeText(getContext(), "Вы ищете " + query, Toast.LENGTH_LONG).show();
        userGetProductSearch(query);
        return retView;
    }

    private void userGetProductSearch(String queryS) {
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProdSearch(query)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts modelListProductsList = response.body();

                            modelListProductsList.getProductTotal();

                            final int pageN = Integer.parseInt(modelListProductsList.getProductTotal());
                            if (pageN == 0){
                                Toast.makeText(getContext(), "По Вашему запросу ничего не найдено!", Toast.LENGTH_LONG).show();
                            }

                            mModelProduct.size();
                            mModelProduct = modelListProductsList.getProducts();
                            mAdapter = new AdapterProducts(getContext(),mModelProduct,Glide.with(getContext())) {
                                @Override
                                public void onItemClickimageViewProd(ModelProduct view, int position) {

                                    productIdId = mModelProduct.get(position).getProductId();
                                    nameProductDetail = mModelProduct.get(position).getName();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameProductDetail);
                                    startActivity(intentKat);


                                }

                                @Override
                                public void onItemClickimageViewProdN(ModelProduct view, int position) {

                                }

                                @Override
                                public void onItemClickimageViewProdDet(ModelProduct view, int position) {

                                }

                            };

                            layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(layoutManager1);

                            recyclerView.setAdapter(mAdapter);

                            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                .getIdProdSearch(query,page)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts mModelProductAdd = response.body();
                            mModelProduct.addAll(response.body().getProducts());
                            mModelProduct.size();
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
