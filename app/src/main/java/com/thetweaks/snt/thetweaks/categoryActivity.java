package com.thetweaks.snt.thetweaks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class categoryActivity extends AppCompatActivity {

    private List<category> categoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private categoryadapter categoryadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    recyclerView = (RecyclerView) findViewById(R.id.catgRecycler);
    categoryadapter = new categoryadapter(categoryList);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(categoryadapter);
    prepareCategoryData();
    }
    private void prepareCategoryData(){
        category category = new category("draker","This is the sample text for the news content","2019-jan","40","50","SAMPLE TOPICS","Students","samplepost");
        categoryList.add(category);
        category category1 = new category("draker","This is the sample text for the news content","2019-jan","40","50","SAMPLE TOPICS","Students","samplepost");
        categoryList.add(category1);
        category category2= new category("draker","This is the sample text for the news content","2019-jan","40","50","SAMPLE TOPICS","Students","samplepost");
        categoryList.add(category2);
        category category3= new category("draker","This is the sample text for the news content","2019-jan","40","50","SAMPLE TOPICS","Students","samplepost");
        categoryList.add(category3);
        category category4 = new category("draker","This is the sample text for the news content","2019-jan","40","50","SAMPLE TOPICS","Students","samplepost");
        categoryList.add(category4);
        category category5 = new category("draker","This is the sample text for the news content","2019-jan","40","50","SAMPLE TOPICS","Students","samplepost");
        categoryList.add(category5);



    }
}
