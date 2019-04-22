package com.dms.theapicat.presentation.presenter;

import android.util.Log;

import com.dms.theapicat.domain.interactor.DefaultObserver;
import com.dms.theapicat.domain.interactor.GetCategories;
import com.dms.theapicat.domain.model.Category;
import com.dms.theapicat.presentation.model.CategoryModel;
import com.dms.theapicat.presentation.model.mapper.ModelMapper;
import com.dms.theapicat.presentation.view.CategoryListView;
import com.dms.theapicat.presentation.view.adapter.CategoryAdapter;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;

public class CategoryListPresenter {

    private GetCategories getCategories;
    private WeakReference<CategoryListView> view;
    private List<CategoryModel> categoriesList;
    private ModelMapper modelMapper;

    @Inject
    public CategoryListPresenter(GetCategories getCategories, ModelMapper modelMapper) {
        this.getCategories = getCategories;
        this.modelMapper = modelMapper;
    }

    public void setView(CategoryListView view){
        this.view = new WeakReference<>(view);
    }

    public int getItemsCount(){
        if(categoriesListIsEmpty()){
            return 1;
        } else{
            return categoriesList.size();
        }
    }

    public void initialize(){
        this.getCategories.execute(new CategoryListObserver(), null);
    }

    public void configureCell(RecyclerView.ViewHolder viewHolder, int position){
        if (viewHolder instanceof CategoryAdapter.CategoryHolder) {
            CategoryModel categoryModel = getCategory(position);
            ((CategoryAdapter.CategoryHolder) viewHolder).setTextName(categoryModel.getName());
        }
    }

    public boolean categoriesListIsEmpty(){
        return categoriesList==null || categoriesList.isEmpty();
    }

    public CategoryModel getCategory(int position){
        return categoriesList.get(position);
    }


    public void saveCategories(List<CategoryModel> movieList){
        this.categoriesList = movieList;
        this.view.get().renderListCategory();
    }

    private void showErrorMessage(String errorMessage) {
        this.view.get().showError(errorMessage);
    }

    private final class CategoryListObserver extends DefaultObserver<List<Category>> {

        @Override
        public void onComplete() {
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            CategoryListPresenter.this.showErrorMessage(e.getLocalizedMessage());
        }

        @Override
        public void onNext(List<Category> list) {
            CategoryListPresenter.this.saveCategories(modelMapper.transform(list));
        }
    }

    public void destroy() {
        this.getCategories.dispose();
        this.view = null;
    }

    public List<CategoryModel> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<CategoryModel> categoriesList) {
        this.categoriesList = categoriesList;
    }

}
