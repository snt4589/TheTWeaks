package com.thetweaks.snt.thetweaks.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.thetweaks.snt.thetweaks.*;
import com.thetweaks.snt.thetweaks.ProfileClasses.*;

public class ProfileActivity extends AppCompatActivity  {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ProfilePageAdapter adapter;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_profile);
       // setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if (mUser == null ) {
            // Not signed in
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        } else {
            //mUsername = mUser.getDisplayName();
            //if (mUser.getPhotoUrl() != null) {
                //mPhotoUrl = mUser.getPhotoUrl().toString();
            //}
        }

        tabLayout = (TabLayout)findViewById(R.id.tablayout_id);
        viewPager = (ViewPager)findViewById(R.id.viewer_id);
        adapter = new ProfilePageAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Fragmentabout(),"ABOUT");
        adapter.AddFragment(new Fragmenttweaks(),"TWEAKS");
        adapter.AddFragment(new Fragmentautobiography(),"AUTOBIO");
        adapter.AddFragment(new Fragmentedit(),"EDIT");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }

}

