package com.dms.theapicat.presentation.model.mapper;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.domain.model.Category;
import com.dms.theapicat.presentation.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ModelMapper {

    @Inject
    public ModelMapper() {
    }

    public CategoryModel transform(Category categoryEntity){
        CategoryModel categoryModel = null;
        if(categoryEntity !=null){
            categoryModel = new CategoryModel(categoryEntity.getId(), categoryEntity.getName());
        }
        return categoryModel;
    }

    public List<CategoryModel> transform(List<Category> categories){
        List<CategoryModel> categoryModels = new ArrayList<>();
        if(categories!=null){
            for(Category category : categories){
                if(category !=null){
                    categoryModels.add(transform(category));
                }
            }
        }
        return categoryModels;
    }
}
