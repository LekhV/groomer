package com.example.lekh.grommer.Navigator.Category;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lekh.grommer.Navigator.Category.PodCategory.ActivityPodCategory;
import com.example.lekh.grommer.Navigator.FragmentNovosti.ModelListNovosti;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCategory extends Fragment {

    private List<ModelCategory> mModelCategory;
    private List<ModelListNovosti> mModelListNovosti;
    private ModelCategory modelCategory;
    private AdapterCategory mAdapter;
    private String parentId;
    private String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.activity_category, container, false);
        //return inflater.inflate(R.layout.activity_category, container, false);


        mModelCategory = new ArrayList<>();
        modelCategory = new ModelCategory();

        userGetCategory();

        RecyclerView imageGridView = retView.findViewById(R.id.recyclerViewResCat);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        imageGridView.setLayoutManager(gridLayoutManager);

        mAdapter = new AdapterCategory(getContext(), mModelCategory, Glide.with(this)) {

            @Override
            public void onItemClickimageViewCat(ModelCategory view, int position) {
                parentId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId",parentId);
                intentKat.putExtra("name",name);
                startActivity(intentKat);
            }

            @Override
            public void onItemClickimageViewCatN(ModelCategory view, int position) {
                parentId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId",parentId);
                intentKat.putExtra("name",name);
                startActivity(intentKat);
            }

        };
        imageGridView.setAdapter(mAdapter);
        return retView;

    }
  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        setTitle("Категории товаров");
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


        mModelCategory = new ArrayList<>();
        modelCategory = new ModelCategory();

        userGetCategory();

        RecyclerView imageGridView = findViewById(R.id.recyclerViewResCat);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ActivityCategory.this, 1);
        imageGridView.setLayoutManager(gridLayoutManager);

        mAdapter = new AdapterCategory(ActivityCategory.this, mModelCategory, Glide.with(this)) {

            @Override
            public void onItemClickimageViewCat(ModelCategory view, int position) {
                parentId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(ActivityCategory.this, ActivityPodCategory.class);
                intentKat.putExtra("parentId",parentId);
                intentKat.putExtra("name",name);
                startActivity(intentKat);
            }

            @Override
            public void onItemClickimageViewCatN(ModelCategory view, int position) {
                parentId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(ActivityCategory.this, ActivityPodCategory.class);
                intentKat.putExtra("parentId",parentId);
                intentKat.putExtra("name",name);
                startActivity(intentKat);
            }

        };
        imageGridView.setAdapter(mAdapter);

    }*/
 private void userGetCategory() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetCategory()
                .enqueue(new Callback<List<ModelCategory>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<ModelCategory>> call,
                                           @NonNull Response<List<ModelCategory>>response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<ModelCategory> modelCategoryList = response.body();

                            modelCategoryList.size();
                            for (int i = 0; i < modelCategoryList.size(); i++) {
                                modelCategory = response.body().get(i);
                                    if (modelCategory.getParentId().equals( "0" )){

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
