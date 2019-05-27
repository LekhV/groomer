package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Photos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.lekh.grommer.R;

import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

public class ActivityPfoto extends AppCompatActivity {

    private PhotoDraweeView mPhotoDraweeView;
    private String imageViewProodString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfoto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        setSupportActionBar(toolbar); // работает кнопка назад вместо home
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        Intent intent = getIntent();
        imageViewProodString = intent.getStringExtra("imageViewProodString");

        mPhotoDraweeView = findViewById(R.id.photo_drawee_view);
        mPhotoDraweeView.setPhotoUri(Uri.parse(imageViewProodString));
        mPhotoDraweeView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override public void onPhotoTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onPhotoTap :  x =  " + x + ";" + " y = " + y,
                        Toast.LENGTH_SHORT).show();
            }
        });
        mPhotoDraweeView.setOnViewTapListener(new OnViewTapListener() {
            @Override public void onViewTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onViewTap", Toast.LENGTH_SHORT).show();
            }
        });

        mPhotoDraweeView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "onLongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
