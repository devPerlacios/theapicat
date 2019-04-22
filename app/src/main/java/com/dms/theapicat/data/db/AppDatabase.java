package com.dms.theapicat.data.db;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.data.db.dao.CategoriesDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Abed Elaziz Shehadeh on 22, January, 2018
 * elaziz.shehadeh@gmail.com
 */

@Database(entities = {CategoryEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CategoriesDao categoriesDao();

    /*
    If a migration happened
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };
    */

}
