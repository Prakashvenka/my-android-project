package com.example.productapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsListActivity extends AppCompatActivity {
    private RecyclerView productsRecyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        // Initialize RecyclerViews
        productsRecyclerView = findViewById(R.id.productsRecyclerView);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch products and set adapter
        fetchProducts();
    }

    private void fetchProducts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductsService.ProductService service = retrofit.create(ProductsService.ProductService.class);
        Call<ProductsResponse> call = service.getProducts();

        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful()) {
                    List<Products> products = response.body().getProducts();
                    productAdapter = new ProductAdapter(products, ProductsListActivity.this::onProductClick);
                    productsRecyclerView.setAdapter(productAdapter);
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void onProductClick(Products product) {
        Intent intent = new Intent(ProductsListActivity.this, ProductsDetailActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}










