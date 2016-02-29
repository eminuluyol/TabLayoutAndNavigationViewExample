package com.taurus.emin.tablayoutandnavigationviewexample.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.taurus.emin.tablayoutandnavigationviewexample.FirstFragment;
import com.taurus.emin.tablayoutandnavigationviewexample.R;
import com.taurus.emin.tablayoutandnavigationviewexample.SecondFragment;
import com.taurus.emin.tablayoutandnavigationviewexample.ThirdFragment;

/**
 * Created by Emin on 2/23/2016.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {

    private final String[] titles;
    //Constructor method
    public TabFragmentAdapter(Context context, FragmentManager fm){
        super(fm);
        titles = new String[] {
                context.getString(R.string.tab_header_first),
                context.getString(R.string.tab_header_second),
                context.getString(R.string.tab_header_third)

        };

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FirstFragment.newInstance();
            case 1:
                return SecondFragment.newInstance();
            default:
                return ThirdFragment.newInstance();

        }
    }

}