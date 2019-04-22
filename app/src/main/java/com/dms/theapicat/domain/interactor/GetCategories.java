package com.dms.theapicat.domain.interactor;

import com.dms.theapicat.domain.model.Category;
import com.dms.theapicat.domain.repository.CategoriesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class GetCategories extends UseCase<List<Category>, Void> {

    private CategoriesRepository repository;

    @Inject
    public GetCategories(CategoriesRepository repository){
        this.repository = repository;
    }

    @Override
    Observable<List<Category>> buildUseCaseObservable(Void aVoid) {
        return repository.getListCategory();
    }

}
