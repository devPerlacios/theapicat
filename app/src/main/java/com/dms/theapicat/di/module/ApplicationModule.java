package com.dms.theapicat.di.module;

import android.app.Application;
import android.content.Context;

import com.dms.theapicat.data.db.dao.CategoriesDao;
import com.dms.theapicat.data.entity.mapper.EntityDataMapper;
import com.dms.theapicat.data.repository.CategoriesRepositoryImpl;
import com.dms.theapicat.data.api.CatServices;
import com.dms.theapicat.data.repository.datasource.local.CategoriesLocalSource;
import com.dms.theapicat.data.repository.datasource.local.CategoriesLocalSourceImpl;
import com.dms.theapicat.data.repository.datasource.remote.CategoriesRemoteSource;
import com.dms.theapicat.data.repository.datasource.remote.CategoriesRemoteSourceImpl;
import com.dms.theapicat.domain.repository.CategoriesRepository;

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
    CategoriesLocalSource provideCategoriesLocalSource(CategoriesDao categoriesDao){
        return new CategoriesLocalSourceImpl(categoriesDao);
    }

    @Provides
    CategoriesRemoteSource provideRemoteDataSource(CatServices catService) {
        return new CategoriesRemoteSourceImpl(catService);
    }

    @Provides
    CategoriesRepository provideCategoriesRepository(CategoriesRemoteSource categoriesRemoteDataSource,
                                                   CategoriesLocalSource categoriesLocalSource,
                                                   EntityDataMapper entityDataMapper) {
        return new CategoriesRepositoryImpl(categoriesRemoteDataSource, categoriesLocalSource, entityDataMapper);
    }

}
