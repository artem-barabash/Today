package com.example.today.retrofit;

import android.content.Context;
import android.widget.Toast;

import com.example.today.constants.AppConstants;
import com.example.today.response.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RequestManager {
    static Retrofit retrofit;


    public static Retrofit getRetrofitInstance(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
