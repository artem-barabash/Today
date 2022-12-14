package com.example.today.retrofit;

import com.example.today.response.NewsApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallNewsApi {
    @GET("top-headlines")
    Call<NewsApiResponse> callHeadlines(
            @Query("sources") String source,
            @Query("language") String language,
            @Query("country") String country,
            @Query("category") String category,
            @Query("q") String query,
            @Query("apiKey") String api_key
    );
}
