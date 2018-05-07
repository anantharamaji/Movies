package com.ramaji.movies.home;

import com.ramaji.movies.base.BasePresenter;
import com.ramaji.movies.base.BaseView;
import com.ramaji.movies.data.response.Movie;

import java.util.List;

public interface MoviesContract {

    interface View extends BaseView<Presenter> {

        void showNoMovies();

        void showMovies(List<Movie> movies);

    }

    interface Presenter extends BasePresenter {

        void loadMovies();

    }

}
