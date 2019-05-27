package com.example.lekh.grommer.Navigator.Category.Products;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lekh.grommer.MainActivity;
import com.example.lekh.grommer.Navigator.Category.PodCategory.ActivityPodCategory;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.ActivityDetailProducts;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ActivityDetailsProductNew;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityProducts extends AppCompatActivity {

    private int page = 2, threshold = 0;
    private  boolean isUpdate;
    private ImageView imageViewkorztool;
    private String catrgotyId;
    private String name;
    private String productIdId;
    private String nameProductDetail;
    private List<ModelProduct> mModelProduct;
    private List<ModelListProducts> mModelListProducts;
    private String pageNo = "2";
    private AdapterProducts mAdapter;
    private RecyclerView imageGridView;

    private GridLayoutManager gridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Intent intent = getIntent();
        catrgotyId = intent.getStringExtra("catrgotyId");
        name = intent.getStringExtra("nameP");

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        setTitle(name);
        toolbar1.setTitleTextColor(Color.WHITE);

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


        mModelProduct = new ArrayList<>();
        mModelListProducts = new ArrayList<>();

        imageGridView = findViewById(R.id.recyclerViewResProd);
        imageViewkorztool = findViewById(R.id.imageViewkorztool);
        imageViewkorztool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(ActivityProducts.this, MainActivity.class);
                intentKat.putExtra("prov","1");
                startActivity(intentKat);
            }
        });
        userGetProduct();
    }

    private void userGetProduct() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProd(catrgotyId)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                           ModelListProducts modelListProductsList = response.body();

                            modelListProductsList.getProductTotal();
                            final int pageN = Integer.parseInt(modelListProductsList.getProductTotal());
                            mModelProduct.size();
                            mModelProduct = modelListProductsList.getProducts();
                            mAdapter = new AdapterProducts(ActivityProducts.this,mModelProduct,Glide.with(ActivityProducts.this)) {
                                @Override
                                public void onItemClickimageViewProd(ModelProduct view, int position) {
                                    productIdId = mModelProduct.get(position).getProductId();
                                    nameProductDetail = mModelProduct.get(position).getName();
                                    Intent intentKat = new Intent(ActivityProducts.this, ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameProductDetail);
                                    startActivity(intentKat);
                                }

                                @Override
                                public void onItemClickimageViewProdN(ModelProduct view, int position) {
                                    productIdId = mModelProduct.get(position).getProductId();
                                    nameProductDetail = mModelProduct.get(position).getName();
                                    Intent intentKat = new Intent(ActivityProducts.this, ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameProductDetail);
                                    startActivity(intentKat);
                                }

                                @Override
                                public void onItemClickimageViewProdDet(ModelProduct view, int position) {
                                    productIdId = mModelProduct.get(position).getProductId();
                                    nameProductDetail = mModelProduct.get(position).getName();
                                    Intent intentKat = new Intent(ActivityProducts.this, ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameProductDetail);
                                    startActivity(intentKat);
                                }

                            };
                            gridLayoutManager = new GridLayoutManager(ActivityProducts.this, 1);
                            imageGridView.setLayoutManager(gridLayoutManager);
                            imageGridView.setAdapter(mAdapter);

                            imageGridView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                @Override
                                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                                    int first = gridLayoutManager.findFirstVisibleItemPosition();
                                    int last2 = gridLayoutManager.findLastVisibleItemPosition();
                                    int count = recyclerView.getChildCount();
                                    int adapt = mAdapter.getItemCount();

                                    if (newState == RecyclerView.SCROLL_STATE_IDLE
                                            && ( adapt <= pageN )
                                            && (pageN/20 > 1)){
                                         //  &&(last2 <= pageN)) {
                                            //&&(first + count >= adapt - threshold)
                                            //&& !isUpdate) {
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
                .getIdProd(catrgotyId,page)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts mModelProductAdd = response.body();
               // if (mModelProduct.size()<= Integer.parseInt(mModelProductAdd.getProductTotal())) {
                            mModelProduct.addAll(response.body().getProducts());
                            mModelProduct.size();
                        //   mModelProductAdd.getProductTotal();
                            mAdapter.notifyDataSetChanged();
                              //  }else
                           // isUpdate = true;
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<ModelListProducts> call, @NonNull Throwable t) {
                        isUpdate = false;
                    }
                });

    }
}
