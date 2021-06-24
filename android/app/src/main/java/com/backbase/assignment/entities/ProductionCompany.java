package com.backbase.assignment.entities;

public class ProductionCompany
{
    private long id;
    private String logoPath;
    private String name;
    private String originCountry;

    public long getID ()
    {
        return id;
    }

    public void setID (long value)
    {
        this.id = value;
    }

    public String getLogoPath ()
    {
        return logoPath;
    }

    public void setLogoPath (String value)
    {
        this.logoPath = value;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String value)
    {
        this.name = value;
    }

    public String getOriginCountry ()
    {
        return originCountry;
    }

    public void setOriginCountry (String value)
    {
        this.originCountry = value;
    }
}
