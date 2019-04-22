package com.dms.theapicat.domain.repository;

import com.dms.theapicat.domain.model.Category;

import java.util.List;

import io.reactivex.Observable;

public interface CategoriesRepository {

    Observable<List<Category>> getListCategory();
}
