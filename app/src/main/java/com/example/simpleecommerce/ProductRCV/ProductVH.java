package com.example.simpleecommerce.ProductRCV;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.R;

public class ProductVH extends RecyclerView.ViewHolder {
    TextView txtProductName;
    TextView txtProductDescription;
    TextView txtProductRate;
    TextView txtProductPrice;


    public ProductVH(@NonNull View itemView) {
        super(itemView);
        txtProductName = itemView.findViewById(R.id.txt_product_name);
        txtProductDescription = itemView.findViewById(R.id.txt_product_description);
        txtProductRate = itemView.findViewById(R.id.txt_product_rate);
        txtProductPrice = itemView.findViewById(R.id.txt_product_price);

    }
}
