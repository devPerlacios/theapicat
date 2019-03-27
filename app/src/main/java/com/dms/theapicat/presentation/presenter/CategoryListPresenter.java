package com.dms.theapicat.presentation.presenter;

import android.util.Log;

import com.dms.theapicat.domain.Handler;
import com.dms.theapicat.domain.interactor.UseCase;
import com.dms.theapicat.domain.interactor.UseCaseFactory;
import com.dms.theapicat.domain.model.CategoryModel;
import com.dms.theapicat.presentation.view.CategoryCellView;
import com.dms.theapicat.presentation.view.CategoryListView;
import com.dms.theapicat.presentation.view.adapter.CategoryAdapter;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;

public class CategoryListPresenter implements Handler<List<CategoryModel>> {

    private WeakReference<CategoryListView> view;
    private UseCaseFactory useCaseFactory;
    private List<CategoryModel> categoriesList;

    @Inject
    public CategoryListPresenter(UseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    public void setView(CategoryListView view){
        this.view = new WeakReference<>(view);;
    }

    public void viewReady(){
        invokeUseCase();
    }

    public void refresh(){
        invokeUseCase();
    }

    private void invokeUseCase(){
        UseCase useCase = useCaseFactory.getCategories();
        useCase.execute(this, null);
    }

    public int getItemsCount(){
        if(categoriesListIsEmpty()){
            return 1;
        } else{
            return categoriesList.size();
        }
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

    @Override
    public void handle(List<CategoryModel> result) {
        saveMovies(result);
        CategoryListView movieListView = view.get();
        if(movieListView!=null){
            movieListView.cancelRefreshDialog();
            movieListView.refreshList();
        }
    }

    @Override
    public void error(Exception exception) {
        CategoryListView movieListView = view.get();
        if(movieListView!=null){
            movieListView.cancelRefreshDialog();
            movieListView.showErrorMessage(exception.getMessage());
        }
    }

    public void saveMovies(List<CategoryModel> movieList){
        this.categoriesList = movieList;
    }

    public List<CategoryModel> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<CategoryModel> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
