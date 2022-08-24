package com.example.today.view_model;


import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;

import com.example.today.ui.YoutubeActivity;
import com.example.today.models.NewsHeadlines;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public class YoutubeViewModel extends BaseObservable {
    private final NewsHeadlines newsHeadlines;

    private final Context context;

    private final String YOUTUBE_APIKEY = "AIzaSyCxCCmishNS6j5A0mLx78koIs80RW3dU68";

    public YoutubeViewModel( Context context, NewsHeadlines newsHeadlines){
        this.newsHeadlines = newsHeadlines;
        this.context = context;

        showVideo();

    }

    private void showVideo(){

        YoutubeActivity.activityYoutubeBinding.ytPlayer.initialize(YOUTUBE_APIKEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                String linkVideo = newsHeadlines.getUrl().split("=")[1];

                youTubePlayer.loadVideo(linkVideo);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(context, "Error youtube player", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public String getUrlToImage() {
        return newsHeadlines.getUrlToImage();
    }

    public void setUrlToImage(String urlToImage) {
        newsHeadlines.setUrlToImage(urlToImage);
    }

    public String getDescription() {
        return newsHeadlines.getDescription();
    }

    public void setDescription(String description) {
        newsHeadlines.setDescription(description);
    }

    public String getTitle() {
        return newsHeadlines.getTitle();
    }

    public void setTitle(String title) {
        newsHeadlines.setTitle(title);
    }

    public String getContent() {
        return newsHeadlines.getContent();
    }

    public void setContent(String content) {
        newsHeadlines.setContent(content);
    }
}
