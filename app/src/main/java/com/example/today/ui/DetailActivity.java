package com.example.today.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.today.R;
import com.example.today.databinding.ActivityDetailBinding;
import com.example.today.models.NewsHeadlines;
import com.example.today.view_model.DetailViewModel;

public class DetailActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    public static ActivityDetailBinding activityDetailBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NewsHeadlines newsHeadlines = getIntent().getParcelableExtra("currentArticle");

        activityDetailBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_detail);
        activityDetailBinding.setViewModel(new DetailViewModel(newsHeadlines));
        activityDetailBinding.executePendingBindings();

    }
}