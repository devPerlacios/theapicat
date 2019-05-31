package com.dms.theapicat.di;

import com.dms.theapicat.di.module.ApiModule;
import com.dms.theapicat.di.module.ApplicationModule;
import com.dms.theapicat.di.module.CategoryListActivityModule;
import com.dms.theapicat.di.module.RoomModule;
import com.dms.theapicat.presentation.view.categories.CategoriesActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApiModule.class,
        RoomModule.class,
        CategoryListActivityModule.class
})
public interface AppComponent {

    void inject(CategoriesActivity target);

}
