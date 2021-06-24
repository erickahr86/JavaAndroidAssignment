package com.backbase.assignment.entities;

import android.annotation.SuppressLint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.backbase.assignment.globals.Constants.FORMATER_PATTERN;
import static com.backbase.assignment.globals.Constants.PARSER_PATTERN;

public class Movie implements Serializable
{
    private boolean                 adult;
    private String                  backdropPath;
    private Object                  belongsToCollection;
    private long                    budget;
    private final List<Genre>       genres;
    private String                  homepage;
    private long                    id;
    private String                  imdbID;
    private String                  originalLanguage;
    private String                  originalTitle;
    private final String            overview;
    private double                  popularity;
    private final String            posterPath;
    private List<ProductionCompany> productionCompanies;
    private List<ProductionCountry> productionCountries;
    private Date                    releaseDate;
    private long                    revenue;
    private long                    runtime;
    private List<SpokenLanguage>    spokenLanguages;
    private String                  status;
    private String                  tagline;
    private final String            title;
    private boolean                 video;
    private double                  voteAverage;
    private long                    voteCount;

        public Movie (JSONObject jsMovie )
    {
        String sDate = "";
        this.genres  = new ArrayList<> ();

        this.title      = jsMovie.optString ("title"       );
        this.overview   = jsMovie.optString ("overview"    );
        this.posterPath = jsMovie.optString ("poster_path" );

        try
        {
            sDate = jsMovie.optString  ("release_date" ) ;

            JSONArray jsGenres = jsMovie.getJSONArray ( "genres" ) ;
            for ( int i = 0; i < jsGenres.length (); i++ )
            {
                JSONObject jsGen = jsGenres.getJSONObject ( i );

                Genre genre = new Genre();
                genre.setID   ( jsGen.optInt    ("id") );
                genre.setName ( jsGen.optString ("name") );

                this.genres.add ( genre );
            }
        }
        catch ( JSONException e )
        {
            e.printStackTrace ();
        }

        @SuppressLint ("SimpleDateFormat")
        SimpleDateFormat parser = new SimpleDateFormat( PARSER_PATTERN );
        try
        {
            this.releaseDate =   parser.parse(sDate);
        }
        catch ( ParseException e )
        {
            e.printStackTrace ();
        }
    }

    public boolean isAdult ()
    {
        return adult;
    }

    public String getBackdropPath ()
    {
        return backdropPath;
    }

    public Object getBelongsToCollection ()
    {
        return belongsToCollection;
    }

    public long getBudget ()
    {
        return budget;
    }

    public List<Genre> getGenres ()
    {
        return genres;
    }

    public String getHomepage ()
    {
        return homepage;
    }

    public long getId ()
    {
        return id;
    }

    public String getImdbID ()
    {
        return imdbID;
    }

    public String getOriginalLanguage ()
    {
        return originalLanguage;
    }

    public String getOriginalTitle ()
    {
        return originalTitle;
    }

    public String getOverview ()
    {
        return overview;
    }

    public double getPopularity ()
    {
        return popularity;
    }

    public String getPosterPath ()
    {
        return posterPath;
    }

    public List<ProductionCompany> getProductionCompanies ()
    {
        return productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries ()
    {
        return productionCountries;
    }

    public String getReleaseDate ()
    {
        if ( releaseDate == null )
        {
            return "";
        }

        SimpleDateFormat formatter = new SimpleDateFormat(FORMATER_PATTERN);
        return formatter.format ( releaseDate );
    }

    public long getRevenue ()
    {
        return revenue;
    }

    public long getRuntime ()
    {
        return runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages ()
    {
        return spokenLanguages;
    }

    public String getStatus ()
    {
        return status;
    }

    public String getTagline ()
    {
        return tagline;
    }

    public String getTitle ()
    {
        return title;
    }

    public boolean isVideo ()
    {
        return video;
    }

    public double getVoteAverage ()
    {
        return voteAverage;
    }

    public long getVoteCount ()
    {
        return voteCount;
    }
}
