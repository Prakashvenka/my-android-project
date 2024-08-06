/*package com.example.productapp;

import retrofit2.Call;
import retrofit2.http.GET;

public class ProductsService { // Renamed to ProductService
    @GET("products")
    Call<ProductsResponse> getProducts(); // Fixed return type to match ProductsResponse
}*/

package com.example.productapp;

import retrofit2.Call;
import retrofit2.http.GET;

public class ProductsService {
    public interface ProductService {
        @GET("products")
        Call<ProductsResponse> getProducts();
    }
}
