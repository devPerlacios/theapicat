package com.dms.theapicat.data.source;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.data.entity.mapper.EntityDataMapper;
import com.dms.theapicat.data.source.remote.CategoriesRemoteDataSource;
import com.dms.theapicat.domain.Handler;
import com.dms.theapicat.domain.CategoriesRepository;
import com.dms.theapicat.domain.model.CategoryModel;

import java.util.List;

import javax.inject.Inject;


public class CategoriesRepositoryImpl implements CategoriesRepository {

    private CategoriesRemoteDataSource categoriesRemoteDataSource;

    private EntityDataMapper categoryModelMapper;

    @Inject
    public CategoriesRepositoryImpl(CategoriesRemoteDataSource categoriesRemoteDataSource,
                                    EntityDataMapper categoryModelMapper) {
        this.categoriesRemoteDataSource = categoriesRemoteDataSource;
        this.categoryModelMapper = categoryModelMapper;
    }

    @Override
    public void getMovies(final Handler<List<CategoryModel>> handler) {
        categoriesRemoteDataSource.getAll(new Handler<List<CategoryEntity>>() {
            @Override
            public void handle(List<CategoryEntity> categoryEntities) {
                //TODO
//                localDataSource.deleteAll();
//                localDataSource.save(movieEntityList);
                handler.handle(categoryModelMapper.transform(categoryEntities));
            }
            @Override
            public void error(Exception exception) {
                handler.error(exception);
            }
        });
    }
}
