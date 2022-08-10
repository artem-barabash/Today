package com.example.today.adapter;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.today.DetailActivity;
import com.example.today.R;
import com.example.today.YoutubeActivity;
import com.example.today.models.NewsHeadlines;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlines;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textTitle.setText(headlines.get(position).getTitle());
        holder.textSource.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage() != null){
            Glide.with(context)
                    .load(headlines.get(position).getUrlToImage())
                    .into(holder.imageHeadline);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                Intent intent;
                if(headlines.get(position).getSource().getName().equals("YouTube")){
                    intent = new Intent(context, YoutubeActivity.class);
                }else {
                    intent = new Intent(context, DetailActivity.class);
                }
                ActivityOptions activityOptions = ActivityOptions.makeBasic();
                intent.putExtra("currentArticle", headlines.get(position));
                context.startActivity(intent, activityOptions.toBundle());

            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle;
        TextView textSource;
        ImageView imageHeadline;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.text_title);
            textSource = itemView.findViewById(R.id.text_source);
            imageHeadline = itemView.findViewById(R.id.img_headline);
        }
    }
}
