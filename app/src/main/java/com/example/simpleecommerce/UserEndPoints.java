package com.example.simpleecommerce;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserEndPoints {
    @POST("signup")
    Call<User> createNewUser(@Body RequestBody requestBody);

    @GET("user")
    Call<List<User>> getAllCategories();

    @POST("login")
    Call<User> getUserByUsernamePassword(@Body RequestBody requestBody);

}
