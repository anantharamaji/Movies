package com.ramaji.movies.splash;

public class SplashPresenter implements SplashContract.Presenter{

    private final SplashContract.View mSplashView;

    public SplashPresenter(SplashContract.View splashView) {
        mSplashView = splashView;

        mSplashView.setPresenter(this);
    }

    @Override
    public void start() {
        mSplashView.showStories();
    }

}
