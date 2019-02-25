package com.example.estudoviewpager;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class ViewModel {
    private ViewPager mAdapter;


    public final ObservableList<String> items = new ObservableArrayList<>();
    public final ObservableList<String> items2 = new ObservableArrayList<>();


    OnItemClickListener listener = new OnItemClickListener(){
        @Override
        public void onItemClick(String item) {
            Log.d("israel %s", item);
            nextPage();
        }
    };


    public final ItemBinding<String> itemBinding = ItemBinding.<String>of(BR.item, R.layout.item).bindExtra(BR.listener, listener);


    public ViewModel(ViewPager adapter) {
        mAdapter = adapter;
    }


    public void nextPage() {
        //it doesn't matter if you're already in the last item
        mAdapter.setCurrentItem(mAdapter.getCurrentItem() + 1);
    }

    public void previousPage() {
        //it doesn't matter if you're already in the first item
        mAdapter.setCurrentItem(mAdapter.getCurrentItem() - 1);
    }

    public interface OnItemClickListener {
        void onItemClick(String item);
    }

}
