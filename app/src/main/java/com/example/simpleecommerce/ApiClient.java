package com.example.simpleecommerce;


import com.example.simpleecommerce.MyEndPoints.MyEndPoints;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient INSTANCE = null;

    private static final String BASE_URL = "http://192.168.43.217:9797/api/v1/";
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
    public <T> T getEndPoints(Class<T> service){
        return retrofit.create(service);
    }



}
