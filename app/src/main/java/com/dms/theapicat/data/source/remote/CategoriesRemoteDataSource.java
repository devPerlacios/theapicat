package com.dms.theapicat.data.source.remote;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.domain.Handler;

import java.util.List;


public interface CategoriesRemoteDataSource {

    void getAll(Handler<List<CategoryEntity>> handler);

}
