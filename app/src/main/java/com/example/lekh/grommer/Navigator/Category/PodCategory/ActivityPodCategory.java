package com.example.lekh.grommer.Navigator.Category.PodCategory;

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
import com.example.lekh.grommer.Navigator.Category.ModelCategory;
import com.example.lekh.grommer.Navigator.Category.Products.ActivityProducts;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPodCategory extends AppCompatActivity {

    private String parentId;
    private String catrgotyId;
    private String   name ;
    private List<ModelCategory> mModelCategory;
    private AdapterPodCategory mAdapter;
    ModelCategory modelCategory;

    private ImageView imageViewkorztool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pod_category);
        Intent intent = getIntent();
        parentId = intent.getStringExtra("parentId");
        name = intent.getStringExtra("name");

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

        imageViewkorztool = findViewById(R.id.imageViewkorztool);
        imageViewkorztool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(ActivityPodCategory.this, MainActivity.class);
                intentKat.putExtra("prov","1");
                startActivity(intentKat);
            }
        });

        mModelCategory = new ArrayList<>();
        modelCategory = new ModelCategory();
        RecyclerView imageGridView = findViewById(R.id.recyclerViewResPodCat);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ActivityPodCategory.this, 2);
        imageGridView.setLayoutManager(gridLayoutManager);

        mAdapter = new AdapterPodCategory(ActivityPodCategory.this, mModelCategory, Glide.with(this)) {
            @Override
            public void onItemClickimageViewPod(ModelCategory view, int position) {
                catrgotyId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(ActivityPodCategory.this, ActivityProducts.class);
                intentKat.putExtra("catrgotyId",catrgotyId);
                intentKat.putExtra("nameP",name);
                startActivity(intentKat);
            }

            @Override
            public void onItemClickimageViewCatN(ModelCategory view, int position) {
                catrgotyId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(ActivityPodCategory.this, ActivityProducts.class);
                intentKat.putExtra("catrgotyId",catrgotyId);
                intentKat.putExtra("nameP",name);
                startActivity(intentKat);
            }


        };
        imageGridView.setAdapter(mAdapter);

        userGetCategory();
    }

    private void userGetCategory() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetCategory()
                .enqueue(new Callback<List<ModelCategory>>() {
                    @Override
                    public void onResponse(@NonNull Call <List<ModelCategory>> call,
                                           @NonNull Response<List<ModelCategory>>response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<ModelCategory> modelCategoryList = response.body();

                            modelCategoryList.size();
                            for (int i = 0; i < modelCategoryList.size(); i++) {
                                modelCategory = response.body().get(i);
                                if (modelCategory.getParentId().equals( parentId )){

                                    modelCategoryList.get(i).getCategoryId();
                                    mModelCategory.add(modelCategory);
                                    mAdapter.notifyDataSetChanged();

                                }}
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<ModelCategory>> call, @NonNull Throwable t) {

                    }
                });
    }

}
