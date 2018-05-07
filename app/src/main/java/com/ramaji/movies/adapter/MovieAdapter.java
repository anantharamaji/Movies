package com.ramaji.movies.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ramaji.movies.data.response.Movie;
import com.ramaji.movies.viewholder.MovieViewHolder;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Movie> movies;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MovieViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        ((MovieViewHolder)holder).setData(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }
}
