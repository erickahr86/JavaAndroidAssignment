package com.backbase.assignment.ui.movie.presenter;

import android.content.Context;

import com.backbase.assignment.entities.Movie;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.ui.movie.interactor.MovieInteractor;
import com.backbase.assignment.ui.movie.view.MovieView;

import java.util.List;

public class MoviePresenter implements MovieInteractor.OnFinishedListener
{
    private final MovieView       movieView       ;
    private final MovieInteractor movieInteractor ;

    public MoviePresenter( MovieView movieView, MovieInteractor movieInteractor  )
    {
        this.movieView       = movieView       ;
        this.movieInteractor = movieInteractor ;
    }

    public void getPlayingNow( Context context )
    {
        if ( movieView != null )
        {
            movieView.showProgress ();
        }

        movieInteractor.GetPlayingNow ( context, this );
    }

    public void getPopular( Context context, int page_number )
    {
        if ( movieView != null )
        {
            movieView.showProgress ();
        }

        movieInteractor.GetPopular ( context, page_number, this );
    }

    public void getMovie( Context context, long id )
    {
        if ( movieView != null )
        {
            movieView.showProgress ();
        }

        movieInteractor.GetMovie ( context, id, this );
    }

    @Override
    public void onGetDataError (String error)
    {
        if ( movieView != null )
        {
            movieView.setError(error);
            movieView.hideProgress();
        }
    }

    @Override
    public void onGetPlayingNowSuccess (List<Result> results )
    {
        if (movieView != null)
        {
            movieView.setPlayingNowContent ( results );
            movieView.hideProgress();
        }
    }

    @Override
    public void onGetPopularSuccess (List<Result> results)
    {
        if (movieView != null)
        {
            movieView.setPopularContent ( results );
            movieView.hideProgress();
        }

    }

    @Override
    public void onGetDetailSuccess (Movie movie)
    {
        if (movieView != null)
        {
            movieView.setDetailContent ( movie );
            movieView.hideProgress();
        }

    }
}
