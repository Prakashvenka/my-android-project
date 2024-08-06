/*package com.example.productapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_PRODUCT = 1;

    private List<Product> products;
    private OnProductClickListener onProductClickListener;

    public ProductAdapter(List<Product> products, OnProductClickListener onProductClickListener) {
        this.products = products;
        this.onProductClickListener = onProductClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TITLE;
        } else {
            return TYPE_PRODUCT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_TITLE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
            return new TitleViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
            return new ProductViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_TITLE) {
            ((TitleViewHolder) holder).bind();
        } else {
            ((ProductViewHolder) holder).bind(products.get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return products.size() + 1;
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {
        TitleViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind() {
            // No specific binding needed for the title
        }
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView productTitle;
        private TextView productDescription;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.productTitle);
            productDescription = itemView.findView
        }
    }
}*/

package com.example.productapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Products> products; // Fixed class name here
    private OnProductClickListener onProductClickListener;

    public ProductAdapter(List<Products> products, OnProductClickListener onProductClickListener) { // Fixed class name here
        this.products = products;
        this.onProductClickListener = onProductClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView productTitle;
        private TextView productDescription;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.productTitle);
            productDescription = itemView.findViewById(R.id.productDescription);
        }

        void bind(Products product) { // Fixed class name here
            productTitle.setText(product.getTitle());
            productDescription.setText(product.getDescription());
            itemView.setOnClickListener(v -> onProductClickListener.onProductClick(product));
        }
    }

    public interface OnProductClickListener {
        void onProductClick(Products product); // Fixed class name here
    }
}


