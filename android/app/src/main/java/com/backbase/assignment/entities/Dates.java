package com.backbase.assignment.entities;

import java.time.LocalDate;

public class Dates
{
    private LocalDate maximum;
    private LocalDate minimum;

    public LocalDate getMaximum ()
    {
        return maximum;
    }

    public void setMaximum (LocalDate value)
    {
        this.maximum = value;
    }

    public LocalDate getMinimum ()
    {
        return minimum;
    }

    public void setMinimum (LocalDate value)
    {
        this.minimum = value;
    }
}
