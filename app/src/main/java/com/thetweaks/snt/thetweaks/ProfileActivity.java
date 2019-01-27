package com.thetweaks.snt.thetweaks;


import android.os.Bundle;
//import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.thetweaks.snt.thetweaks.fragments.FourFragment;
import com.thetweaks.snt.thetweaks.fragments.OneFragment;
import com.thetweaks.snt.thetweaks.fragments.ThreeFragment;
import com.thetweaks.snt.thetweaks.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity {

    private Toolbar toolbar;
    //private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        //tabLayout = (TabLayout) findViewById(R.id.tabs);
        // tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "ABOUT");
        adapter.addFrag(new TwoFragment(), "TWEAKS");
        adapter.addFrag(new ThreeFragment(), "AUTOBIO");
        adapter.addFrag(new FourFragment(), "EDIT");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
