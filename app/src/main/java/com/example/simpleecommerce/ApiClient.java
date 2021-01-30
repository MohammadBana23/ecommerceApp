package com.example.simpleecommerce;

import com.example.simpleecommerce.MyEndPoints.CategoryEndPoints;
import com.example.simpleecommerce.MyEndPoints.ProductEndPoints;
import com.example.simpleecommerce.MyEndPoints.UserEndPoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient INSTANCE = null;

    private static final String BASE_URL = "http://192.168.1.51:9797/api/v1/";
    private Retrofit retrofit;
    private ApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ApiClient();
        }
        return INSTANCE;
    }
    public UserEndPoints getUserEndPoints(){
        return retrofit.create(UserEndPoints.class);
    }
    public CategoryEndPoints getCategoryEndPoints(){
        return retrofit.create(CategoryEndPoints.class);
    }
    public ProductEndPoints getProductEndPoints(){
        return retrofit.create(ProductEndPoints.class);
    }


}
