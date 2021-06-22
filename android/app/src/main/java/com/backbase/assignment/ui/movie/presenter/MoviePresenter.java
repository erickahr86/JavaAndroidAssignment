package com.backbase.assignment.ui.movie.presenter;

import android.content.Context;

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

    public void getPlayingNow()
    {
        if ( movieView != null )
        {
            movieView.showProgress ();
        }

        movieInteractor.GetPlayingNow ( this );
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
    public void onGetDataSuccess ( List<Result> results )
    {
        if (movieView != null)
        {
            movieView.setResultsContent ( results );
            movieView.hideProgress();
        }
    }
}
