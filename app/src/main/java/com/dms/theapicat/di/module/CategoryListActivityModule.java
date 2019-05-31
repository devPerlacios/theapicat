package com.dms.theapicat.di.module;

import com.dms.theapicat.data.source.CategoriesRepository;
import com.dms.theapicat.domain.interactor.GetCategories;
import com.dms.theapicat.presentation.presenter.CategoriesPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryListActivityModule {


    @Provides
    GetCategories provideGetCategories(CategoriesRepository repository){
        return new GetCategories(repository);
    }

    @Provides
    CategoriesPresenter providePresenter(GetCategories getCategories){
        return new CategoriesPresenter(getCategories);
    }

}
