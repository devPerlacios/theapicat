package com.dms.theapicat.di.module;

import android.app.Application;
import android.content.Context;

import com.dms.theapicat.data.entity.mapper.EntityDataMapper;
import com.dms.theapicat.data.source.CategoriesRepositoryImpl;
import com.dms.theapicat.data.source.remote.CatService;
import com.dms.theapicat.data.source.remote.CategoriesRemoteDataSource;
import com.dms.theapicat.data.source.remote.CategoriesRemoteDataSourceImpl;
import com.dms.theapicat.domain.CategoriesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    CategoriesRemoteDataSource provideRemoteDataSource(CatService catService) {
        return new CategoriesRemoteDataSourceImpl(catService);
    }

    @Provides
    @Singleton
    CategoriesRepository provideRepository(CategoriesRemoteDataSource categoriesRemoteDataSource,
                                           EntityDataMapper entityDataMapper) {
        return new CategoriesRepositoryImpl(categoriesRemoteDataSource, entityDataMapper);
    }

}
