package com.backbase.assignment.network;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONReq extends JsonObjectRequest
{
	public JSONReq( int method, String url, JSONObject jsonRequest, Listener< JSONObject > listener, ErrorListener errorListener )
	{
		super( method, url, jsonRequest, listener, errorListener );

		setRetryPolicy( new DefaultRetryPolicy( 10000, 0, 0 ) );
	}
}