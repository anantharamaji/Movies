package com.ramaji.movies.home;

import com.ramaji.movies.data.response.Movie;
import com.ramaji.movies.data.story.MovieDataSource;

import java.util.List;

public class MoviesPresenter implements MoviesContract.Presenter{

    private final MovieDataSource mSource;
    private final MoviesContract.View mStoriesView;

    public MoviesPresenter(MovieDataSource source, MoviesContract.View storiesView) {
        mSource = source;
        mStoriesView = storiesView;

        mStoriesView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void loadMovies() {
        mSource.getMovies(new MovieDataSource.LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                mStoriesView.showMovies(movies);
            }

            @Override
            public void onMoviesNotFound() {
                mStoriesView.showNoMovies();
            }
        });
    }
}
