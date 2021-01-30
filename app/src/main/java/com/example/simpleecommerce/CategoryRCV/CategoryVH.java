package com.example.simpleecommerce.CategoryRCV;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.R;

public class CategoryVH extends RecyclerView.ViewHolder {
    TextView txtCategoryName;
    TextView txtCategoryDescription;
    CardView categoryCardView;
    public CategoryVH(@NonNull View itemView) {
        super(itemView);
        txtCategoryName = itemView.findViewById(R.id.txt_category_name);
        txtCategoryDescription = itemView.findViewById(R.id.txt_category_description);
        categoryCardView = itemView.findViewById(R.id.category_container);

    }
}
