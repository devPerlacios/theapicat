package com.dms.theapicat.presentation.view;

import com.dms.theapicat.domain.model.CategoryModel;

import java.util.List;

public interface CategoryListView extends BaseView {
    void refreshList();

    void cancelRefreshDialog();
}
