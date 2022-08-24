package com.example.today.view_model;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.today.adapter.CustomAdapter;
import com.example.today.constants.Categories;
import com.example.today.models.NewsHeadlines;
import com.example.today.response.NewsApiResponse;
import com.example.today.ui.MainActivity;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.manipulation.Ordering;
import org.mockito.Mockito;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.List;

public class MainViewModelTest  {

    private MainViewModel mainViewModel;

    @Before
    public void setUp() throws Exception {
        mainViewModel = new MainViewModel();
    }

    @Test
    public void testCountryUkraine(){
        mainViewModel.selectCountryUkr();
        assertEquals("ua", MainViewModel.currentCountry);
    }

    @Test
    public void testCountryUSA(){
        mainViewModel.selectCountryUSA();
        assertEquals("us", MainViewModel.currentCountry);
    }

    @Test
    public void testCountryJapan(){
        mainViewModel.selectCountryJP();
        assertEquals("jp", MainViewModel.currentCountry);
    }

    @Test
    public void testBusinessNews(){
        mainViewModel.showBusinessNews();
        assertEquals(Categories.business, MainViewModel.currentCategory);
    }

    @Test
    public void testGeneralNews(){
        mainViewModel.showGeneralNews();
        assertEquals(Categories.general, MainViewModel.currentCategory);
    }
    @Test
    public void testEntertainmentNews(){
        mainViewModel.showEntertainmentNews();
        assertEquals(Categories.entertainment, MainViewModel.currentCategory);
    }

    @Test
    public void testHealthNews(){
        mainViewModel.showHealthNews();
        assertEquals(Categories.health, MainViewModel.currentCategory);
    }

    @Test
    public void testScienceNews(){
        mainViewModel.showScienceNews();
        assertEquals(Categories.science, MainViewModel.currentCategory);
    }

    @Test
    public void testSportsNews(){
        mainViewModel.showSportsNews();
        assertEquals(Categories.sports, MainViewModel.currentCategory);
    }

    @Test
    public void testTechnologyNews(){
        mainViewModel.showTechnologyNews();
        assertEquals(Categories.technology, MainViewModel.currentCategory);
    }
}