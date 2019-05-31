package com.dms.theapicat.data.source.local;

import com.dms.theapicat.data.Category;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Category.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CategoriesDao categoriesDao();

}
