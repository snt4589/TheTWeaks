package com.thetweaks.snt.thetweaks.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.thetweaks.snt.thetweaks.Communityclasses.FragmentPopular;
import com.thetweaks.snt.thetweaks.Communityclasses.communityAdapter;
import com.thetweaks.snt.thetweaks.Communityclasses.fragmentCommunity;
import com.thetweaks.snt.thetweaks.R;

public class community extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private communityAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

    tabLayout= (TabLayout)findViewById(R.id.tabLayout1);
    viewPager=(ViewPager)findViewById(R.id.viewpage1);
    adapter = new communityAdapter(getSupportFragmentManager());

    adapter.AddFragment(new fragmentCommunity(),"Community");
    adapter.AddFragment(new FragmentPopular(),"Popular");

    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
    }
}
