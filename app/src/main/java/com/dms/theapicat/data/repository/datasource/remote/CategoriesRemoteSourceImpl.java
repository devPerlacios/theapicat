package com.dms.theapicat.data.repository.datasource.remote;

import com.dms.theapicat.data.api.CatServices;
import com.dms.theapicat.data.entity.CategoryEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CategoriesRemoteSourceImpl implements CategoriesRemoteSource {

    private CatServices catService;

    @Inject
    public CategoriesRemoteSourceImpl(CatServices catService) {
        this.catService = catService;
    }

    @Override
    public Observable<List<CategoryEntity>> getCategories() {
        return catService.getCategoriesEntity();
    }

}
