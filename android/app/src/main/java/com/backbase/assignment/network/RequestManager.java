package com.backbase.assignment.network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.content.Context;

public class RequestManager
{
    private static RequestManager	instance;
	
    private RequestQueue mRequestQueue;
	
	private RequestManager (Context context)
	{
		mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
	}
	public RequestQueue queue ()
	{
		return mRequestQueue;
	}
	
	public static synchronized RequestManager getInstance (Context context)
	{
		if (instance == null)
		{
			instance = new RequestManager(context);
		}
		return instance;
	}
	
	public static synchronized RequestManager getInstance ()
	{
		if (instance == null)
		{
			throw new IllegalStateException(RequestManager.class.getSimpleName()
					+ " is not initialized, call getInstance(..) method first.");
		}
		return instance;
	}
}