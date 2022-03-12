package com.application.parseappchallenge;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.parse.Parse;

public class ParseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialize Parse SDK
        //No need to touch this!
        try {
            ApplicationInfo appInfo = getApplicationContext().getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);

            Parse.initialize(new com.parse.Parse.Configuration.Builder(this)
                    .applicationId(appInfo.metaData.getString("com.parse.APPLICATION_ID"))
                    .clientKey(appInfo.metaData.getString("com.parse.CLIENT_KEY"))
                    .server(appInfo.metaData.getString("com.parse.SERVER_URL"))
                    .build()
            );
        } catch(PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
