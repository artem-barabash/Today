package com.example.today.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NewsHeadlinesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void compareToElement(){
        NewsHeadlines newsHeadlines1 = new NewsHeadlines(new Source(null, "bbc-news"),
                null, "Title1", "Lorem ipsum...", null, null, null, null);
        NewsHeadlines newsHeadlines2 = new NewsHeadlines(new Source(null, "bbc-news"),
                null, "Title1", "Lorem ipsum...", null, null, null, null);

        assertEquals(newsHeadlines1.source.name, newsHeadlines2.source.name);
    }
}