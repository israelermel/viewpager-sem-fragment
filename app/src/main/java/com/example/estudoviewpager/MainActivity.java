package com.example.estudoviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);

        MyPagerAdapter adapter = new MyPagerAdapter();
        mViewPager.setAdapter(adapter); //set adapter to viewpager.
    }

    //Normal pager adapter to handle items inside Viewpager.
    class MyPagerAdapter extends PagerAdapter {

        public Object instantiateItem(ViewGroup collection, int position) {

            int resId = 0;
            switch (position) {
                case 0:
                    resId = R.id.page_one; //pass id of that view to return, Views will be added in XML.
                    break;
                case 1:
                    resId = R.id.page_two;
                    break;
            }
            return findViewById(resId); // return selected view.
        }

        @Override
        public int getCount() {
            return 2; // number of maximum views in View Pager.
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1; // return true if both are equal.
        }
    }

}
