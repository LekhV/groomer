package com.example.lekh.grommer;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lekh.grommer.Navigator.Category.ActivityCategory;
import com.example.lekh.grommer.Navigator.Category.CategoryNew.ActivityCategoryNew;
import com.example.lekh.grommer.Navigator.FragmentAkc.FragmentAkc;
import com.example.lekh.grommer.Navigator.FragmentAkcTov.FragmentAkcTov;
import com.example.lekh.grommer.Navigator.FragmentHome.FragmentHome;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentContaks;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentDdos;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentInform;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentOs;
import com.example.lekh.grommer.Navigator.FragmentKorzina.FragmentKorzina;
import com.example.lekh.grommer.Navigator.FragmentLiders.FragmentLiders;
import com.example.lekh.grommer.Navigator.FragmentNovosti.FragmentNovosti;
import com.example.lekh.grommer.SearchView.FragmentSearch;

public class MainActivity extends AppCompatActivity{

    private SearchView searchView;

    private ImageView imageView3K;
    public DrawerLayout dl;//mDrawer
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar toolbar2;
    private String prov = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);

        setSupportActionBar(toolbar);
        setTitle("");
        dl = (DrawerLayout)findViewById(R.id.drawer_layout);  // Найти наш view drawer'а
        t = new ActionBarDrawerToggle(this, dl,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nav_view);// Найти наш view drawer'а
        setupDrawerContent(nv);

        Intent intent = getIntent();
        prov = intent.getStringExtra("prov");

        if (prov == null) {
            FragmentHome fragmentActivityNavigator = new FragmentHome();
            FragmentManager fragmentManager1 = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
            fragmentTransaction1.add(R.id.flContent, fragmentActivityNavigator).commit();
        }else {
            FragmentKorzina fragmentFragmentKorzina2 = new FragmentKorzina();
            FragmentManager fragmentManagerFragmentKorzina2 = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction1FragmentKorzina2 = fragmentManagerFragmentKorzina2.beginTransaction();
            fragmentTransaction1FragmentKorzina2.add(R.id.flContent, fragmentFragmentKorzina2).commit();
        }
        searchView =  findViewById(R.id.searchView);
        searchView.getQuery();
        // searchView.getQuery();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
              //  Toast.makeText(MainActivity.this, query, Toast.LENGTH_LONG).show();

                Bundle bundle=new Bundle();

                bundle.putString("message", query);
                //set Fragmentclass Arguments
              //  FragmentSearch fragobj=new FragmentSearch();
                FragmentSearch fragmentFragmentSearchFragment = new FragmentSearch();
                FragmentManager fragmentManagerFragmentSearchFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentSearchFragment = fragmentManagerFragmentSearchFragment.beginTransaction();
                fragmentTransactionFragmentSearchFragment.replace(R.id.flContent, fragmentFragmentSearchFragment);
                fragmentTransactionFragmentSearchFragment.commit();
                fragmentFragmentSearchFragment.setArguments(bundle);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        imageView3K = findViewById(R.id.imageView3K);
        imageView3K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentKorzina fragmentFragmentFragmentKorzina3 = new FragmentKorzina();
                FragmentManager fragmentManagerFragmentFragmentKorzina3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentFragmentKorzina3 = fragmentManagerFragmentFragmentKorzina3.beginTransaction();
                fragmentTransactionFragmentFragmentKorzina3.replace(R.id.flContent, fragmentFragmentFragmentKorzina3);
                fragmentTransactionFragmentFragmentKorzina3.commit();
            }
        });



    }
    public void selectDrawerItem(MenuItem menuItem) {
        // Создать новый фрагмент и задать фрагмент для отображения
        // на основе нажатия на элемент навигации

        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {



            case R.id.nav_Gl:
                // fragmentClass = ActivityFeedFragment.class;

                FragmentHome fragmentActivityFeedFragment = new FragmentHome();
              //  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerActivityFeedFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionActivityFeedFragment = fragmentManagerActivityFeedFragment.beginTransaction();
                fragmentTransactionActivityFeedFragment.replace(R.id.flContent, fragmentActivityFeedFragment);
                fragmentTransactionActivityFeedFragment.commit();

                break;

            case R.id.nav_Kat:

             //   Intent intentKat = new Intent(MainActivity.this, ActivityCategory.class);
               // startActivity(intentKat);

              //  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                ActivityCategoryNew fragmentBusinessesFragment = new ActivityCategoryNew();
                FragmentManager fragmentManagerBusinessesFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesFragment = fragmentManagerBusinessesFragment.beginTransaction();
                fragmentTransactionBusinessesFragment.replace(R.id.flContent, fragmentBusinessesFragment);
                fragmentTransactionBusinessesFragment.commit();

                // fragmentClass = BusinessesFragment.class;

                break;

            case R.id.nav_AkcTov:

                FragmentAkcTov fragmentFragmentAkcTov = new FragmentAkcTov();
                FragmentManager fragmentManagerFragmentAkcTov = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentAkcTov = fragmentManagerFragmentAkcTov.beginTransaction();
                fragmentTransactionFragmentAkcTov.replace(R.id.flContent, fragmentFragmentAkcTov);
                fragmentTransactionFragmentAkcTov.commit();

                break;

            case R.id.nav_Lid:

                FragmentLiders fragmentLidersFragment = new FragmentLiders();
                FragmentManager fragmentManagerLidersFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionLidersFragment = fragmentManagerLidersFragment.beginTransaction();
                fragmentTransactionLidersFragment.replace(R.id.flContent, fragmentLidersFragment);
                fragmentTransactionLidersFragment.commit();

                break;
            case R.id.nav_Ak:
                //fragmentClass = MessengerFragment.class;
       //    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentAkc fragmentMessengerFragment = new FragmentAkc();
                FragmentManager fragmentManagerMessengerFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionMessengerFragment = fragmentManagerMessengerFragment.beginTransaction();
                fragmentTransactionMessengerFragment.replace(R.id.flContent, fragmentMessengerFragment);
                fragmentTransactionMessengerFragment.commit();
                break;
            case R.id.nav_manageNew:
                // fragmentClass = EventsFragment.class;
            //  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentNovosti fragmentEventsFragment = new FragmentNovosti();
                FragmentManager fragmentManagerEventsFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionEventsFragment = fragmentManagerEventsFragment.beginTransaction();
                fragmentTransactionEventsFragment.replace(R.id.flContent, fragmentEventsFragment);
                fragmentTransactionEventsFragment.commit();
                break;
            case R.id.nav_manageKor:

                FragmentKorzina fragmentFragmentFragmentKorzina = new FragmentKorzina();
                FragmentManager fragmentManagerFragmentFragmentKorzina = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentFragmentKorzina = fragmentManagerFragmentFragmentKorzina.beginTransaction();
                fragmentTransactionFragmentFragmentKorzina.replace(R.id.flContent, fragmentFragmentFragmentKorzina);
                fragmentTransactionFragmentFragmentKorzina.commit();
                break;
            case R.id.nav_Inf:
                //fragmentClass = NotificationsFragment.class;
              //  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentInform fragmentNotificationsFragment = new FragmentInform();
                FragmentManager fragmentManagerNotificationsFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionNotificationsFragment = fragmentManagerNotificationsFragment.beginTransaction();
                fragmentTransactionNotificationsFragment.replace(R.id.flContent, fragmentNotificationsFragment);
                fragmentTransactionNotificationsFragment.commit();
                break;

            case R.id.nav_cont:

                FragmentContaks fragmentFragmentContaks = new FragmentContaks();
                FragmentManager fragmentManagerFragmentContaks = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentContaks = fragmentManagerFragmentContaks.beginTransaction();
                fragmentTransactionFragmentContaks.replace(R.id.flContent, fragmentFragmentContaks);
                fragmentTransactionFragmentContaks.commit();
                break;

            case R.id.nav_ddos:

                FragmentDdos fragmentFragmentDdos = new FragmentDdos();
                FragmentManager fragmentManagerFragmentDdos = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentDdos = fragmentManagerFragmentDdos.beginTransaction();
                fragmentTransactionFragmentDdos.replace(R.id.flContent, fragmentFragmentDdos);
                fragmentTransactionFragmentDdos.commit();
                break;

            case R.id.nav_os:

                FragmentOs fragmentFragmentOs = new FragmentOs();
                FragmentManager fragmentManagerFragmentOs = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentOs = fragmentManagerFragmentOs.beginTransaction();
                fragmentTransactionFragmentOs.replace(R.id.flContent, fragmentFragmentOs);
                fragmentTransactionFragmentOs.commit();
                break;

            default:
                //fragmentClass = ActivityFeedFragment.class;
              /*  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                ActivityFeedFragment fragmentActivityFeedFragment1 = new ActivityFeedFragment();
                FragmentManager fragmentManagerActivityFeedFragment1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionActivityFeedFragment1 = fragmentManagerActivityFeedFragment1.beginTransaction();
                fragmentTransactionActivityFeedFragment1.replace(R.id.flContent, fragmentActivityFeedFragment1);
                fragmentTransactionActivityFeedFragment1.commit();*/
        }

        // try {
        //   fragment = (Fragment) fragmentClass.newInstance();
        //  } catch (Exception e) {
        //      e.printStackTrace();
        //}

        // Вставить фрагмент, заменяя любой существующий
        //   FragmentManager fragmentManager = getSupportFragmentManager();
//       fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Выделение существующего элемента выполнено с помощью
        // NavigationView
        menuItem.setChecked(true);
        // Установить заголовок для action bar'а
     //   setTitle(menuItem.getTitle());
        // Закрыть navigation drawer
        dl.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

 /*   @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Gl) {

            Intent intentKat = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intentKat);
        } else if (id == R.id.nav_Kat) {

            Intent intentKat = new Intent(MainActivity.this, ActivityCategory.class);
            startActivity(intentKat);

        } else if (id == R.id.nav_Lid) {


    } else if (id == R.id.nav_Ak) {

    }
    else if (id == R.id.nav_manageKor) {

        } else if (id == R.id.nav_manageNew) {

        } else if (id == R.id.nav_Inf) {

    } else if (id == R.id.nav_Nas) {

    }


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    /*private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < color.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }*/
}
