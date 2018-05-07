package com.ramaji.movies.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ramaji.movies.R;
import com.ramaji.movies.base.MoviesScheduler;
import com.ramaji.movies.data.api.client.MoviesClient;
import com.ramaji.movies.data.story.MovieRemoteDataSource;
import com.ramaji.movies.data.story.MovieRepository;
import com.ramaji.movies.util.ActivityUtils;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        MoviesFragment moviesFragment = (MoviesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.container);

        if(moviesFragment == null){
            moviesFragment = MoviesFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), moviesFragment, R.id.container);
        }

        MovieRemoteDataSource source = MovieRemoteDataSource.getInstance(new MoviesClient(new MoviesScheduler()));
        MovieRepository repository = MovieRepository.getInstance(source);

        new MoviesPresenter(repository, moviesFragment);
    }

}
