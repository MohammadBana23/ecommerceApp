package com.example.simpleecommerce.ProductRCV;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.R;
import com.example.simpleecommerce.ClickOnRCV.OnProductRecyclerViewItemClickListener;
import com.example.simpleecommerce.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductVH> {
    private List<Product> productList;
    private OnProductRecyclerViewItemClickListener listener;
    public void setData(List<Product> productList){
        this.productList = productList;
    }

    public void setListener(OnProductRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_products,parent,false);
        return new ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Product product = productList.get(position);
        String name = product.getName();
//        String description = product.getDescription();
//        int rate = product.getRate();
//        int price = product.getPrice();
        holder.txtProductName.setText("Name : "+ name);
//        holder.txtProductDescription.setText("Description : " + description);
//        holder.txtProductRate.setText("Rate : "+ String.valueOf(rate));
//        holder.txtProductPrice.setText("Price : "+String.valueOf(price));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(position,product);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
