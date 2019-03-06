package com.thetweaks.snt.thetweaks.Activities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.database.*;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.explorerData.Feed;
import com.thetweaks.snt.thetweaks.explorerData.FeedAdapter;

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

        recyclerView = (RecyclerView) findViewById(R.id.feed_recycler);

        mAdapter = new FeedAdapter(feedsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        prepareFeedData();
    }

    private void prepareFeedData() {
        Feed feed = new Feed("News", "Raipur", "image", "This is the sample text for the news content","profile name"
                                ,20, "11-02-2019");
        feedsList.add(feed);
        DatabaseReference postsRef = mDatabase.child("posts");
        postsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Map postMap = dataSnapshot.getValue(Map.class);
                String category = postMap.get("categories").toString();
                String location = "None";
                try {
                    location = postMap.get("location").toString();
                } catch (Exception e) {
                    System.out.println("ERROR" + e.toString());
                }

                String imageLink = postMap.get("imageUrl").toString();
                String post = postMap.get("post_image_url").toString();
                String profilePicLink = mDatabase.child("users").child(postMap.get("user_id").toString()).toString();
                int viewsCount = 1;
                try {
                    viewsCount = ((int) postMap.get("views"));
                } catch (Exception e) {
                    System.out.println("ERROR" + e.toString());
                }
                String date = postMap.get("post_date").toString();

                Feed feed = new Feed(category, location, imageLink, post,profilePicLink,  viewsCount, date);

                feedsList.add(feed);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

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
