package com.ramaji.movies.data.story;

import com.ramaji.movies.data.response.Movie;

import java.util.List;

public class MovieRepository implements MovieDataSource {

    private static MovieRepository instance = null;
    private MovieDataSource source;

    private MovieRepository(MovieDataSource source) {
        this.source = source;
    }

    public static MovieRepository getInstance(MovieDataSource source) {
        if(instance == null){
            instance = new MovieRepository(source);
        }
        return instance;
    }

    @Override
    public void getMovies(final LoadMoviesCallback callback) {
        source.getMovies(new LoadMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onMoviesNotFound() {
                callback.onMoviesNotFound();
            }
        });
    }

}