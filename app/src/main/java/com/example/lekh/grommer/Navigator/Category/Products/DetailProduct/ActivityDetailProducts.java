package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class ActivityDetailProducts extends AppCompatActivity {

    private WebView textViewFulldescriptionWeb;
    private String htmlText;
    private ImageView imageViewProod;

    private TextView textViewPrice;
    private TextView textViewNamePrice;
    private TextView textViewСode;
    private TextView textViewShortname;
    private TextView textViewManufacturer;
    private TextView textViewModel;
    private TextView textViewSpecial;
    private TextView textViewDescription;
    private TextView textViewSku;
    private TextView textViewFulldescription;
    private TextView textViewOutOfStock;

    private  String  imageViewProodString;
    private  String  textViewPriceString;
    private  String  textViewNamePriceString;
    private  String  textViewСodeString;
    private  String  textViewShortnameString;
    private  String  textViewManufacturerString;
    private  String  textViewModelString;
    private  String  textViewSpecialString;
    private  String  textViewDescriptionString;
    private  String  textViewSkuString;
    private  String  textViewFulldescriptionString;
    private  String  textViewOutOfStockString;

    private  String  productIdId;
    private  String  nameProductDetail;

    private ModeProductDetail modeProductDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_products);

        imageViewProod = findViewById(R.id.imageViewProod);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewNamePrice = findViewById(R.id.textViewNamePrice);

        textViewСode = findViewById(R.id.textViewСode);
        textViewShortname = findViewById(R.id.textViewShortname);
        textViewManufacturer = findViewById(R.id.textViewManufacturer);
        textViewModel = findViewById(R.id.textViewModel);
        textViewSpecial = findViewById(R.id.textViewSpecial);
        textViewDescription = findViewById(R.id.textViewDescription);
      //  textViewFulldescription = findViewById(R.id.textViewFulldescription);
        textViewOutOfStock = findViewById(R.id.textViewOutOfStock);


        textViewFulldescriptionWeb = findViewById(R.id.textContent);
        //textViewFulldescriptionWeb.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();
        productIdId = intent.getStringExtra("productIdId");
        nameProductDetail = intent.getStringExtra("nameProductDetail");
        modeProductDetail =new ModeProductDetail();
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        setTitle("Категории товаров");
        toolbar1.setTitleTextColor(Color.WHITE);
        htmlText =  "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "</head><body>";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        setSupportActionBar(toolbar1); // работает кнопка назад вместо home
        toolbar1.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
         userGetProductDetail();
    }

    private void userGetProductDetail() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetProductDetail(productIdId)
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

                            textViewСodeString = modelListProductsList.getCode();
                            textViewСode.setText(textViewСodeString);

                            textViewShortnameString = modelListProductsList.getShortname();
                            textViewShortname.setText(textViewShortnameString);

                           textViewManufacturerString = modelListProductsList.getManufacturer();
                            textViewManufacturer.setText(textViewManufacturerString);

                            textViewModelString = modelListProductsList.getModel();
                            textViewModel.setText(textViewModelString);

                           // textViewSpecialString = modelListProductsList.getSpecial();
                            //textViewSpecial.setText(textViewSpecialString);

                            textViewDescriptionString = modelListProductsList.getDescription();
                            textViewDescription.setText(textViewDescriptionString);



                            textViewFulldescriptionString = modelListProductsList.getFulldescription();
                           // textViewFulldescription.setText(textViewFulldescriptionString);

                            htmlText += textViewFulldescriptionString + "</body></html>";
                            textViewFulldescriptionWeb.loadData(htmlText, "text/html; charset=UTF-8", null);
                            // textViewFulldescriptionWeb.loadUrl("http://developer.alexanderklimov.ru/android");
                            //  textViewSkuString = modelListProductsList.getSku();
                            // textViewSku.setText(textViewSkuString);

                            textViewOutOfStockString = modelListProductsList.getOutOfStock();
                            textViewOutOfStock.setText(textViewOutOfStockString);

                            imageViewProodString = modelListProductsList.getImage();
                            Glide.with(ActivityDetailProducts.this)
                                    .load(imageViewProodString)
                                    .apply(RequestOptions.centerCropTransform())
                                    .into(imageViewProod);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ModeProductDetail> call, @NonNull Throwable t) {

                    }
                });
    }
}
