package com.backbase.assignment.entities;

import java.util.List;

public class Movie
{
    private Dates        dates;
    private long         page;
    private List<Result> results;
    private long         totalPages;
    private long         totalResults;

    public Dates getDates ()
    {
        return dates;
    }

    public void setDates (Dates value)
    {
        this.dates = value;
    }

    public long getPage ()
    {
        return page;
    }

    public void setPage (long value)
    {
        this.page = value;
    }

    public List<Result> getResults ()
    {
        return results;
    }

    public void setResults (List<Result> value)
    {
        this.results = value;
    }

    public long getTotalPages ()
    {
        return totalPages;
    }

    public void setTotalPages (long value)
    {
        this.totalPages = value;
    }

    public long getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (long value)
    {
        this.totalResults = value;
    }
}
