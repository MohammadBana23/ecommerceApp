package com.example.simpleecommerce.CategoryRCV;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.OnCategoryRecyclerViewItemClickListener;
import com.example.simpleecommerce.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryVH> {
    private List<Category> categoryList;
    private OnCategoryRecyclerViewItemClickListener listener;
    public void setData(List<Category> categoryList,OnCategoryRecyclerViewItemClickListener listener){
        this.categoryList = categoryList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_categories,parent,false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {
        Category category = categoryList.get(position);
        String name = category.getName();
        String description = category.getDescription();
        holder.txtCategoryName.setText(name);
        holder.txtCategoryDescription.setText(description);
        holder.categoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
