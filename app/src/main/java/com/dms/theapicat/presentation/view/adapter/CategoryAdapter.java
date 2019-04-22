package com.dms.theapicat.presentation.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dms.theapicat.R;
import com.dms.theapicat.presentation.model.CategoryModel;
import com.dms.theapicat.presentation.presenter.CategoryListPresenter;
import com.dms.theapicat.presentation.view.CategoryCellView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int EMPTY_VIEW_TYPE = 1;

    private CategoryListPresenter presenter;

    public CategoryAdapter(CategoryListPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        if(viewType == EMPTY_VIEW_TYPE){
            View view = inflater.inflate(R.layout.empty_view, viewGroup, false);
            return new EmptyViewHolder(view);
        }else{
            View view = inflater.inflate(R.layout.layout_category_item, viewGroup, false);
            return new CategoryHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder categoryHolder, int position) {
        presenter.configureCell(categoryHolder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsCount();
    }

    @Override
    public int getItemViewType(int position) {
        if(presenter.categoriesListIsEmpty()){
            return EMPTY_VIEW_TYPE;
        }
        return super.getItemViewType(position);
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class CategoryHolder extends RecyclerView.ViewHolder
            implements CategoryCellView {

        @BindView(R.id.category_name)
        TextView category_name;

        public CategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setTextName(String name) {
            category_name.setText(name);
        }
    }

}
