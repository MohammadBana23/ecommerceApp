package com.example.simpleecommerce.ProductRCV;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.simpleecommerce.R;

public class ProductDetails extends Fragment {
    private TextView detailName;
    private TextView detailDescription;
    private TextView detailRate;
    private TextView detailPrice;

    public static ProductDetails newInstance(String name,String description,int rate,int price) {
        Bundle args = new Bundle();
        args.putString("DESC", description);
        args.putString("NAME", name);
        args.putInt("RATE", rate);
        args.putInt("PRICE", price);
        ProductDetails fragment = new ProductDetails();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_detail,container,false);
        String productName  = getArguments().getString("NAME");
        String productDescription  = getArguments().getString("DESC");
        int  productRate  = getArguments().getInt("RATE");
        int productPrice  = getArguments().getInt("PRICE");
        detailName = view.findViewById(R.id.txt_product_detail_name);
        detailDescription = view.findViewById(R.id.txt_product_detail_description);
        detailRate = view.findViewById(R.id.txt_product_detail_rate);
        detailPrice = view.findViewById(R.id.txt_product_detail_price);
        detailName.setText("Name : " + productName);
        detailDescription.setText("Description : " + productDescription);
        detailRate.setText("Rate : " + productRate);
        detailPrice.setText("Price : " + productPrice);
        return view;
    }
}
