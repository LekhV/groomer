package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.AllHar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lekh.grommer.MainActivity;
import com.example.lekh.grommer.Navigator.Category.PodCategory.ActivityPodCategory;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ActivityDetailsProductNew;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Photos.ActivityPfoto;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Photos.AdapterPhotos;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.ModelProductSimilar;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.ModeProductDetail;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentInformDetail.ActivitySkidka;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentALLHar extends Fragment {
  //  private WebView textViewFulldescriptionWeb;
    private String htmlText;
    private ImageView imageViewProod;

    private TextView textViewPrice;
    private TextView textViewNamePrice;
    private TextView textViewСode;
    private TextView textViewShortname;
    private TextView textViewManufacturer;
  //  private TextView textViewModel;
    private TextView textViewSpecial;
    private TextView textViewDescription;
    private TextView textViewFulldescription;
    private TextView textViewSk1;
    private TextView textViewSk2;
    private TextView textViewSk3;

    private  String  imageViewProodString;
    private  String  imageViewProodString2;
    private  String  textViewPriceString;
    private  String  textViewNamePriceString;
    private  String  textViewСodeString;
    private  String  textViewShortnameString;
    private  String  textViewManufacturerString;
  //  private  String  textViewModelString;
    private  String  textViewSpecialString;
    private  String  textViewDescriptionString;
   // private  String  textViewFulldescriptionString;


    private  String  productIdId;
    private  String  nameProductDetail;

    private ModeProductDetail modeProductDetail;
    private String productIdIdTab;

    private Button buttonVKor;

    private List<ModelProductSimilar> mModelProductSimilar;
    private List<ModelProductSimilar.Image> imageList;
    private AdapterPhotos mAdapter;
    private RecyclerView imageGridView;
    private LinearLayoutManager gridLayoutManager;
    public FragmentALLHar() {
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
      //  return inflater.inflate(R.layout.fragment_fragment_allhar, container, false);
        View retView = inflater.inflate(R.layout.fragment_fragment_allhar, container, false);
        productIdIdTab = getArguments().getString("productIdIdTab");
        imageViewProod = retView.findViewById(R.id.imageViewProodNew);

        buttonVKor = retView.findViewById(R.id.buttonVKor);
        buttonVKor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), MainActivity.class);
                intentKat.putExtra("prov","1");
                startActivity(intentKat);
            }
        });

        textViewPrice = retView.findViewById(R.id.textViewPriceNew);
        textViewNamePrice = retView.findViewById(R.id.textViewNamePriceNew);

        textViewСode = retView.findViewById(R.id.textViewСodeNew);
        textViewShortname = retView.findViewById(R.id.textViewShortnameNew);
        textViewManufacturer = retView.findViewById(R.id.textViewManufacturerNew);
      //  textViewModel = retView.findViewById(R.id.textViewModelNew);
        textViewSpecial = retView.findViewById(R.id.textViewSpecialNew);
        textViewDescription = retView.findViewById(R.id.textViewDescriptionNew);
        textViewSk1 = retView.findViewById(R.id.textViewSk1);
        textViewSk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivitySkidka.class);
                startActivity(intentKat);
            }
        });
        textViewSk2 = retView.findViewById(R.id.textViewSk2);
        textViewSk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivitySkidka.class);
                startActivity(intentKat);
            }
        });
        textViewSk3 = retView.findViewById(R.id.textViewSk3);
        textViewSk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivitySkidka.class);
                startActivity(intentKat);
            }
        });
        //textViewFulldescriptionWeb = retView.findViewById(R.id.textContentNew);

        productIdId ="3740";
                nameProductDetail = "000";
        htmlText =  "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "</head><body>";
        userGetProductDetail();
        mModelProductSimilar = new ArrayList<>();

        imageGridView = retView.findViewById(R.id.recyclerViewResProductPfoto);
        userGetProductRelate();
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

                            textViewPriceString = modelListProductsList.getPrice();
                            textViewPrice.setText(textViewPriceString);

                            textViewNamePriceString = modelListProductsList.getName();
                            textViewNamePrice.setText(textViewNamePriceString);

                            textViewСodeString = modelListProductsList.getProductId();
                            textViewСode.setText(textViewСodeString);

                            textViewShortnameString = modelListProductsList.getSku();
                            textViewShortname.setText(textViewShortnameString);

                            textViewManufacturerString = modelListProductsList.getManufacturer();
                            textViewManufacturer.setText(textViewManufacturerString);

                          //  textViewModelString = modelListProductsList.getModel();
                          //  textViewModel.setText(textViewModelString);

                             textViewSpecialString = modelListProductsList.getSpecial();
                             if(textViewSpecialString.equals("false")) {
                                 textViewSpecial.setVisibility(View.GONE);
                                 textViewPriceString = modelListProductsList.getPrice();
                                 textViewPrice.setText(textViewPriceString);
                             }else{
                                 textViewSpecial.setVisibility(View.VISIBLE);
                                 textViewSpecial.setText(textViewSpecialString);
                                 textViewPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                             }
                            textViewDescriptionString = modelListProductsList.getDescription();
                            textViewDescription.setText(textViewDescriptionString);



                          //  textViewFulldescriptionString = modelListProductsList.getFulldescription();
                          //  htmlText += textViewFulldescriptionString + "</body></html>";
                            //textViewFulldescriptionWeb.loadData(htmlText, "text/html; charset=UTF-8", null);

                           // textViewOutOfStockString = modelListProductsList.getOutOfStock();
                           // textViewOutOfStock.setText(textViewOutOfStockString);

                            imageViewProodString = modelListProductsList.getImage();
                            Glide.with(getActivity())
                                    .load(imageViewProodString)
                                    .apply(RequestOptions.centerCropTransform())
                                    .into(imageViewProod);

                            imageViewProod.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intentKat = new Intent(getContext(), ActivityPfoto.class);
                                    intentKat.putExtra("imageViewProodString",imageViewProodString);
                                    startActivity(intentKat);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ModeProductDetail> call, @NonNull Throwable t) {

                    }
                });
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

                             mModelProductSimilar.size();
                            // mModelProductSimilar = modelListNovosti.getProducts();
                            imageList = modelListProductSimilar.getImages();
                            mAdapter = new AdapterPhotos(getContext(),Glide.with(getContext()),imageList) {

                                @Override
                                public void onItemClickimageViewPhotos(ModelProductSimilar.Image view, int position) {
                                    imageViewProodString2 = imageList.get(position).getBig();
                                    Intent intentKat = new Intent(getContext(), ActivityPfoto.class);
                                    intentKat.putExtra("imageViewProodString",imageViewProodString2);
                                    startActivity(intentKat);
                                }

                            };
                            gridLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
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