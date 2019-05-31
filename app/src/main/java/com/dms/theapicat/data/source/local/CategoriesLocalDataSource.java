package com.dms.theapicat.data.source.local;

import com.dms.theapicat.data.Category;
import com.dms.theapicat.data.source.CategoriesDataSource;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CategoriesLocalDataSource implements CategoriesDataSource {

    private CategoriesDao categoriesDao;

    @Inject
    public CategoriesLocalDataSource(CategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }

    @Override
    public Observable<List<Category>> getCategories() {
        return Observable.fromCallable(new Callable<List<Category>>() {
            @Override
            public List<Category> call() throws Exception {
                return categoriesDao.findAllCategory();
            }
        });
    }

    @Override
    public void addCategories(List<Category> categoryEntities) {
        categoriesDao.insertAll(categoryEntities);
    }
}
