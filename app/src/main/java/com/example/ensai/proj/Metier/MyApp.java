package com.example.ensai.proj.Metier;

import android.app.Application;
import android.content.Context;

/**
 * Created by ensai on 23/05/16.
 */
public class MyApp extends Application {
    //private static MyApp instance;
    private static Context mContext;


    public static Context getContext() {
        //  return instance.getApplicationContext();
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //  instance = this;
        mContext = getApplicationContext();
    }
}
