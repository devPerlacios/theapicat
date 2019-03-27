package com.dms.theapicat.domain.interactor;

import com.dms.theapicat.domain.CategoriesRepository;
import com.dms.theapicat.domain.Handler;
import com.dms.theapicat.domain.model.CategoryModel;

import java.util.List;


public class GetCategories implements UseCase<List<CategoryModel>, Void> {

    private CategoriesRepository repository;

    public GetCategories(CategoriesRepository repository){
        this.repository = repository;
    }

    @Override
    public void execute(Handler<List<CategoryModel>> handler, Void params) {
        repository.getMovies(new Handler<List<CategoryModel>>() {
            @Override
            public void handle(List<CategoryModel> categoryModelList) {
                handler.handle(categoryModelList);
            }

            @Override
            public void error(Exception exception) {
                handler.error(exception);
            }
        });
    }
}
