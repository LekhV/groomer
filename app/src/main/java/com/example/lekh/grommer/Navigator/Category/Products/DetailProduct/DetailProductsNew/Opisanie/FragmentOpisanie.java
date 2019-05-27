package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Opisanie;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.ModeProductDetail;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOpisanie extends Fragment {

    private WebView textViewFulldescriptionWeb;
    private String htmlText;
    private  String  textViewFulldescriptionString;
    private String productIdIdTab;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_opisanie, container, false);
        View retView = inflater.inflate(R.layout.fragment_fragment_opisanie, container, false);
        productIdIdTab = getArguments().getString("productIdIdTab");
        textViewFulldescriptionWeb = retView.findViewById(R.id.textContentNewFull);

        htmlText =  "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "</head><body>";

        userGetProductDetail();
        return retView;

    }
    private void userGetProductDetail() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetProductDetail(productIdIdTab)
                .enqueue(new Callback<ModeProductDetail>() {
                    @Override
                    public void onResponse(@NonNull Call<ModeProductDetail> call,
                                           @NonNull Response<ModeProductDetail> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModeProductDetail modelListProductsList = response.body();

                            textViewFulldescriptionString = modelListProductsList.getFulldescription();
                            if (textViewFulldescriptionString.equals("")){
                                htmlText += " Описание временно отсутствует. Приносим свои извинения! " + "</body></html>";
                                textViewFulldescriptionWeb.loadData(htmlText, "text/html; charset=UTF-8", null);
                            }else
                            // textViewFulldescription.setText(textViewFulldescriptionString);

                            htmlText += textViewFulldescriptionString + "</body></html>";
                            textViewFulldescriptionWeb.loadData(htmlText, "text/html; charset=UTF-8", null);
                            // textViewFulldescriptionWeb.loadUrl("http://developer.alexanderklimov.ru/android");
                            //  textViewSkuString = modelListProductsList.getSku();
                            // textViewSku.setText(textViewSkuString);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ModeProductDetail> call, @NonNull Throwable t) {

                    }
                });
    }

}
