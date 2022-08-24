package com.example.today.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.today.R;
import com.example.today.databinding.ActivityDetailBinding;
import com.example.today.databinding.ActivityYoutubeBinding;
import com.example.today.models.NewsHeadlines;
import com.example.today.view_model.DetailViewModel;
import com.example.today.view_model.YoutubeViewModel;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class YoutubeActivity extends YouTubeBaseActivity {
    @SuppressLint("StaticFieldLeak")
    public static ActivityYoutubeBinding activityYoutubeBinding;
    private NewsHeadlines newsHeadlines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newsHeadlines = getIntent().getParcelableExtra("currentArticle");

        activityYoutubeBinding = DataBindingUtil.setContentView(this, R.layout.activity_youtube);
        activityYoutubeBinding.setViewModel(new YoutubeViewModel(this, newsHeadlines));
        activityYoutubeBinding.executePendingBindings();

        //System.out.println("link=" + newsHeadlines.getUrl());
    }
}