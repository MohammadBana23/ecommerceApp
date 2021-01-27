package com.example.simpleecommerce.categoryRCV;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.R;

public class CategoryVH extends RecyclerView.ViewHolder {
    TextView txtCategoryName;
    TextView txtCategoryDescription;
    public CategoryVH(@NonNull View itemView) {
        super(itemView);
        txtCategoryName = itemView.findViewById(R.id.txt_category_name);
        txtCategoryDescription = itemView.findViewById(R.id.txt_category_description);

    }
}
