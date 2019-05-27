package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.grommer.MainActivity;
import com.example.lekh.grommer.R;
import com.facebook.drawee.backends.pipeline.Fresco;

public class ActivityDetailsProductNew extends AppCompatActivity {
    private ImageView imageEllipse;
    private ImageView imageViewpluss;
    private ImageView imageViewforma_one;
    private ImageView imageViewWeeklyMenu;
    private TextView textViewOnS;
    private TextView textView8;
    private TextView textView9;
    private String productIdIdTab;
    private  Bundle bundle;

    private ImageView imageViewkorztool11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_details_product_new);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        setTitle("");
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Все о товаре"));
        tabLayout.addTab(tabLayout.newTab().setText("Описание"));
        //tabLayout.addTab(tabLayout.newTab().setText("Фотографии"));
        tabLayout.addTab(tabLayout.newTab().setText("Покупают вместе с..."));
        tabLayout.addTab(tabLayout.newTab().setText("Похожие товары"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        textView8 = findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dial = "tel:" + "0676160038";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        });

        textView9 = findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dial = "tel:" + "0736160038 ";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        });

        Intent intent = getIntent();
        productIdIdTab = intent.getStringExtra("productIdId");

        bundle = new Bundle();
        bundle.putString("productIdIdTab", productIdIdTab);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapterScreen adapter = new PagerAdapterScreen
                (getSupportFragmentManager(), tabLayout.getTabCount(),bundle);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

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

        textViewOnS = findViewById(R.id.textViewOnS);
        textViewOnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://m.groomer.com.ua"));
                startActivity(browserIntent);
            }
        });
        imageViewWeeklyMenu = findViewById(R.id.imageViewWeeklyMenu);
        imageViewWeeklyMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://m.groomer.com.ua"));
                startActivity(browserIntent);
            }
        });

        imageViewkorztool11 = findViewById(R.id.imageViewkorztool11);
        imageViewkorztool11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(ActivityDetailsProductNew.this, MainActivity.class);
                intentKat.putExtra("prov","1");
                startActivity(intentKat);
            }
        });
    }

}
