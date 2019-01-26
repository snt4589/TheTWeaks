package com.thetweaks.snt.thetweaks;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email,password,mtxt,fpass,createacc;
    private Button b1;

    AnimatorSet animatorSet;
    AnimatorSet animatorSet2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
//Initialize elements

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.login_button);


        email.setOnClickListener(this);
        password.setOnClickListener(this);
        b1.setOnClickListener(this);



        animatorSet = new AnimatorSet();
        animatorSet2 = new AnimatorSet();









    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.email:





                break;

            case R.id.password:


                break;

            case R.id.login_button:
                b1.setBackgroundResource(R.drawable.button_pressed);

                break;

        }

    }
}
