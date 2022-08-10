package com.example.today;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private NewsHeadlines newsHeadlines;

    YouTubePlayerView youTubePlayerView;
    //TextView titleArticleTextView;
    //TextView contentArticleTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        youTubePlayerView = findViewById(R.id.ytPlayer);

        newsHeadlines = getIntent().getParcelableExtra("currentArticle");


        /*ActivityYoutubeBinding activityYoutubeBinding = DataBindingUtil.setContentView(this, R.layout.activity_youtube);
        activityYoutubeBinding.setViewModel(new YoutubeViewModel(newsHeadlines));
        activityYoutubeBinding.executePendingBindings();*/


        System.out.println("link=" + newsHeadlines.getUrl());

        String YOUTUBE_APIKEY = "AIzaSyCxCCmishNS6j5A0mLx78koIs80RW3dU68";
        youTubePlayerView.initialize(YOUTUBE_APIKEY, new YouTubePlayer.OnInitializedListener() {
           @Override
           public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
               String linkVideo = newsHeadlines.getUrl().split("=")[1];

               youTubePlayer.loadVideo(linkVideo);
               youTubePlayer.play();
           }

           @Override
           public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
               Toast.makeText(getApplicationContext(), "Error youtube player", Toast.LENGTH_SHORT).show();
           }
       });

    }
}