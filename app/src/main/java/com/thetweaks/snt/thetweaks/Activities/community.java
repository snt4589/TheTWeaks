package com.thetweaks.snt.thetweaks.Activities;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.thetweaks.snt.thetweaks.Communityclasses.FragmentPopular;
import com.thetweaks.snt.thetweaks.Communityclasses.communityAdapter;
import com.thetweaks.snt.thetweaks.Communityclasses.fragmentCommunity;
import com.thetweaks.snt.thetweaks.Publish;
import com.thetweaks.snt.thetweaks.R;

public class community extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private communityAdapter adapter;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;
    private ImageView feed,comm,publish,explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

    tabLayout= (TabLayout)findViewById(R.id.category_tab);
    feed = (ImageView)findViewById(R.id.feedCom);
    comm = (ImageView)findViewById(R.id.communityCom);
    publish = (ImageView)findViewById(R.id.publishCom);
    explore = (ImageView)findViewById(R.id.explorerCom);
    viewPager=(ViewPager)findViewById(R.id.viewpage1);


    clicklistener1();
    adapter = new communityAdapter(getSupportFragmentManager());

    adapter.AddFragment(new fragmentCommunity(),"Community");
    adapter.AddFragment(new FragmentPopular(),"Popular");

    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
//
//        mAuth = FirebaseAuth.getInstance();
//    mUser = mAuth.getCurrentUser();





    }

    private void  clicklistener1(){
    feed.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(community.this,feedActivity.class));
        }
    });
    comm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(community.this,community.class));
        }
    });
    publish.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(community.this, Publish.class));
        }
    });
    explore.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(community.this,explore_Activity.class));
        }
    });

    }
}
