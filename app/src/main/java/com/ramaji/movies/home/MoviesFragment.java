package com.ramaji.movies.home;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.ramaji.movies.R;
import com.ramaji.movies.adapter.MovieAdapter;
import com.ramaji.movies.data.response.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoviesFragment extends Fragment implements MoviesContract.View{

    private static final String KEY_MOVIES = "movies";

    private MoviesContract.Presenter mPresenter;
    public MovieAdapter adapter;
    private LinearLayout layout;

    private List<Movie> movies;

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    public MoviesFragment() {
    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MovieAdapter(new ArrayList<Movie>());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies, container, false);

        RecyclerView recycler = root.findViewById(R.id.movies);
        layout = root.findViewById(R.id.empty);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(manager);
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL));
        recycler.setAdapter(adapter);

        mPresenter.loadMovies();

        return root;
    }

    @Override
    public void showNoMovies() {
        layout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        this.movies = movies;
        adapter.addMovies(this.movies);
        layout.setVisibility(View.GONE);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_MOVIES, (ArrayList<? extends Parcelable>) this.movies);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null && !savedInstanceState.isEmpty()){
            this.movies = savedInstanceState.getParcelableArrayList(KEY_MOVIES);
            adapter.addMovies(this.movies);
            adapter.notifyDataSetChanged();
        }
    }
}
