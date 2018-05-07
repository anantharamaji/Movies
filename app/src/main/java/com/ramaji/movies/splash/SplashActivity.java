package com.ramaji.movies.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ramaji.movies.R;
import com.ramaji.movies.util.ActivityUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SplashFragment splashFragment = (SplashFragment) getSupportFragmentManager()
                .findFragmentById(R.id.container);

        if(splashFragment == null){
            splashFragment = SplashFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), splashFragment, R.id.container);
        }

        new SplashPresenter(splashFragment);
    }

}
