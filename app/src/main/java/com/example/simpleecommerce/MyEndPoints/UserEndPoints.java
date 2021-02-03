package com.example.simpleecommerce.MyEndPoints;

import com.example.simpleecommerce.models.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserEndPoints {
    @POST("user/signup")
    Call<User> createNewUser(@Body RequestBody requestBody);

    @POST("user/login")
    Call<User> getUserByUsernamePassword(@Body RequestBody requestBody);

}
