package com.backbase.assignment.entities;

import java.time.LocalDate;
import java.util.List;

public class Result
{
    private boolean          adult;
    private String           backdropPath;
    private List<Long>       genreIDS;
    private long             id;
    private OriginalLanguage originalLanguage;
    private String           originalTitle;
    private String           overview;
    private double           popularity;
    private String           posterPath;
    private LocalDate        releaseDate;
    private String           title;
    private boolean          video;
    private double           voteAverage;
    private long             voteCount;

    public boolean getAdult ()
    {
        return adult;
    }

    public void setAdult (boolean value)
    {
        this.adult = value;
    }

    public String getBackdropPath ()
    {
        return backdropPath;
    }

    public void setBackdropPath (String value)
    {
        this.backdropPath = value;
    }

    public List<Long> getGenreIDS ()
    {
        return genreIDS;
    }

    public void setGenreIDS (List<Long> value)
    {
        this.genreIDS = value;
    }

    public long getID ()
    {
        return id;
    }

    public void setID (long value)
    {
        this.id = value;
    }

    public OriginalLanguage getOriginalLanguage ()
    {
        return originalLanguage;
    }

    public void setOriginalLanguage (OriginalLanguage value)
    {
        this.originalLanguage = value;
    }

    public String getOriginalTitle ()
    {
        return originalTitle;
    }

    public void setOriginalTitle (String value)
    {
        this.originalTitle = value;
    }

    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String value)
    {
        this.overview = value;
    }

    public double getPopularity ()
    {
        return popularity;
    }

    public void setPopularity (double value)
    {
        this.popularity = value;
    }

    public String getPosterPath ()
    {
        return posterPath;
    }

    public void setPosterPath (String value)
    {
        this.posterPath = value;
    }

    public LocalDate getReleaseDate ()
    {
        return releaseDate;
    }

    public void setReleaseDate (LocalDate value)
    {
        this.releaseDate = value;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String value)
    {
        this.title = value;
    }

    public boolean getVideo ()
    {
        return video;
    }

    public void setVideo (boolean value)
    {
        this.video = value;
    }

    public double getVoteAverage ()
    {
        return voteAverage;
    }

    public void setVoteAverage (double value)
    {
        this.voteAverage = value;
    }

    public long getVoteCount ()
    {
        return voteCount;
    }

    public void setVoteCount (long value)
    {
        this.voteCount = value;
    }
}
