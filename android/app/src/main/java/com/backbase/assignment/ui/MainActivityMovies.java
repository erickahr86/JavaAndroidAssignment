package com.backbase.assignment.ui;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.backbase.assignment.R;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.ui.movie.view.MovieView;
import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.List;

public class MainActivityMovies extends AppCompatActivity implements MovieView
{
    private LinearProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main_movies );

        progressIndicator = findViewById ( R.id.lpi_progress );



    }

    @Override
    public void showProgress ()
    {

    }

    @Override
    public void hideProgress ()
    {

    }

    @Override
    public void setError (String error)
    {

    }

    @Override
    public void setResultsContent (List<Result> results)
    {

    }
}