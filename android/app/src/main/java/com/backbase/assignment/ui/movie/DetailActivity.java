package com.backbase.assignment.ui.movie;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.backbase.assignment.R;
import com.backbase.assignment.entities.Movie;
import com.backbase.assignment.ui.movie.adapters.GenresAdapter;
import com.backbase.assignment.ui.movie.adapters.PlayingNowAdapter;
import com.squareup.picasso.Picasso;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static com.backbase.assignment.globals.Constants.posterUrl;

public class DetailActivity extends Activity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detail);

        Movie mMovie = (Movie) getIntent().getSerializableExtra("movie");

        if ( mMovie == null )
        {
            finish ();
            return;
        }

        initActivity( mMovie );
    }

    private void initActivity (Movie mMovie)
    {
        ImageButton  btBack        = findViewById ( R.id.go_back          );
        ImageView    ivPoster      = findViewById ( R.id.poster           );
        TextView     tvTitulo      = findViewById ( R.id.title            );
        TextView     tvReleaseDate = findViewById ( R.id.releaseDate      );
        TextView     tvOverview    = findViewById ( R.id.overview_content );
        RecyclerView rvGenres      = findViewById ( R.id.rv_genres        );

        tvTitulo     .setText ( mMovie.getTitle       () );
        tvReleaseDate.setText ( mMovie.getReleaseDate () );
        tvOverview   .setText ( mMovie.getOverview    () );

        Picasso.get().load   ( posterUrl + mMovie.getPosterPath () )
                .placeholder ( R.drawable.progress_animator              )
                .centerCrop  (  )
                .fit         (  )
                .into        ( ivPoster ) ;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GenresAdapter       genresAdapter = new GenresAdapter ( mMovie.getGenres () );

        rvGenres.setLayoutManager ( layoutManager );
        rvGenres.setAdapter       ( genresAdapter );

        btBack.setOnClickListener (view -> finish ());
    }
}