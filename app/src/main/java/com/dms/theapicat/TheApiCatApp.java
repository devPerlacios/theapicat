package com.dms.theapicat;

import android.app.Application;

import com.dms.theapicat.di.AppComponent;
import com.dms.theapicat.di.DaggerAppComponent;
import com.dms.theapicat.di.module.ApiModule;
import com.dms.theapicat.di.module.ApplicationModule;
import com.dms.theapicat.di.module.CategoryListActivityModule;
import com.dms.theapicat.di.module.RoomModule;


public class TheApiCatApp extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .categoryListActivityModule(new CategoryListActivityModule())
                .roomModule(new RoomModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }

}
