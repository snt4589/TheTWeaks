package com.thetweaks.snt.thetweaks.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.thetweaks.snt.thetweaks.Publish;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.explorerData.allTweaks;
import com.thetweaks.snt.thetweaks.explorerData.topTweaks;

public class explore_Activity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private ImageView feed,comm,publish,explore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorer_);

//        newsview=(RecyclerView)findViewById(R.id.post_recycler);
//        newsview.setLayoutManager(new LinearLayoutManager(this));
//        newsview.setAdapter();

        InitializeUI();
        clicklistener();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explorer_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    topTweaks top_tweaks = new topTweaks();
                    return top_tweaks;
                case 1:
                    allTweaks all_tweaks = new allTweaks();
                    return all_tweaks;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }
    private void InitializeUI(){

        //here is the initialization

        feed = (ImageView)findViewById(R.id.feedexp);
        comm = (ImageView)findViewById(R.id.communityexp);
        publish = (ImageView)findViewById(R.id.publishexp);
        explore = (ImageView)findViewById(R.id.explorerexp);
    }



    private void  clicklistener(){
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(explore_Activity.this, feedActivity.class);
                startActivity(intent);
            }
        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(explore_Activity.this,community.class));
            }
        });
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(explore_Activity.this, Publish.class));
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(explore_Activity .this, explore_Activity.class));
            }
        });

    }
}

