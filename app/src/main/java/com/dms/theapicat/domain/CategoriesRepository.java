package com.dms.theapicat.domain;

import com.dms.theapicat.domain.Handler;
import com.dms.theapicat.domain.model.CategoryModel;

import java.util.List;


public interface CategoriesRepository {

    void getMovies(Handler<List<CategoryModel>> handler);

}
