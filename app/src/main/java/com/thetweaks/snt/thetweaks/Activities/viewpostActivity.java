package com.thetweaks.snt.thetweaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.adapters.comment_adapter;
import com.thetweaks.snt.thetweaks.commentData;
import org.w3c.dom.Comment;

import java.util.List;

public class viewpostActivity extends AppCompatActivity {

    private List<commentData> commentData;
    private RecyclerView recyclerView;
    private comment_adapter comment_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpost);
        recyclerView=(RecyclerView)findViewById(R.id.comment_recycler);
        comment_adapter = new comment_adapter(commentData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(comment_adapter);

        showcomment();
    }


    private void showcomment(){
        //TODO: here we need to add comment data
    }
}
