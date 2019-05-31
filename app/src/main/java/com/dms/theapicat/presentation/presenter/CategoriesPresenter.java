package com.dms.theapicat.presentation.presenter;

import androidx.recyclerview.widget.RecyclerView;

import com.dms.theapicat.data.Category;
import com.dms.theapicat.domain.DefaultObserver;
import com.dms.theapicat.domain.interactor.GetCategories;
import com.dms.theapicat.presentation.view.categories.CategoryListView;
import com.dms.theapicat.presentation.view.categories.CategoryAdapter;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

public class CategoriesPresenter {

    private GetCategories getCategories;
    private WeakReference<CategoryListView> view;
    private List<Category> categoriesList;

    @Inject
    public CategoriesPresenter(GetCategories getCategories) {
        this.getCategories = getCategories;
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
            Category categoryModel = getCategory(position);
            ((CategoryAdapter.CategoryHolder) viewHolder).setTextName(categoryModel.getName());
        }
    }

    public boolean categoriesListIsEmpty(){
        return categoriesList==null || categoriesList.isEmpty();
    }

    public Category getCategory(int position){
        return categoriesList.get(position);
    }


    public void saveCategories(List<Category> movieList){
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
            CategoriesPresenter.this.showErrorMessage(e.getLocalizedMessage());
        }

        @Override
        public void onNext(List<Category> list) {
            CategoriesPresenter.this.saveCategories(list);
        }
    }

    public void destroy() {
        this.getCategories.dispose();
        this.view = null;
    }

    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

}
