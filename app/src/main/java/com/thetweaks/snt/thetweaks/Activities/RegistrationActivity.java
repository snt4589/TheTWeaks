package com.thetweaks.snt.thetweaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.thetweaks.snt.thetweaks.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner categorySpinner, stateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);






        Spinner categorySpinner = (Spinner) findViewById(R.id.category);
        Spinner stateSpinner = (Spinner) findViewById(R.id.state_spinner);


        categorySpinner.setOnItemSelectedListener(this);


        List<String> categories = new ArrayList<String>(Arrays.asList("College /University Student","School",
                "Student","Artist", "Author","Blogger","Banker","Coach","Comedian","Director","Doctor",
                "Employee","Entrepreneur","Engineer","Model","Media People","Film Character","Journalist",
                "Motivational Speaker","News Personality","Photographer","Politician","Public Figure",
                "Scientist","Social Worker","Sportsperson","Teacher","Writer","Other"));

        List<String> states = new ArrayList<String>(Arrays.asList("Andhra Pradesh","Arunachal Pradesh","Assam",
                "Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh",
                "Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh",
                "Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha",
                "Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh"
                ,"Uttarakhand","West Bengal"));



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        ArrayAdapter<String> statesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        categorySpinner.setAdapter(dataAdapter);
        stateSpinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }




}

