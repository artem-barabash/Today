package com.example.today;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.today.databinding.ActivityDetailBinding;
import com.example.today.models.NewsHeadlines;
import com.example.today.view_model.DetailViewModel;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private NewsHeadlines newsHeadlines;

    ImageView imageArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        newsHeadlines = getIntent().getParcelableExtra("currentArticle");

        ActivityDetailBinding activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        activityDetailBinding.setViewModel(new DetailViewModel(newsHeadlines));
        activityDetailBinding.executePendingBindings();

        imageArticle = findViewById(R.id.imageArticle);
        Picasso.get().load(newsHeadlines.getUrlToImage()).into(imageArticle);

    }
}