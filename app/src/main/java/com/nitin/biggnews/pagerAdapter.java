package com.nitin.biggnews;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {
    int tabCount;
    public pagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new bHomeFragment();
            case 1:
                return new bScienceFragment();
            case 2:
                return new bHealthFragment();
            case 3:
                return new bBuissnesFragment();
            case 4:
                return new bEntertainmentFragment();
            case 5:
                return new bSportsFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
