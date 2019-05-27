package com.example.lekh.grommer.Interface;

import com.example.lekh.grommer.Navigator.Category.ModelCategory;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.ModelListProductSimilar;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.ModelProductSimilar;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.ModeProductDetail;
import com.example.lekh.grommer.Navigator.Category.Products.ModelListProducts;
import com.example.lekh.grommer.Navigator.FragmentAkc.ModelAkciiList;
import com.example.lekh.grommer.Navigator.FragmentNovosti.ModelListNovosti;
import com.example.lekh.grommer.Navigator.FragmentNovosti.ModelNovosti;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCategory {

    @GET("index.php?route=common/api/getCategories")
    Call<List<ModelCategory>>userGetCategory();

    @GET("index.php?route=common/api/getCategories")
    Call<List<ModelCategory>> userGetPodCategory();

    @GET("index.php?route=common/api/getCategoryProducts")
    Call<ModelListProducts> getIdProd (@Query("id") String user_id);

    @GET("index.php?route=common/api/getCategoryProducts")
    Call<ModelListProducts> getIdProd (@Query("id") String user_id,@Query("page") String page);


    @GET("index.php?route=common/api/getProductInfo")
    Call<ModeProductDetail> userGetProductDetail (@Query("id") String user_id);

    @GET("index.php?route=common/api/getProductInfo")
    Call<ModelProductSimilar> userGetProductImg (@Query("id") String user_id);

    @GET("index.php?route=common/api/getProductSimilar")
    Call<ModelListProductSimilar> userGetProductSimilar (@Query("id") String user_id);

    @GET("index.php?route=common/api/getProductRelated")
    Call<ModelListProductSimilar> userGetProductRelate (@Query("id") String user_id);

    @GET("index.php?route=common/api/searchProducts")
    Call<ModelListProducts> getIdProdSearch (@Query("query") String user_query);

    @GET("index.php?route=common/api/searchProducts")
    Call<ModelListProducts> getIdProdSearch (@Query("query") String user_query,@Query("page") String page);

    @GET("index.php?route=common/api/getNews")
    Call<ModelListNovosti>userGetNovosti();

    @GET("index.php?route=common/api/getActions")
    Call<ModelAkciiList>userGetAkcii();

    @GET("index.php?route=common/api/getProductByType")
    Call<ModelListProducts> getIdProdLid (@Query("type") String user_lid);

    @GET("index.php?route=common/api/getProductByType")
    Call<ModelListProducts> getIdProdLid (@Query("type") String user_lid,@Query("page") String page);
}
