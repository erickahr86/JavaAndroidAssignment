package com.backbase.assignment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.backbase.assignment.R;
import com.backbase.assignment.entities.Movie;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.ui.movie.DetailActivity;
import com.backbase.assignment.ui.movie.adapters.PlayingNowAdapter;
import com.backbase.assignment.ui.movie.adapters.PopularAdapter;
import com.backbase.assignment.ui.movie.interactor.MovieInteractor;
import com.backbase.assignment.ui.movie.presenter.MoviePresenter;
import com.backbase.assignment.ui.movie.view.ItemClickListener;
import com.backbase.assignment.ui.movie.view.MovieView;
import com.backbase.assignment.ui.movie.view.OnBottomReachedListener;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivityMovies extends AppCompatActivity implements MovieView, ItemClickListener, OnBottomReachedListener
{
    private LinearProgressIndicator progressIndicator ;
    private ConstraintLayout    baseView     ;
    private RecyclerView        rvPlayingNow ;
    private RecyclerView        rvPopular    ;
    private MoviePresenter      presenter    ;
    private int                 pageNumber   ;

    private PopularAdapter      pAdapter     ;
    private List< Result >      populars     ;

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
        progressIndicator.setVisibility (View.INVISIBLE);
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
        pnAdapter   .setClickListener ( this          );
        rvPlayingNow.setLayoutManager ( layoutManager );
        rvPlayingNow.setAdapter       ( pnAdapter     );

        pageNumber = 1;

        presenter.getPopular ( this, pageNumber );
    }

    @Override
    public void setPopularContent ( List<Result> results )
    {
        if ( pageNumber > 1 )
        {
            populars.addAll ( results );
            pAdapter.notifyDataSetChanged ();

            Log.d ("TAG", "setPopularContent: " + populars.size ());
            return;
        }
        else
        {
            populars = results;
        }

        pAdapter      = new PopularAdapter ( populars );

        LinearLayoutManager layoutManager = new LinearLayoutManager (this);

        pAdapter .setClickListener           ( this          );
        pAdapter .setOnBottomReachedListener ( this          );
        rvPopular.setLayoutManager           (layoutManager);
        rvPopular.setAdapter                 ( pAdapter      );
    }

    @Override
    public void setDetailContent (Movie movie)
    {
        Intent intent = new Intent (this, DetailActivity.class);
        intent.putExtra ( "movie", movie );
        startActivity ( intent );
    }

    @Override
    public void onItemClick ( long idItem)
    {
        presenter.getMovie (this, idItem );
    }

    @Override
    public void onBottomReached (int position)
    {
        pageNumber++;
        presenter.getPopular ( this, pageNumber );

    }
}