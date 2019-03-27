package com.dms.theapicat;

import com.dms.theapicat.di.AppComponent;
import com.dms.theapicat.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class TheApiCatApp extends DaggerApplication {

    @Override
    protected AndroidInjector<TheApiCatApp> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
