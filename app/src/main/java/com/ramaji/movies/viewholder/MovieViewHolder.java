package com.ramaji.movies.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramaji.movies.R;
import com.ramaji.movies.data.response.Movie;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTv, storyTv, dateTv, ratingTv;
    private Context context;

    public MovieViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.layout_movie, parent, false));

        this.context = parent.getContext();

        nameTv = itemView.findViewById(R.id.name);
        dateTv = itemView.findViewById(R.id.release_date);
        storyTv = itemView.findViewById(R.id.story);
        ratingTv = itemView.findViewById(R.id.rating);

    }

    public void setData(Movie movie){
        nameTv.setText(movie.getName());
        storyTv.setText(movie.getOverview());
        dateTv.setText(context.getResources().getString(R.string.date, movie.getRelease_date()));
        ratingTv.setText(context.getResources().getString(R.string.rating, movie.getRating()));
    }
}
