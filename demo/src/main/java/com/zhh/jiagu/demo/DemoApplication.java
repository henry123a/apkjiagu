package com.zhh.jiagu.demo;

import android.app.Application;
import android.content.Context;


public class DemoApplication extends Application {

    private static DemoApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

    }


    public static Context getApplication(){
        return instance;
    }


}
