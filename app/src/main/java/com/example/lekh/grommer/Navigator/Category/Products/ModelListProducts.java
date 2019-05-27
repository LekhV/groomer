package com.example.lekh.grommer.Navigator.Category.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelListProducts {
    @SerializedName("category_id")
    @Expose
    private String categoryId;

    @SerializedName("product_total")
    @Expose
    private String productTotal;

    @SerializedName("products")
    @Expose
    private List<ModelProduct> products = null;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(String productTotal) {
        this.productTotal = productTotal;
    }

    public List<ModelProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ModelProduct> products) {
        this.products = products;
    }

}

