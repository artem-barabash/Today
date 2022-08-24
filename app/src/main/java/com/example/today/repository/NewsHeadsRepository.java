package com.example.today.repository;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.today.constants.AppConstants;
import com.example.today.response.NewsApiResponse;
import com.example.today.retrofit.CallNewsApi;
import com.example.today.retrofit.RequestManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsHeadsRepository {
    private static final String TAG = NewsHeadsRepository.class.getSimpleName();
    private final CallNewsApi callNewsApi;

    public NewsHeadsRepository(){
        callNewsApi = RequestManager.getRetrofitInstance().create(CallNewsApi.class);
    }

    public LiveData<NewsApiResponse> getBoardNews(String country, String category, String query){
        final MutableLiveData<NewsApiResponse> data = new MutableLiveData<>();
        callNewsApi.callHeadlines(null, null, country, category, query,
                AppConstants.API_KEY).enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return  data;

    }



}
