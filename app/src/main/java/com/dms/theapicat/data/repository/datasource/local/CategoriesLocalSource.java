package com.dms.theapicat.data.repository.datasource.local;

import com.dms.theapicat.data.entity.CategoryEntity;

import java.util.List;

import io.reactivex.Observable;

public interface CategoriesLocalSource {

    Observable<List<CategoryEntity>> getCategories();
    void addCategories(List<CategoryEntity> categoryEntities);
}
