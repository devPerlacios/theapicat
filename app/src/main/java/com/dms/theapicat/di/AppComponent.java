package com.dms.theapicat.di;

import android.app.Application;
import com.dms.theapicat.TheApiCatApp;
import com.dms.theapicat.di.module.ApiCatModule;
import com.dms.theapicat.di.module.AppModule;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ApiCatModule.class,
        ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<TheApiCatApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(TheApiCatApp app);
}
