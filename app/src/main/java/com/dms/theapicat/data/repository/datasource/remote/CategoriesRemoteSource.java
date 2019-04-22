package com.dms.theapicat.data.repository.datasource.remote;

import com.dms.theapicat.data.entity.CategoryEntity;

import java.util.List;

import io.reactivex.Observable;


public interface CategoriesRemoteSource {

    Observable<List<CategoryEntity>> getCategories();

}
