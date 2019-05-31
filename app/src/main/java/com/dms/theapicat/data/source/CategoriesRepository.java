package com.dms.theapicat.data.source;

import com.dms.theapicat.data.Category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class CategoriesRepository implements CategoriesDataSource {

    private CategoriesDataSource categoriesRemoteDataSource;
    private CategoriesDataSource categoriesLocalDataSource;

    @Inject
    public CategoriesRepository(CategoriesDataSource categoriesRemoteDataSource,
                                CategoriesDataSource categoriesLocalDataSource) {
        this.categoriesRemoteDataSource = categoriesRemoteDataSource;
        this.categoriesLocalDataSource = categoriesLocalDataSource;
    }

    @Override
    public Observable<List<Category>> getCategories() {
        return Observable.mergeDelayError(categoriesRemoteDataSource.getCategories().doOnNext(new Consumer<List<Category>>() {
                    @Override
                    public void accept(List<Category> categoryEntities) throws Exception {
                        categoriesLocalDataSource.addCategories(categoryEntities);
                    }
                }).subscribeOn(Schedulers.io()), categoriesLocalDataSource.getCategories().subscribeOn(Schedulers.io())
        );
    }

    @Override
    public void addCategories(List<Category> categoryEntities) {

    }
}
