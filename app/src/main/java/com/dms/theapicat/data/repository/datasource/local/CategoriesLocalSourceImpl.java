package com.dms.theapicat.data.repository.datasource.local;

import com.dms.theapicat.data.db.dao.CategoriesDao;
import com.dms.theapicat.data.entity.CategoryEntity;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CategoriesLocalSourceImpl implements CategoriesLocalSource {

    private CategoriesDao categoriesDao;

    @Inject
    public CategoriesLocalSourceImpl(CategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }

    @Override
    public Observable<List<CategoryEntity>> getCategories() {
        return Observable.fromCallable(new Callable<List<CategoryEntity>>() {
            @Override
            public List<CategoryEntity> call() throws Exception {
                return categoriesDao.findAllCategory();
            }
        });
    }

    @Override
    public void addCategories(List<CategoryEntity> categoryEntities) {
        categoriesDao.insertAll(categoryEntities);
    }
}
