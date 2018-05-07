package com.ramaji.movies.splash;


import com.ramaji.movies.base.BasePresenter;
import com.ramaji.movies.base.BaseView;

public interface SplashContract {

    interface View extends BaseView<Presenter> {

        void showStories();

    }
    interface Presenter extends BasePresenter {

    }

}
