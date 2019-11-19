package com.zingking.eztoastsample;

import android.app.Application;
import android.content.Context;

/**
 * Copyright (c) 2019, Z.kai All rights reserved.
 *
 * @author Z.kai
 * @date 2019/11/19
 * @description
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
}

    public static Context getContext(){
        return context;
    }
}
