package com.example.today.adapter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.today.R;
import com.example.today.models.NewsHeadlines;
import com.example.today.models.Source;
import com.example.today.ui.DetailActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.TestLifecycleApplication;
import org.robolectric.shadows.ShadowDrawable;

import java.util.ArrayList;
import java.util.List;

@RunWith(RobolectricTestRunner.class)

public class CustomAdapterTest {
    Context context = RuntimeEnvironment.getApplication();
    //Context context;

    CustomAdapter customAdapter;
    CustomAdapter.CustomViewHolder viewHolder;


    private View mockView;
    private Fragment mockFragment;

    private List<NewsHeadlines> list = new ArrayList<>();


    @Before
    public void setUp(){

        mockView = mock(View.class);
        mockFragment = mock(Fragment.class);
        //context = mockFragment.getContext();

        Source source = new Source(null, "bbc-news");

        String url = "https://i.guim.co.uk/img/media/ff79d5d44d27a7fee3201853312d8d300e831937/0_0_2362_1575/master/2362.jpg?width=620&quality=85&fit=max&s=b6a7216d306296ce84c3ef0da245f9e7";

        list.add(new NewsHeadlines(source, null, "title1", "Lorem ipsum..", null,
                null,
                null, null));
        list.add(new NewsHeadlines(source, null, "title2", "Lorem ipsum..", null, null, null, null));
        list.add(new NewsHeadlines(source, null, "title3", "Lorem ipsum..", null, null, null, null));

        customAdapter = new CustomAdapter(context, list);
    }


    @Test
    public void itemCount(){

        assertEquals(3,customAdapter.getItemCount());

    }

    @Test
    public void getItemAtPosition(){
        Source source = new Source(null, "cnn");

        NewsHeadlines newsHeadlines1 = new NewsHeadlines(source, null, "title4", "Lorem ipsum..",
                null, null, null, null);
        NewsHeadlines newsHeadlines2 = new NewsHeadlines(source, null, "title5", "Lorem ipsum..",
                null, null, null, null);

        list.add(newsHeadlines1);
        list.add(newsHeadlines2);

        customAdapter.notifyDataSetChanged();
        assertEquals(5,customAdapter.getItemCount());

        assertEquals(newsHeadlines1,customAdapter.getItemAtPosition(3));

    }

    @Test
    public void testTitle(){
        customAdapter = new CustomAdapter(context, list);

        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        viewHolder = customAdapter.onCreateViewHolder(recyclerView, 0);

        customAdapter.onBindViewHolder(viewHolder, 0);

        Assertions.assertEquals(list.get(0).getTitle(), viewHolder.textTitle.getText().toString());

    }

    @Test
    public void testIntent(){
        LayoutInflater inflater = (LayoutInflater) RuntimeEnvironment.getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.headline_list_items, null, false);

        viewHolder = new CustomAdapter.CustomViewHolder(itemView);

        customAdapter.onBindViewHolder(viewHolder, 0);

        viewHolder.itemView.performClick();

        /*Intent intent = new Intent(context, DetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ActivityOptions activityOptions = ActivityOptions.makeBasic();
        intent.putExtra("currentArticle", list.get(0));
        verify(context).startActivity(intent, activityOptions.toBundle());*/
        //TODO

    }

}