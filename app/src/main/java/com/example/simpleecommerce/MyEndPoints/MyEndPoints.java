package com.example.simpleecommerce.MyEndPoints;

import com.example.simpleecommerce.models.Category;
import com.example.simpleecommerce.models.Product;
import com.example.simpleecommerce.models.User;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyEndPoints {
    interface UserEndPoints {
        @POST("user/signup")
        Call<User> createNewUser(@Body RequestBody requestBody);

        @POST("user/login")
        Call<User> getUserByUsernamePassword(@Body RequestBody requestBody);
    }
    interface CategoryEndPoints {

        @GET("category")
        Call<List<Category>> getAllCategories();
    }
    interface ProductEndPoints {
        @GET("product/{id}")
        Call<List<Product>> getByCategoryId(@Path("id") String id);

    }
}
