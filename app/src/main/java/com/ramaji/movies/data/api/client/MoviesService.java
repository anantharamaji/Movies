package com.ramaji.movies.data.api.client;

import com.ramaji.movies.data.response.Data;

import io.reactivex.Observable;
import retrofit2.Response;

public interface MoviesService {

    Observable<Response<Data>> getMovies();

}
