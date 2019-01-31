package com.thetweaks.snt.thetweaks;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfilePageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();


    public ProfilePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int postion) {
return lstFragment.get(postion);


    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitles.get(position);
    }


    public void AddFragment (Fragment fragment, String title){
    lstFragment.add(fragment);
    lstTitles.add(title);


    }




}

