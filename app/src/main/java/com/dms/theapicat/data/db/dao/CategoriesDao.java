package com.dms.theapicat.data.db.dao;

import com.dms.theapicat.data.entity.CategoryEntity;
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
    void insertCategory(CategoryEntity categoryEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CategoryEntity> items);

    @Query("SELECT * FROM category")
    List<CategoryEntity> findAllCategory();

    @Query("SELECT * FROM category where name LIKE :name")
    CategoryEntity findCategoryByName(String name);

    @Query("SELECT * FROM category where id LIKE :id")
    CategoryEntity findCategoryById(int id);

    @Update
    void updateCategoryById(CategoryEntity categoryEntity);

    @Query("DELETE FROM category")
    void deleteAllCategories();

    @Delete
    void deleteCategoryById(CategoryEntity categoryEntity);

    @Query("SELECT COUNT(id) FROM category")
    int getNumberOfRows();
}
