package com.example.today.ui;

import static com.example.today.view_model.MainViewModel.currentCategory;

import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.today.R;
import com.example.today.adapter.CustomAdapter;
import com.example.today.constants.Categories;
import com.example.today.databinding.ActivityMainBinding;
import com.example.today.models.NewsHeadlines;
import com.example.today.response.NewsApiResponse;
import com.example.today.view_model.MainViewModel;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView newsRecyclerView;
    Button btnBusiness;
    EditText editTextSearch;

    static List<NewsHeadlines> newsHeadlines;

    public static CustomAdapter customAdapter;


    MainViewModel mainViewModel;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        getNewsList();
    }

    private void initialize() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        newsRecyclerView = findViewById(R.id.recycler_main);
        btnBusiness = findViewById(R.id.button_business);
        editTextSearch = findViewById(R.id.editTextSearch);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mainViewModel.searchByQuery(charSequence.toString());
                getNewsList();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void getNewsList() {
        mainViewModel.getNewsHeadlines().observe(this, newsApiResponse -> {
            newsHeadlines = newsApiResponse.getArticles();
            System.out.println("newsHeadlines" + newsHeadlines);

            showList(newsHeadlines);
            //customAdapter.notifyDataSetChanged();
        });
    }

    public void showList(List<NewsHeadlines> list) {
        newsRecyclerView.setHasFixedSize(true);

        newsRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customAdapter = new CustomAdapter(this, list);
        newsRecyclerView.setAdapter(customAdapter);
    }

    public void removeCategoriesClicked(View view){
        mainViewModel.filterAllCategories();
        getNewsList();
    }

    public void showGeneralNewsClicked(View view){
        mainViewModel.showGeneralNews();
        getNewsList();
    }

    public void showBusinessNewsClicked(View view){
        mainViewModel.showBusinessNews();
        getNewsList();
    }

    public void showEntertainmentNewsClicked(View view){
        mainViewModel.showEntertainmentNews();
        getNewsList();
    }

    public void showHealthNewsClicked(View view){
        mainViewModel.showHealthNews();
        getNewsList();
    }

    public void showScienceNewsClicked(View view){
        mainViewModel.showScienceNews();
        getNewsList();
    }

    public void showSportNewsClicked(View view){
        mainViewModel.showSportsNews();
        getNewsList();
    }

    public void showTechnologyNewsClicked(View view){
        mainViewModel.showTechnologyNews();
        getNewsList();
    }


    public void selectCountryUkrClicked(View view){
        mainViewModel.selectCountryUkr();
        getNewsList();
    }

    public void selectCountryUSAClicked(View view){
        mainViewModel.selectCountryUSA();
        getNewsList();
    }

    public void selectCountryJPClicked(View view){
        mainViewModel.selectCountryJP();
        getNewsList();
    }

}