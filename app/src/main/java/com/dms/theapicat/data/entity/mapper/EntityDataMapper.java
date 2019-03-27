package com.dms.theapicat.data.entity.mapper;

import com.dms.theapicat.data.entity.CategoryEntity;
import com.dms.theapicat.domain.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntityDataMapper {

    @Inject
    public EntityDataMapper() {
    }

    public CategoryModel transform(CategoryEntity categoryEntity){
        CategoryModel categoryModel = null;
        if(categoryEntity !=null){
            categoryModel = new CategoryModel(categoryEntity.getId(), categoryEntity.getName());
        }
        return categoryModel;
    }

    public List<CategoryModel> transform(List<CategoryEntity> categories){
        List<CategoryModel> categoryModels = new ArrayList<>();
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
