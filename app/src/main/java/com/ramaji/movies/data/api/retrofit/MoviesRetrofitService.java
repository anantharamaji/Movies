package com.ramaji.movies.data.api.retrofit;

import com.ramaji.movies.data.api.Constants;
import com.ramaji.movies.data.response.Data;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface MoviesRetrofitService {

    @GET(Constants.MOVIES)
    Observable<Response<Data>> getMovies();

}
