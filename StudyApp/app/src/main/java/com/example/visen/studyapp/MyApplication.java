package com.example.visen.studyapp;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    /** 定义全局上下文*/
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    /** 返回全局上下文*/
    public static Context getContext() {
        return context;
    }
}
