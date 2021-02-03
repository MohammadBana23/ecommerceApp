package com.example.simpleecommerce.MyEndPoints;

import com.example.simpleecommerce.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductEndPoints {
    @GET("product/{id}")
    Call<List<Product>> getByCategoryId(@Path("id") String id);

}
