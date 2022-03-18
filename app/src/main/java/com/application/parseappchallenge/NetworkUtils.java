package com.application.parseappchallenge;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkUtils {

    public static  boolean checkInternetConnection(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected());
    }
}