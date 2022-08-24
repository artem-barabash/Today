package com.example.today.view_model;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.today.ui.DetailActivity;
import com.example.today.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailViewModel extends BaseObservable {
    private final NewsHeadlines newsHeadlines;

    public DetailViewModel(NewsHeadlines newsHeadlines){
        this.newsHeadlines = newsHeadlines;

       Glide.with(DetailActivity.activityDetailBinding.imageArticle).
                load(newsHeadlines.getUrlToImage()).
                into(DetailActivity.activityDetailBinding.imageArticle);

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
