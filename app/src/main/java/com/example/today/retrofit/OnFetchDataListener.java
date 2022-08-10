package com.example.today.retrofit;

import com.example.today.models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener <NewsApiResponse>{
    void fetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
