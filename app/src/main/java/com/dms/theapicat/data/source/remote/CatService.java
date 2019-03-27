package com.dms.theapicat.data.source.remote;

import com.dms.theapicat.data.entity.CategoryEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatService {

    @GET("v1/categories")
    Call<List<CategoryEntity>> getCategoriesEntity();
}
