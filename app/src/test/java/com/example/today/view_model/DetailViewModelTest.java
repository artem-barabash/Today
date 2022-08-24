package com.example.today.view_model;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.example.today.R;
import com.example.today.databinding.ActivityDetailBinding;
import com.example.today.models.NewsHeadlines;
import com.example.today.models.Source;
import com.example.today.ui.DetailActivity;
import com.example.today.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

public class DetailViewModelTest  {

    private NewsHeadlines newsHeadlines;
    DetailViewModel detailViewModel;


    //Context context = RuntimeEnvironment.getApplication();


    @Before
    public void setUp() throws Exception {
        newsHeadlines = new NewsHeadlines(new Source(null, "bbc-news"), "", "Title", "",
                "http://ru.wikipedia.org/wiki/%D0%95%D0%B2%D1%80%D0%BE%D0%BF%D0%B0_%28%D1%81%D0%BF%D1%83%D1%82%D0%BD%D0%B8%D0%BA%29#/media/%D0%A4%D0%B0%D0%B9%D0%BB:Europa-moon.jpg",
                "", "", "Lorem ipsum...");

        detailViewModel = new DetailViewModel(newsHeadlines);

    }

    @Test
    public void testStringForActivity(){
        assertEquals(newsHeadlines.getTitle(), detailViewModel.getTitle());
        assertEquals(newsHeadlines.getContent(), detailViewModel.getContent());
        assertEquals(newsHeadlines.getUrlToImage(), detailViewModel.getUrlToImage());
    }



}