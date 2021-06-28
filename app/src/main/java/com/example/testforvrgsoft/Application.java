package com.example.testforvrgsoft;

import android.content.Context;

public class Application extends android.app.Application {
    private static Application application = new Application();

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Context getContext() {
        return application;
    }
}
