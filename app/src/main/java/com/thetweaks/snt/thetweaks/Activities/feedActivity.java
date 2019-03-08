package com.thetweaks.snt.thetweaks.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.google.firebase.database.*;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.explorerData.Feed;
import com.thetweaks.snt.thetweaks.adapters.FeedAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class feedActivity extends AppCompatActivity {

    private List<Feed> feedsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FeedAdapter mAdapter;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.feed_recycler);

        mAdapter = new FeedAdapter(feedsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


        prepareFeedData();
    }
    //TODO: Still need to customize data to the profile
    private void prepareFeedData() {

        DatabaseReference postsRef = mDatabase.child("posts");
        postsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Log.e("hey its running", "hey now brown");
                    Map<String, String> postMap = (Map<String, String>) snap.getValue();
                    String category = postMap.get("categories");
                    String location = "None";
                    try {
                        location = postMap.get("location");
                    } catch (Exception e) {
                        System.out.println("ERROR" + e.toString());
                    }

                    String imageLink = "code for image";
                    //TODO:this is for when anynode is added you have to make a snapshot for all existing nodes first
                    // imageLink = postMap.get("");
                    String post = postMap.get("post_content");
                    //  String profilePicLink = mDatabase.child("users").child(postMap.get("user_id"));
                    String profilePicLink = postMap.get("post_author");
                    String viewsCount = "1";
                    try {
                        viewsCount = postMap.get("views");
                    } catch (Exception e) {
                        System.out.println("ERROR" + e.toString());
                    }
                    String date = postMap.get("post_date");
                    String topic = postMap.get("post_title");

                    Feed feed = new Feed(category, location, imageLink, post, profilePicLink, viewsCount, date, topic);
                    feedsList.add(feed);

                    Log.e("hey its running", "hey now brown2");
             recyclerView.setAdapter(mAdapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

 mAdapter.notifyDataSetChanged();
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(mAdapter);
    }
}
