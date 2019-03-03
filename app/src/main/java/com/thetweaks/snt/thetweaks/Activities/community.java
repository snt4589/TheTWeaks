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
import com.thetweaks.snt.thetweaks.Communityclasses.FragmentPopular;
import com.thetweaks.snt.thetweaks.Communityclasses.communityAdapter;
import com.thetweaks.snt.thetweaks.Communityclasses.fragmentCommunity;
import com.thetweaks.snt.thetweaks.R;

public class community extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private communityAdapter adapter;
    private ImageButton msgbtn1,msgbtn2;
    private TextView userName1,userName2;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;

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
    msgbtn1=(ImageButton)findViewById(R.id.messageBtn2);
    msgbtn2=(ImageButton)findViewById(R.id.messageBtn3);
    userName1=(TextView)findViewById(R.id.commname1);
    userName2=(TextView)findViewById(R.id.commname2);
        mAuth = FirebaseAuth.getInstance();
    mUser = mAuth.getCurrentUser();


        msgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser.toString() != userName1.getText().toString()) {
                    UserDetails.chatWith = userName1.getText().toString();
                    startActivity(new Intent(community.this, ChatActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(community.this, ConversationsActivity.class));
                }
            }
        });
        msgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser.toString() != userName2.getText().toString()) {
                    UserDetails.chatWith = userName2.getText().toString();
                    startActivity(new Intent(community.this, ChatActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(community.this, ConversationsActivity.class));
                }
            }
        });


    }
}
