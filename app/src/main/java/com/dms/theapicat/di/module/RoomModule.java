package com.dms.theapicat.di.module;

import android.app.Application;

import com.dms.theapicat.data.source.local.AppDatabase;
import com.dms.theapicat.data.source.local.CategoriesDao;
import com.dms.theapicat.util.Constans;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;


/**
 * Created by Abed Elaziz Shehadeh on 22, January, 2018
 * elaziz.shehadeh@gmail.com
 */

@Module
public class RoomModule {

    private AppDatabase mAppDatabase;

    public RoomModule(Application application) {
        this.mAppDatabase = Room.databaseBuilder(application, AppDatabase.class, Constans.NAME_DATABASE)
                 /*.addMigrations(MIGRATION_1_2) -- in case of migration*/
                .build();
    }

    @Provides
    AppDatabase provideAppDatabase(){
        return mAppDatabase;
    }

    @Provides
    CategoriesDao provideCarDao(AppDatabase appDatabase){
        return appDatabase.categoriesDao();
    }

}
