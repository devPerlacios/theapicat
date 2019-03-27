package com.dms.theapicat.di;

import com.dms.theapicat.di.module.CategoryListActivityModule;
import com.dms.theapicat.presentation.view.activity.CategoryListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = CategoryListActivityModule.class)
    abstract CategoryListActivity bindCategoryListActivity();

}
