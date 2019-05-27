package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lekh.grommer.Navigator.Category.ActivityCategory;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.AllHar.FragmentALLHar;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Opisanie.FragmentOpisanie;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Photos.FragmentPhotos;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductRelated.FragmentProductRelated;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.FragmentProductSimilar;

public class PagerAdapterScreen extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Bundle bundle;

    public PagerAdapterScreen(FragmentManager fm, int NumOfTabs,Bundle bundle) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.bundle=bundle;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
                       case 0:
                FragmentALLHar tabFragmentAllScreen = new FragmentALLHar();

                           tabFragmentAllScreen.setArguments(bundle);
                return tabFragmentAllScreen;
            case 1:
                FragmentOpisanie tabFragmentAllScreen2 = new FragmentOpisanie();
                tabFragmentAllScreen2.setArguments(bundle);
                return tabFragmentAllScreen2;

          /*  case 2:
                FragmentPhotos tabFragmentAllScreen3 = new FragmentPhotos();
                tabFragmentAllScreen3.setArguments(bundle);
                return tabFragmentAllScreen3;*/

            case 2:
                FragmentProductRelated tabFragmentAllScreen4 = new FragmentProductRelated();
                tabFragmentAllScreen4.setArguments(bundle);
                return tabFragmentAllScreen4;

            case 3:
                FragmentProductSimilar tabFragmentAllScreen5 = new FragmentProductSimilar();
                tabFragmentAllScreen5.setArguments(bundle);
                return tabFragmentAllScreen5;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
