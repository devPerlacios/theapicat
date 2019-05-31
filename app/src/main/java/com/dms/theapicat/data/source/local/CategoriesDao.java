package com.dms.theapicat.data.source.local;

import com.dms.theapicat.data.Category;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by Abed Elaziz Shehadeh on 22, January, 2018
 * elaziz.shehadeh@gmail.com
 */

@Dao
public interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(Category categoryEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Category> items);

    @Query("SELECT * FROM Category")
    List<Category> findAllCategory();

    @Query("SELECT * FROM Category where name LIKE :name")
    Category findCategoryByName(String name);

    @Query("SELECT * FROM Category where id LIKE :id")
    Category findCategoryById(int id);

    @Update
    void updateCategoryById(Category categoryEntity);

    @Query("DELETE FROM Category")
    void deleteAllCategories();

    @Delete
    void deleteCategoryById(Category categoryEntity);

    @Query("SELECT COUNT(id) FROM Category")
    int getNumberOfRows();
}
