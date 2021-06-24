package com.backbase.assignment.entities;

import java.io.Serializable;

public class Genre implements Serializable
{
    private long id;
    private String name;

    public long getID ()
    {
        return id;
    }

    public void setID (long value)
    {
        this.id = value;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String value)
    {
        this.name = value;
    }
}
