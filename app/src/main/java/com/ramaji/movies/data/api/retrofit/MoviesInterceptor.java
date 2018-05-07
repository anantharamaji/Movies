package com.ramaji.movies.data.api.retrofit;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.ramaji.movies.data.api.Constants.ACCESS_TOKEN;
import static com.ramaji.movies.data.api.Constants.API_KEY;

public class MoviesInterceptor implements Interceptor{

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request original = chain.request();
        HttpUrl httpUrl = original.url();

        HttpUrl url = httpUrl
                .newBuilder()
                .addQueryParameter(API_KEY, ACCESS_TOKEN)
                .build();

        Request request = original
                .newBuilder()
                .url(url)
                .method(original.method(), original.body()).build();
        return chain.proceed(request);

    }

}
