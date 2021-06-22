package com.backbase.assignment.ui.movie.view;

import com.backbase.assignment.entities.Result;

import java.util.List;

public interface MovieView
{
    void showProgress ();

    void hideProgress ();

    void setError ( String error );

    void setResultsContent ( List<Result> results );
}
