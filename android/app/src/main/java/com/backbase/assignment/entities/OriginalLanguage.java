package com.backbase.assignment.entities;

import java.io.IOException;

public enum OriginalLanguage
{
    EN, JA;

    public static OriginalLanguage forValue (String value) throws IOException
    {
        if ( value.equals ("en") ) return EN;
        if ( value.equals ("ja") ) return JA;
        throw new IOException ("Cannot deserialize OriginalLanguage");
    }

    public String toValue ()
    {
        switch ( this )
        {
            case EN:
                return "en";
            case JA:
                return "ja";
        }
        return null;
    }
}
