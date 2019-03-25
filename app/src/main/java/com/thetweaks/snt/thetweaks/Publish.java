package com.thetweaks.snt.thetweaks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import com.thetweaks.snt.thetweaks.Activities.community;
import com.thetweaks.snt.thetweaks.Activities.explore_Activity;
import com.thetweaks.snt.thetweaks.Activities.feedActivity;

public class Publish extends AppCompatActivity {
    private ImageView feed,comm,publish,explore;
    private Button publishbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        InitializeUI();
        clicklistener();



        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner21);
//create a list of items for the spinner.
        String[] items = new String[]{"Select type of your post", "News", "OriginStory","Idea","Opinion","Experience","Thought","Problem","Others"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
    }
    private void InitializeUI(){

        //here is the initialization

        feed = (ImageView)findViewById(R.id.feedpub);
        comm = (ImageView)findViewById(R.id.communitypub);
        publish = (ImageView)findViewById(R.id.publishpub);
        explore = (ImageView)findViewById(R.id.explorepub);
        publishbtn=(Button)findViewById(R.id.publishbtn);
    }



    private void  clicklistener(){
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Publish.this, feedActivity.class);
                startActivity(intent);
            }
        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Publish.this,community.class));
            }
        });
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Publish.this, Publish.class));
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(Publish.this, explore_Activity.class)); }
        });
        publishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Publish.this,pubilsh_component.class));
            }
        });

    }
}
