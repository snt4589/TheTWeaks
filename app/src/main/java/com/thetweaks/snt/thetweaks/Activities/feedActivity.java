package com.thetweaks.snt.thetweaks.Activities;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.firebase.database.*;
import com.thetweaks.snt.thetweaks.Publish;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.explorerData.Feed;
import com.thetweaks.snt.thetweaks.adapters.FeedAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class feedActivity extends AppCompatActivity implements FeedAdapter.OnPostListener {

    private List<Feed> feedsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FeedAdapter mAdapter;
    private DatabaseReference mDatabase;
    public List<String> data = new ArrayList<>();
    public int position;
    private ImageView feed,comm,publish,explore;
    private Button writeTweaks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.feed_recycler);

        mAdapter = new FeedAdapter(feedsList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


        InitializeUI();
        clicklistener();
        prepareFeedData();
    }
    //TODO: Still need to customize data to the profile
    private void prepareFeedData() {

        DatabaseReference postsRef = mDatabase.child("posts");
        postsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    data.add(snap.getKey());
                    Log.e("hey its running", "hey now brown");
                    Map<String, String> postMap = (Map<String, String>) snap.getValue();
                    String category = postMap.get("categories");
                    String location = "None";
                    try {
                        location = postMap.get("location");
                    } catch (Exception e) {
                        System.out.println("ERROR" + e.toString());
                    }

                    String imageLink = postMap.get("post_image_url");
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
                    String postId = snap.getKey().toString();

                    Feed feed = new Feed(category, location, imageLink, post, profilePicLink, viewsCount, date, topic, postId);
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

    @Override
    public void onPostClick(int position) {
        feedsList.get(position);
        final Feed model = feedsList.get(position);
    Intent intent = new Intent(this,viewpostActivity.class);
    intent.putExtra("postTitle",model.getTopic());
    intent.putExtra("postDate",model.getDate());
    //intent.putExtra("postImage")
    intent.putExtra("category",model.getCategory());
    intent.putExtra("post",model.getPost());
    intent.putExtra("view",model.getViewsCount());
    intent.putExtra("location",model.getLocation());
    intent.putExtra("postId",model.getPostId());
        startActivity(intent);
    }
    private void InitializeUI(){

        //here is the initialization

        feed = (ImageView)findViewById(R.id.feedfee);
        comm = (ImageView)findViewById(R.id.communityfee);
        publish = (ImageView)findViewById(R.id.publishfee);
        explore = (ImageView)findViewById(R.id.explorerfee);
        writeTweaks=(Button)findViewById(R.id.writeTweaks);
    }



    private void  clicklistener(){
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(feedActivity.this, feedActivity.class);
                startActivity(intent);
            }
        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(feedActivity.this,community.class));
            }
        });
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(feedActivity.this, Publish.class));
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(feedActivity.this, explore_Activity.class));
            }
        });
        writeTweaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(feedActivity.this,Publish.class));
            }
        });

    }
}
