package com.ramaji.movies.data.story;

import com.ramaji.movies.data.api.client.MoviesService;
import com.ramaji.movies.data.response.Data;
import com.ramaji.movies.data.response.Movie;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import retrofit2.Response;

public class MovieRemoteDataSource implements MovieDataSource {

    private static MovieRemoteDataSource INSTANCE;
    private MoviesService mMoviesService;

    public static MovieRemoteDataSource getInstance(MoviesService moviesService) {
        if (INSTANCE == null) {
            INSTANCE = new MovieRemoteDataSource(moviesService);
        }
        return INSTANCE;
    }

    private MovieRemoteDataSource(MoviesService moviesService) {
        mMoviesService = moviesService;
    }

    @Override
    public void getMovies(final LoadMoviesCallback callback) {

        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(mMoviesService.getMovies().subscribe(
                new Consumer<Response<Data>>() {
                    @Override
                    public void accept(Response<Data> response) {
                        List<Movie> movies;
                        if (response.body() != null) {
                            movies = response.body().getMovies();
                            if (movies.isEmpty()) {
                                callback.onMoviesNotFound();
                            } else {
                                callback.onMoviesLoaded(movies);
                            }
                        } else {
                            callback.onMoviesNotFound();
                        }
                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onMoviesNotFound();
                    }
                }
        ));

    }
}