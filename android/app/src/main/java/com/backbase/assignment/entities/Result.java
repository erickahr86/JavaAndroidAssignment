package com.backbase.assignment.entities;

import android.annotation.SuppressLint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Result
{
    private OriginalLanguage original_language;

    private final boolean    adult;
    private final String     backdrop_path;
    private final List<Long> genre_ids;
    private final long       id;
    private final String     original_title;
    private final String     overview;
    private final double     popularity;
    private final String     poster_path;
    private final LocalDate  release_date;
    private final String     title;
    private final boolean    video;
    private final double     vote_average;
    private final long       vote_count;

    @SuppressLint ("NewApi")
    public Result(JSONObject jsonObject )
    {
        String sDate = "";
        String sLang = "";

        this.genre_ids         = new ArrayList<> ();

        this.adult           = jsonObject.optBoolean ("adult"          ) ;
        this.backdrop_path   = jsonObject.optString  ("backdrop_path"  ) ;
        this.id              = jsonObject.optLong    ("id"             ) ;
        this.original_title  = jsonObject.optString  ("original_title" ) ;
        this.overview        = jsonObject.optString  ("overview"       ) ;
        this.popularity      = jsonObject.optDouble  ("popularity"     ) ;
        this.poster_path     = jsonObject.optString  ("poster_path"    ) ;
        this.title           = jsonObject.optString  ("title"          ) ;
        this.video           = jsonObject.optBoolean ("video"          ) ;
        this.vote_average    = jsonObject.optDouble  ("vote_average"   ) ;
        this.vote_count      = jsonObject.optLong    ("vote_count"     ) ;

        try
        {
            sDate = jsonObject.optString  ("release_date"     );
            sLang = jsonObject.getString  ("original_language");

            JSONArray jsGenres = jsonObject.getJSONArray ( "genre_ids" ) ;
            for ( int i = 0; i < jsGenres.length (); i++ )
            {
                this.genre_ids.add ( jsGenres.getLong ( i ) );

            }
        }
        catch ( JSONException e )
        {
            e.printStackTrace ();
        }

        try
        {
            this.original_language = OriginalLanguage.forValue ( sLang );
        }
        catch ( IOException e )
        {
            this.original_language = OriginalLanguage.EN;
            e.printStackTrace ();
        }

        if ( sDate.equals ("") )
        {
            //Dummy for test
            sDate = "2021-04-22";
        }
        this.release_date = LocalDate.parse ( sDate );
    }

    public boolean isAdult ()
    {
        return adult;
    }

    public String getBackdrop_path ()
    {
        return backdrop_path;
    }

    public List<Long> getGenre_ids ()
    {
        return genre_ids;
    }

    public long getId ()
    {
        return id;
    }

    public OriginalLanguage getOriginal_language ()
    {
        return original_language;
    }

    public String getOriginal_title ()
    {
        return original_title;
    }

    public String getOverview ()
    {
        return overview;
    }

    public double getPopularity ()
    {
        return popularity;
    }

    public String getPoster_path ()
    {
        return poster_path;
    }

    public LocalDate getRelease_date ()
    {
        return release_date;
    }

    public String getTitle ()
    {
        return title;
    }

    public boolean isVideo ()
    {
        return video;
    }

    public double getVote_average ()
    {
        return vote_average;
    }

    public long getVote_count ()
    {
        return vote_count;
    }
}
