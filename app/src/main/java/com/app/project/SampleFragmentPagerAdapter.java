package com.app.project;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Usuario", "Personal" };
    public Context context;


    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return register1.newInstance(position);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return register2.newInstance(position);
            default:
                return null;
        }

        }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

//    public  View getTabView(int position) {
//        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
//
//        View v = LayoutInflater.from(context).inflate(R.layout.fragment_register2, null);
//        return v;
//    }
}
