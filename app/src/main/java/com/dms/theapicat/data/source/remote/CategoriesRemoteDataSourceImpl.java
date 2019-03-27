package com.dms.theapicat.data.source.remote;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.data.exception.NetworkConnectionException;
import com.dms.theapicat.data.exception.ServiceException;
import com.dms.theapicat.domain.Handler;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRemoteDataSourceImpl implements CategoriesRemoteDataSource {

    private CatService catService;

    @Inject
    public CategoriesRemoteDataSourceImpl(CatService catService) {
        this.catService = catService;
    }

    @Override
    public void getAll(final Handler<List<CategoryEntity>> handler) {
        catService.getCategoriesEntity().enqueue(new Callback<List<CategoryEntity>>() {
            @Override
            public void onResponse(Call<List<CategoryEntity>> call, Response<List<CategoryEntity>> response) {
                if(response.isSuccessful()){
                    handler.handle(response.body());
                } else {
                    handler.error(new ServiceException());
                }
            }

            @Override
            public void onFailure(Call<List<CategoryEntity>> call, Throwable t) {
                handler.error(new NetworkConnectionException());
            }
        });
    }

}
