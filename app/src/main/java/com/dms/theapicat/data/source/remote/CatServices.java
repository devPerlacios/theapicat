package com.dms.theapicat.data.source.remote;

import com.dms.theapicat.data.Category;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CatServices {

    @GET("v1/categories")
    Observable<List<Category>> getCategoriesEntity();
}
