package com.thetweaks.snt.thetweaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.thetweaks.snt.thetweaks.R;

public class createTopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_topic);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner21);
//create a list of items for the spinner.
        String[] items = new String[]{"Select topic category", "Acadmics", "Admission","Bussiness","Culture","development","Economics","Education","Health and Medicine","Innovation","Internship and Traning","Lifestyle","Law and Government","Movies and TV","News and Media","Placement","Science","Society","Sports","Startup","Technology","Travel","Others"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
    }
}
