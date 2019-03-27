package com.dms.theapicat.presentation.view.activity;

import android.os.Bundle;

import com.dms.theapicat.R;
import com.dms.theapicat.presentation.presenter.CategoryListPresenter;
import com.dms.theapicat.presentation.view.BaseActivity;
import com.dms.theapicat.presentation.view.CategoryListView;
import com.dms.theapicat.presentation.view.adapter.CategoryAdapter;

import javax.inject.Inject;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListActivity extends BaseActivity implements CategoryListView {

    @Inject
    CategoryListPresenter presenter;

    private CategoryAdapter adapter;

    @BindView(R.id.rvListCategories)
    RecyclerView rvListCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setUpRecyclerView();
        presenter.viewReady();
    }

    public void bindViews(){
        ButterKnife.bind(this);
    }

    private void setUpRecyclerView(){
        adapter = new CategoryAdapter(presenter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListCategories.setLayoutManager(linearLayoutManager);
        rvListCategories.setHasFixedSize(true);
        rvListCategories.setAdapter(adapter);
    }

    @Override
    public void refreshList() {
        adapter.refreshData();
    }

    @Override
    public void cancelRefreshDialog() {

    }
}
