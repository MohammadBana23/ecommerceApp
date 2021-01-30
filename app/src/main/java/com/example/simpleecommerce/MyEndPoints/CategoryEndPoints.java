package com.example.simpleecommerce.MyEndPoints;

import com.example.simpleecommerce.CategoryRCV.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryEndPoints {

    @GET("category")
    Call<List<Category>> getAllCategories();
}
