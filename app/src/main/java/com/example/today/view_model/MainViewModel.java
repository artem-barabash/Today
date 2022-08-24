package com.example.today.view_model;

import static com.example.today.ui.MainActivity.customAdapter;
import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.today.constants.Categories;
import com.example.today.repository.NewsHeadsRepository;
import com.example.today.response.NewsApiResponse;


public class MainViewModel extends ViewModel {
    public static String currentCountry = "ua";
    public static String currentCategory = null;
    public static String querySearch = null;

    NewsHeadsRepository newsHeadsRepository = new NewsHeadsRepository();

    private LiveData<NewsApiResponse> listNewsHeadlines;


    public MainViewModel(){
        this.listNewsHeadlines = newsHeadsRepository.getBoardNews(currentCountry, currentCategory, querySearch);
    }
    public LiveData<NewsApiResponse> getNewsHeadlines(){
        listNewsHeadlines = newsHeadsRepository.getBoardNews(currentCountry, currentCategory, querySearch);
        return listNewsHeadlines;
    }

   @SuppressLint("NotifyDataSetChanged")
   public void showBusinessNews(){
       currentCategory = Categories.business;
   }

    @SuppressLint("NotifyDataSetChanged")
    public void showGeneralNews(){
        currentCategory = Categories.general;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void showEntertainmentNews(){
        currentCategory = Categories.entertainment;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void showHealthNews(){
        currentCategory = Categories.health;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void showScienceNews(){
        currentCategory = Categories.science;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void showSportsNews(){
        currentCategory = Categories.sports;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void showTechnologyNews(){
        currentCategory = Categories.technology;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void searchByQuery(String query) {
        if(!query.trim().isEmpty()){
            querySearch = query;
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    public void filterAllCategories() {
        currentCategory = null;
        querySearch = null;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void selectCountryUkr() {
        currentCountry = "ua";
    }

    @SuppressLint("NotifyDataSetChanged")
    public void selectCountryUSA() {
        currentCountry = "us";
    }

    @SuppressLint("NotifyDataSetChanged")
    public void selectCountryJP() {
        currentCountry = "jp";
    }
}
