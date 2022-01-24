package com.fmb.icookproyect_.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

import java.util.Collection;

public class ICookApplication extends Application
{
    private static ICookApplication instance;
    private static Context appContext;

    public static  ICookApplication getInstance(){return instance;}
    public static Context   getAppContext(){return appContext;}

    public void setAppContext(Context mAppContext){this.appContext = mAppContext;}

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}