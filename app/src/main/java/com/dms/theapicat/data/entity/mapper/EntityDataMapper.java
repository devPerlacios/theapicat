package com.dms.theapicat.data.entity.mapper;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.domain.model.Category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntityDataMapper {

    @Inject
    public EntityDataMapper() {
    }

    public Category transform(CategoryEntity categoryEntity){
        Category categoryModel = null;
        if(categoryEntity !=null){
            categoryModel = new Category(categoryEntity.getId(), categoryEntity.getName());
        }
        return categoryModel;
    }

    public List<Category> transform(List<CategoryEntity> categories){
        List<Category> categoryModels = new ArrayList<>();
        if(categories!=null){
            for(CategoryEntity categoryEntity : categories){
                if(categoryEntity !=null){
                    categoryModels.add(transform(categoryEntity));
                }
            }
        }
        return categoryModels;
    }
}
