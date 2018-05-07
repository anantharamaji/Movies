package com.ramaji.movies.data.api.client;

import com.ramaji.movies.base.MoviesScheduler;
import com.ramaji.movies.data.api.retrofit.MoviesRetrofitClient;
import com.ramaji.movies.data.response.Data;

import io.reactivex.Observable;
import retrofit2.Response;

public class MoviesClient extends MoviesRetrofitClient implements MoviesService {

    private MoviesScheduler moviesScheduler;

    public MoviesClient(MoviesScheduler moviesScheduler) {
        this.moviesScheduler = moviesScheduler;
    }

    @Override
    public Observable<Response<Data>> getMovies() {
        return getMovieService().getMovies()
                .subscribeOn(moviesScheduler.io())
                .observeOn(moviesScheduler.ui());
    }
}