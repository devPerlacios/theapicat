package com.dms.theapicat.data.source.remote;

import com.dms.theapicat.data.Category;
import com.dms.theapicat.data.source.CategoriesDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CategoriesRemoteDataSource implements CategoriesDataSource {

    private CatServices catService;

    @Inject
    public CategoriesRemoteDataSource(CatServices catService) {
        this.catService = catService;
    }

    @Override
    public Observable<List<Category>> getCategories() {
        return catService.getCategoriesEntity();
    }

    @Override
    public void addCategories(List<Category> categoryEntities) {

    }
}
