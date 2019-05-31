package com.dms.theapicat.di.module;

import android.app.Application;
import android.content.Context;

import com.dms.theapicat.data.source.CategoriesDataSource;
import com.dms.theapicat.data.source.CategoriesRepository;
import com.dms.theapicat.data.source.Local;
import com.dms.theapicat.data.source.Remote;
import com.dms.theapicat.data.source.local.CategoriesDao;
import com.dms.theapicat.data.source.local.CategoriesLocalDataSource;
import com.dms.theapicat.data.source.remote.CatServices;
import com.dms.theapicat.data.source.remote.CategoriesRemoteDataSource;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Local
    CategoriesDataSource provideCategoriesLocalSource(CategoriesDao categoriesDao){
        return new CategoriesLocalDataSource(categoriesDao);
    }

    @Provides
    @Remote
    CategoriesDataSource provideRemoteDataSource(CatServices catService) {
        return new CategoriesRemoteDataSource(catService);
    }

    @Provides
    CategoriesRepository provideCategoriesRepository(@Remote CategoriesDataSource categoriesRemoteDataSource,
                                                     @Local CategoriesDataSource categoriesLocalSource) {
        return new CategoriesRepository(categoriesRemoteDataSource, categoriesLocalSource);
    }

}
