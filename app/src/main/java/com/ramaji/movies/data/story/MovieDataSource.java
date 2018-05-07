package com.ramaji.movies.data.story;


import com.ramaji.movies.data.response.Movie;

import java.util.List;

public interface MovieDataSource {

    interface LoadMoviesCallback {
        void onMoviesLoaded(List<Movie> movies);
        void onMoviesNotFound();
    }

    void getMovies(LoadMoviesCallback callback);

}
