package com.thetweaks.snt.thetweaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.adapters.comment_adapter;
import com.thetweaks.snt.thetweaks.commentData;
import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class viewpostActivity extends AppCompatActivity {

    private List<commentData> commentData1= new ArrayList<>();
    private RecyclerView recyclerView;
    private comment_adapter comment_adapter;
    private TextView title,view,date,post,category,location;
    private ImageView postImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpost);
        title = (TextView)findViewById(R.id.viewpost_topic);
        date=findViewById(R.id.viewpost_date);
        view=findViewById(R.id.viewpost_views);
        post=findViewById(R.id.viewpost_content);
        category=findViewById(R.id.viewpost_category);
        location=findViewById(R.id.viewpost_location);
        title.setText(getIntent().getStringExtra("postTitle"));
        date.setText(getIntent().getStringExtra("postDate"));
        post.setText(getIntent().getStringExtra("post"));
        category.setText(getIntent().getStringExtra("category"));
        location.setText(getIntent().getStringExtra("location"));
        view.setText(getIntent().getStringExtra("view"));


        recyclerView=(RecyclerView)findViewById(R.id.comment_recycler);
        comment_adapter = new comment_adapter(commentData1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        showcomment();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(comment_adapter);


    }


    private void showcomment(){
commentData ca = new commentData("draker","12 june","asdasdasd","asdasdasd") ;
commentData1.add(ca);
        recyclerView.setAdapter(comment_adapter);
    }
}
