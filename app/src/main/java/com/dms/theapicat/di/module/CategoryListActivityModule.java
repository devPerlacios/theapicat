package com.dms.theapicat.di.module;

import com.dms.theapicat.domain.interactor.UseCaseFactory;
import com.dms.theapicat.presentation.presenter.CategoryListPresenter;
import com.dms.theapicat.presentation.view.activity.CategoryListActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryListActivityModule {

    @Provides
    CategoryListPresenter providePresenter(CategoryListActivity activity, UseCaseFactory useCaseFactory){
        CategoryListPresenter presenter = new CategoryListPresenter(useCaseFactory);
        presenter.setView(activity);
        return presenter;
    }

}
