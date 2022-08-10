package com.example.today;



import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.today.adapter.CustomAdapter;
import com.example.today.constants.Categories;


import com.example.today.models.NewsHeadlines;
import com.example.today.response.NewsApiResponse;
import com.example.today.retrofit.OnFetchDataListener;
import com.example.today.retrofit.RequestManager;


import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextSearch;

    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    RequestManager requestManager;;

    private String currentCategory = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearch = findViewById(R.id.editTextSearch);


        setRequestManager(null, null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void fetchData(List<NewsHeadlines> list, String message) {
            showList(list);
        }

        @Override
        public void onError(String message) {

        }
    };

    public  void showList(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customAdapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(customAdapter);
    }


    private void setRequestManager(String selectedCategory, String selectedQuery){
        requestManager = new RequestManager(this);
        requestManager.getNewsHeadlines(listener, selectedCategory, selectedQuery);
    }



    public void showGeneralNews(View view){
        currentCategory = Categories.categoryOfGeneral;
        setRequestManager(currentCategory, null);
    }

    public void showBusinessNews(View view){
        currentCategory = Categories.businessOfGeneral;
        setRequestManager(currentCategory, null);
    }
    public void showEntertainmentNews(View view){
        currentCategory = Categories.entertainmentOfGeneral;
        setRequestManager(currentCategory, null);
    }
    public void showHealthNews(View view){
        currentCategory = Categories.healthOfGeneral;
        setRequestManager(currentCategory, null);
    }

    public void showScienceNews(View view){
        currentCategory = Categories.scienceOfGeneral;
        setRequestManager(currentCategory, null);
    }

    public void showSportsNews(View view){
        currentCategory = Categories.sportsOfGeneral;
        setRequestManager(currentCategory, null);
    }

    public void showTechnologyNews(View view){
        currentCategory = Categories.technologyOfGeneral;
        setRequestManager(currentCategory, null);
    }

    public void onClickSearch(View view) {
        if(!editTextSearch.getText().toString().isEmpty()){
            setRequestManager(currentCategory, editTextSearch.getText().toString());
        }
    }

    public void clearFilterOnClick(View view) {
        setRequestManager(null, null);
    }
}