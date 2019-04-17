package com.thetweaks.snt.thetweaks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.thetweaks.snt.thetweaks.adapters.allTopic_adapter;

import java.util.List;

public class allTopics extends AppCompatActivity {
    private List<topTopic>topTopics;
    private RecyclerView recyclerView;
    private allTopic_adapter allTopic_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_topics);
        recyclerView=(RecyclerView)findViewById(R.id.allTweakRecycler);
        allTopic_adapter = new allTopic_adapter(topTopics);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(allTopic_adapter);
        toptopic();

    }


    private void toptopic(){



    }
}
