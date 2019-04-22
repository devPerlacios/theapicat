package com.dms.theapicat.di.module;

import com.dms.theapicat.domain.interactor.GetCategories;
import com.dms.theapicat.domain.repository.CategoriesRepository;
import com.dms.theapicat.presentation.model.mapper.ModelMapper;
import com.dms.theapicat.presentation.presenter.CategoryListPresenter;
import com.dms.theapicat.presentation.view.activity.CategoryListActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryListActivityModule {


    @Provides
    GetCategories provideGetCategories(CategoriesRepository repository){
        return new GetCategories(repository);
    }

    @Provides
    CategoryListPresenter providePresenter(GetCategories getCategories, ModelMapper modelMapper){
        return new CategoryListPresenter(getCategories,modelMapper);
    }

}
