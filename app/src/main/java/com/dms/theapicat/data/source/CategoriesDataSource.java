package com.dms.theapicat.data.source;

import com.dms.theapicat.data.Category;

import java.util.List;

import io.reactivex.Observable;

public interface CategoriesDataSource {

    Observable<List<Category>> getCategories();
    void addCategories(List<Category> categoryEntities);
}
