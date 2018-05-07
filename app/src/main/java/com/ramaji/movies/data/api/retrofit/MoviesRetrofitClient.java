package com.ramaji.movies.data.api.retrofit;

import com.ramaji.movies.data.api.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRetrofitClient {

    private MoviesRetrofitService moviesRetrofitService;

    public MoviesRetrofitClient() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        moviesRetrofitService = retrofit.create(getMovieServiceClass());
    }

    private Retrofit retrofitBuilder() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .baseUrl(Constants.TMDB_API)
                .build();
    }

    private OkHttpClient getOkHttpClient() {
        MoviesInterceptor interceptor = new MoviesInterceptor();
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder()
                .addInterceptor(interceptor);
        return okHttp.build();
    }


    private Class<MoviesRetrofitService> getMovieServiceClass() {
        return MoviesRetrofitService.class;
    }

    protected MoviesRetrofitService getMovieService() {
        return moviesRetrofitService;
    }

}
