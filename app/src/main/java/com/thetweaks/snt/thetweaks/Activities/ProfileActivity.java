package com.thetweaks.snt.thetweaks.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.thetweaks.snt.thetweaks.*;
import com.thetweaks.snt.thetweaks.ProfileClasses.*;

public class ProfileActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ProfilePageAdapter adapter;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    ImageButton messageBtn;
    TextView userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        messageBtn = (ImageButton) findViewById(R.id.messageBtn);
        userName = (TextView) findViewById(R.id.userName);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
//
//        if (mUser == null) {
//            // Not signed in
//            startActivity(new Intent(this, LoginActivity.class));
//            finish();
//            return;
//        } else {
//            //mUsername = mUser.getDisplayName();
//            //if (mUser.getPhotoUrl() != null) {
//            //mPhotoUrl = mUser.getPhotoUrl().toString();
//            //}
//        }

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewer_id);
        adapter = new ProfilePageAdapter(getSupportFragmentManager());


        adapter.AddFragment(new Fragmenttweaks(), "TWEAKS");
        adapter.AddFragment(new Fragmentautobiography(), "STORY");
        adapter.AddFragment(new Fragmentabout(), "ABOUT");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        messageBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mUser.toString() != userName.getText().toString()) {
//                    UserDetails.chatWith = userName.getText().toString();
//                    startActivity(new Intent(ProfileActivity.this, ChatActivity.class));
//                    finish();
//                } else {
//                    startActivity(new Intent(ProfileActivity.this, ConversationsActivity.class));
//                }
//            }
//        });

    }

    ;
}
