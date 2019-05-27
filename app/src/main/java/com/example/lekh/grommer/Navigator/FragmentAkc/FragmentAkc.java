package com.example.lekh.grommer.Navigator.FragmentAkc;

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
import com.example.lekh.grommer.Navigator.FragmentNovosti.AdapterNovosti;
import com.example.lekh.grommer.Navigator.FragmentNovosti.ModelListNovosti;
import com.example.lekh.grommer.Navigator.FragmentNovosti.ModelNovosti;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentAkc extends Fragment {
    private List<ModelAkcii> mModelAkcii;
    private List<ModelAkciiList> mModelAkciiList;
    private ModelAkcii modelAkcii;
    private AdapterAkcii mAdapter;
    private RecyclerView imageGridView;
    private GridLayoutManager gridLayoutManager;

    public FragmentAkc() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // return inflater.inflate(R.layout.item_akcii_very, container, false);
        View retView = inflater.inflate(R.layout.item_akcii_very, container, false);

        mModelAkcii = new ArrayList<>();
        modelAkcii = new ModelAkcii();
        mModelAkciiList = new ArrayList<>();

        imageGridView = retView.findViewById(R.id.recyclerViewResAkcii);
        userGetAkcii();
        return retView;
    }

    private void userGetAkcii() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetAkcii()
                .enqueue(new Callback<ModelAkciiList>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelAkciiList> call,
                                           @NonNull Response<ModelAkciiList> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelAkciiList modelAkciiList = response.body();

                            mModelAkcii.size();
                            mModelAkcii = modelAkciiList.getActions();
                            mAdapter = new AdapterAkcii(getContext(),Glide.with(getContext()),mModelAkcii) {
                                @Override
                                public void onItemClickimageViewAkcii(ModelAkcii view, int position) {
                                }
                            };
                            gridLayoutManager = new GridLayoutManager(getContext(), 1);
                            imageGridView.setLayoutManager(gridLayoutManager);
                            imageGridView.setAdapter(mAdapter);

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ModelAkciiList> call, @NonNull Throwable t) {

                    }
                });

    }

}
