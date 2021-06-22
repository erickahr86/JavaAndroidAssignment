package com.backbase.assignment.ui.movie.interactor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.network.JSONReq;
import com.backbase.assignment.network.RequestManager;

import org.json.JSONObject;

import java.util.List;

import static com.backbase.assignment.globals.Constants.baseUrl;
import static com.backbase.assignment.globals.Constants.yourKey;

public class MovieInteractor
{
    public void GetPlayingNow( final OnFinishedListener listener )
    {
        String endpointString = baseUrl + "/movie/now_playing?language=en-US&page=undefined&api_key=" + yourKey;

        JSONReq jsonreq = new JSONReq ( Request.Method.GET, endpointString, null,
                playingNowSuccessful( listener ), playingNowError( listener )
        );

        jsonreq.setShouldCache ( false );
        RequestManager.getInstance().queue().add ( jsonreq );
    }

    private Response.Listener<JSONObject> playingNowSuccessful( final OnFinishedListener listener )
    {
        return new Response.Listener<JSONObject> ()
        {
            @Override
            public void onResponse (JSONObject response)
            {
                listener.onGetDataError ("OK");

            }
        };
    }

    private Response.ErrorListener playingNowError( final OnFinishedListener listener )
    {
        return new Response.ErrorListener ()
        {
            @Override
            public void onErrorResponse (VolleyError error)
            {
                listener.onGetDataError ( error.getMessage () );
            }
        };
    }


    public interface OnFinishedListener
    {
        void onGetDataError (String error);

        void onGetDataSuccess (List<Result> results);
    }
}
