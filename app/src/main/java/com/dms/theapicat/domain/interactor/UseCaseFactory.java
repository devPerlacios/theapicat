package com.dms.theapicat.domain.interactor;

import com.dms.theapicat.domain.CategoriesRepository;

import javax.inject.Inject;


public class UseCaseFactory {

    private CategoriesRepository repository;

    @Inject
    public UseCaseFactory(CategoriesRepository repository){
        this.repository = repository;
    }

    public UseCase getCategories(){
        return new GetCategories(repository);
    }

}
