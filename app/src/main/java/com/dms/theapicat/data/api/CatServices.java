package com.dms.theapicat.data.api;

import com.dms.theapicat.data.entity.CategoryEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CatServices {

    @GET("v1/categories")
    Observable<List<CategoryEntity>> getCategoriesEntity();
}
