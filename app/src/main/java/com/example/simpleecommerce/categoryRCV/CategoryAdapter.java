package com.example.simpleecommerce.categoryRCV;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.R;
import com.example.simpleecommerce.categoryRCV.Category;
import com.example.simpleecommerce.categoryRCV.CategoryVH;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryVH> {
    private List<Category> categoryList;
    public void setData(List<Category> categoryList){
        this.categoryList = categoryList;
    }
    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_products,parent,false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {
        Category category = categoryList.get(position);
        String name = category.getName();
        String description = category.getDescription();
        holder.txtCategoryName.setText(name);
        holder.txtCategoryDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
