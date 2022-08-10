package com.example.today.view_model;

import androidx.databinding.BaseObservable;

import com.example.today.models.NewsHeadlines;

public class DetailViewModel extends BaseObservable {
    private NewsHeadlines newsHeadlines;

    public DetailViewModel(NewsHeadlines newsHeadlines){
        this.newsHeadlines = newsHeadlines;

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
