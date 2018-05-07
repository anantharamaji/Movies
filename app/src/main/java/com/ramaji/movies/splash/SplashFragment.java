package com.ramaji.movies.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramaji.movies.R;
import com.ramaji.movies.home.MoviesActivity;

import java.util.Objects;

public class SplashFragment extends Fragment implements SplashContract.View{

    private SplashContract.Presenter mPresenter;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    public SplashFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_splash, container, false);
        mPresenter.start();
        return root;
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showStories() {
        Intent intent = new Intent(getActivity(), MoviesActivity.class);
        startActivity(intent);
    }

}
