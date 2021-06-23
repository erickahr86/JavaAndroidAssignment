package com.backbase.assignment.ui.movie.interactor;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.network.JSONReq;
import com.backbase.assignment.network.RequestManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.backbase.assignment.globals.Constants.baseUrl;
import static com.backbase.assignment.globals.Constants.yourKey;

public class MovieInteractor
{
    public void GetPlayingNow( Context context, final OnFinishedListener listener )
    {
        String endpointString = baseUrl + "/movie/now_playing?language=en-US&page=undefined&api_key=" + yourKey;

        JSONReq jsonreq = new JSONReq ( Request.Method.GET, endpointString, null,
                playingNowSuccessful( listener ), onError ( listener )
        );

        jsonreq.setShouldCache ( false );
        RequestManager.getInstance( context ).queue().add ( jsonreq );
    }

    public void GetPopular ( Context context, int page_number, final OnFinishedListener listener )
    {
        String endpointString = baseUrl + "/movie/popular?language=en-US&page=" + page_number + "&api_key=" + yourKey;

        JSONReq jsonreq = new JSONReq (Request.Method.GET, endpointString, null,
                popularSuccessful (listener), onError (listener)
        );

        jsonreq.setShouldCache (false);
        RequestManager.getInstance (context).queue ().add (jsonreq);
    }

    private Response.Listener<JSONObject> playingNowSuccessful( final OnFinishedListener listener )
    {
        return new Response.Listener<JSONObject> ()
        {
            @Override
            public void onResponse (JSONObject response)
            {
                List<Result> resultList = new ArrayList<> ();

                try
                {
                    JSONArray jsResults = response.getJSONArray ("results");

                    for ( int i = 0; i < jsResults.length (); i++)
                    {
                        Result result = new Result ( jsResults.getJSONObject ( i ) );

                        resultList.add ( result );
                    }
                }
                catch ( JSONException e )
                {
                    listener.onGetDataError ( e.getMessage () );
                    e.printStackTrace ();
                }


                listener.onGetPlayingNowSuccess ( resultList );
            }
        };
    }

    private Response.ErrorListener onError (final OnFinishedListener listener )
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


    private Response.Listener<JSONObject> popularSuccessful( final OnFinishedListener listener )
    {
        return new Response.Listener<JSONObject> ()
        {
            @Override
            public void onResponse (JSONObject response)
            {
                List<Result> resultList = new ArrayList<> ();

                try
                {
                    JSONArray jsResults = response.getJSONArray ("results");

                    for ( int i = 0; i < jsResults.length (); i++)
                    {
                        Result result = new Result ( jsResults.getJSONObject ( i ) );

                        resultList.add ( result );
                    }
                }
                catch ( JSONException e )
                {
                    listener.onGetDataError ( e.getMessage () );
                    e.printStackTrace ();
                }

                listener.onGetPopularSuccess ( resultList );
            }
        };
    }

    public interface OnFinishedListener
    {
        void onGetDataError (String error);

        void onGetPlayingNowSuccess (List<Result> results);

        void onGetPopularSuccess (List<Result> results);
    }
}
