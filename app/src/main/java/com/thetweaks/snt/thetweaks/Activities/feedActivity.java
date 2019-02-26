package com.thetweaks.snt.thetweaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.explorerData.Feed;
import com.thetweaks.snt.thetweaks.explorerData.FeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class feedActivity extends AppCompatActivity {

    private List<Feed> feedsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FeedAdapter mAdapter;

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

        prepareFeedData();
    }

    private void prepareFeedData() {
        Feed feed = new Feed("News", "Raipur", "image", "This is the sample text for the news content","profile name"
                                ,20, "11-02-2019");
        feedsList.add(feed);



        mAdapter.notifyDataSetChanged();
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(mAdapter);
    }
}
