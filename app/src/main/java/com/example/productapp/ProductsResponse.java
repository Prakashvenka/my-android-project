/*package com.example.productapp;

import java.util.List;

public class ProductsResponse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}*/

package com.example.productapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProductsResponse {
    private List<Products> products; // Fixed class name here

    public List<Products> getProducts() { // Fixed class name here
        return products;
    }

    public void setProducts(List<Products> products) { // Fixed class name here
        this.products = products;
    }
}
