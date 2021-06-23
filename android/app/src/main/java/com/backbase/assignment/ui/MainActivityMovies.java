package com.backbase.assignment.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.backbase.assignment.R;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.ui.movie.interactor.MovieInteractor;
import com.backbase.assignment.ui.movie.presenter.MoviePresenter;
import com.backbase.assignment.ui.movie.view.MovieView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivityMovies extends AppCompatActivity implements MovieView
{
    private LinearProgressIndicator progressIndicator;
    private LinearLayout            baseView;
    private RecyclerView            rvPlayingNow;
    private RecyclerView            rvPopular;

    private MoviePresenter          presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main_movies );

        progressIndicator = findViewById ( R.id.lpi_progress     );
        baseView          = findViewById ( R.id.ll_activity_view );
        rvPlayingNow      = findViewById ( R.id.rv_playing_now   );
        rvPopular         = findViewById ( R.id.rv_most_popular  );

        presenter = new MoviePresenter (this, new MovieInteractor () );
        presenter.getPlayingNow ( this );
    }

    @Override
    public void showProgress ()
    {
        progressIndicator.setVisibility (View.VISIBLE);
    }

    @Override
    public void hideProgress ()
    {
        progressIndicator.setVisibility (View.GONE);
    }

    @Override
    public void setError (String error)
    {
        Snackbar.make ( baseView, error, BaseTransientBottomBar.LENGTH_LONG ).show ();

    }

    @Override
    public void setPlayingNowContent (List<Result> results)
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        PlayingNowAdapter pnAdapter = new PlayingNowAdapter ( results );
        rvPlayingNow.setLayoutManager ( layoutManager );
        rvPlayingNow.setAdapter       ( pnAdapter     );

        presenter.getPopular ( this, 1 );
    }

    @Override
    public void setPopularContent (List<Result> results)
    {
        PopularAdapter pAdapter = new PopularAdapter ( results );
        rvPopular.setLayoutManager ( new LinearLayoutManager( this ) );
        rvPopular.setAdapter       ( pAdapter     );
    }
}