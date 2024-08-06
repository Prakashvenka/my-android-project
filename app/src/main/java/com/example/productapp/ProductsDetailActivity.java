/*package com.example.productapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView productTitle = findViewById(R.id.productTitle);
        TextView productDescription = findViewById(R.id.productDescription);

        Product product = (Product) getIntent().getSerializableExtra("product");

        productTitle.setText(product.getTitle());
        productDescription.setText(product.getDescription());
    }
}
*/

package com.example.productapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_detail);

        TextView productTitle = findViewById(R.id.productTitle);
        TextView productDescription = findViewById(R.id.productDescription);

        Products product = (Products) getIntent().getSerializableExtra("product");

        if (product != null) {
            productTitle.setText(product.getTitle());
            productDescription.setText(product.getDescription());
        }
    }
}
