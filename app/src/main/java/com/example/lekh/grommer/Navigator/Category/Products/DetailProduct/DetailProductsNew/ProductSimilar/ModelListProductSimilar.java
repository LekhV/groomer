package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar;

import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelListProductSimilar {

    @SerializedName("products")
    @Expose
    private List<ModelProductSimilar> products = null;

    public List<ModelProductSimilar> getProducts() {
        return products;
    }

    public void setProducts(List<ModelProductSimilar> products) {
        this.products = products;
    }
}
