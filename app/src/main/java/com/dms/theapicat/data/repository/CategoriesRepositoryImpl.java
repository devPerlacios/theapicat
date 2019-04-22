package com.dms.theapicat.data.repository;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.data.entity.mapper.EntityDataMapper;
import com.dms.theapicat.data.repository.datasource.local.CategoriesLocalSource;
import com.dms.theapicat.data.repository.datasource.remote.CategoriesRemoteSource;
import com.dms.theapicat.domain.model.Category;
import com.dms.theapicat.domain.repository.CategoriesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class CategoriesRepositoryImpl implements CategoriesRepository {

    private CategoriesRemoteSource categoriesRemoteDataSource;
    private CategoriesLocalSource categoriesLocalSource;
    private EntityDataMapper categoryModelMapper;

    @Inject
    public CategoriesRepositoryImpl(CategoriesRemoteSource categoriesRemoteDataSource,
                                    CategoriesLocalSource categoriesLocalSource,
                                    EntityDataMapper categoryModelMapper) {
        this.categoriesRemoteDataSource = categoriesRemoteDataSource;
        this.categoriesLocalSource = categoriesLocalSource;
        this.categoryModelMapper = categoryModelMapper;
    }

    @Override
    public Observable<List<Category>> getListCategory() {
        return Observable.mergeDelayError(categoriesRemoteDataSource.getCategories().doOnNext(new Consumer<List<CategoryEntity>>() {
                    @Override
                    public void accept(List<CategoryEntity> categoryEntities) throws Exception {
                        categoriesLocalSource.addCategories(categoryEntities);
                    }
                }).subscribeOn(Schedulers.io()), categoriesLocalSource.getCategories().subscribeOn(Schedulers.io())
        ).map(new Function<List<CategoryEntity>, List<Category>>() {
            @Override
            public List<Category> apply(List<CategoryEntity> categoryEntities) throws Exception {
                return categoryModelMapper.transform(categoryEntities);
            }
        });
    }
}
