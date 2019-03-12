package com.thetweaks.snt.thetweaks.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.*;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.adapters.comment_adapter;
import com.thetweaks.snt.thetweaks.commentData;
import com.thetweaks.snt.thetweaks.explorerData.Feed;
import com.thetweaks.snt.thetweaks.explorerData.User;
import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class viewpostActivity extends AppCompatActivity {

    private List<commentData> commentData1= new ArrayList<>();
    private RecyclerView recyclerView;
    private comment_adapter comment_adapter;
    private TextView title,view,date,post,category,location;
    private String postId;
    private ImageView postImage;
    private DatabaseReference mDatabase;


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
        postId = getIntent().getStringExtra("postId");


        recyclerView=(RecyclerView)findViewById(R.id.comment_recycler);
        comment_adapter = new comment_adapter(commentData1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        showcomment();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(comment_adapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();


    }


    private void showcomment(){
        mDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference commentsRef = mDatabase.child("comments");
        Query query = commentsRef.orderByChild("post_id").equalTo(postId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    Map<String, String> commentMap = (Map<String, String>) snap.getValue();
                    String name = commentMap.get("user_id");
                    String date = commentMap.get("comment_date");
                    String comment = commentMap.get("comment");
                    String image = commentMap.get("user_id");


                    commentData ca = new commentData(name, date, comment, image);
                    commentData1.add(ca);
                    recyclerView.setAdapter(comment_adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




//commentData ca = new commentData("draker","12 june","asdasdasd","asdasdasd") ;
//commentData1.add(ca);
  //      recyclerView.setAdapter(comment_adapter);
    }
}
