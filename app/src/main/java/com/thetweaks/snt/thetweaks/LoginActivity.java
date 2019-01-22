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
    RelativeLayout r1 ,r2;
    AnimatorSet animatorSet;
    AnimatorSet animatorSet2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
//Initialize elements
        r1=(RelativeLayout)findViewById(R.id.relativeLayout1);
        r2=(RelativeLayout)findViewById(R.id.relativeLayout2);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.login_button);


        email.setOnClickListener(this);
        password.setOnClickListener(this);
        b1.setOnClickListener(this);



        animatorSet = new AnimatorSet();
        animatorSet2 = new AnimatorSet();



       // r1.setBackgroundColor(Color.parseColor("#80000"));






    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.email:
//                r1.setBackgroundColor(Color.parseColor("#62F51F"));
//                ObjectAnimator fadeout = ObjectAnimator.ofFloat(r1,"alpha",0.5f,0.0f);
//                fadeout.setDuration(500);
//
//                ObjectAnimator fadein=ObjectAnimator.ofFloat(r1,"alpha",0.0f,0.5f);
//                fadein.setDuration(500);
//
//                animatorSet.play(fadein).after(fadeout);
//
//                animatorSet.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationStart(Animator animation, boolean isReverse) {
//                    animatorSet.setDuration(1);
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        animatorSet.start();
//
//                    }
//                });
                //animatorSet.start();


                //animatorSet.end();
              // r1.setBackgroundColor(0);




                break;

            case R.id.password:
//                r2.setBackgroundColor(Color.parseColor("#62F51F"));
//                ObjectAnimator fadeout1 = ObjectAnimator.ofFloat(r2,"alpha",0.5f,0.0f);
//                fadeout1.setDuration(500);
//
//                ObjectAnimator fadein1=ObjectAnimator.ofFloat(r2,"alpha",0.0f,0.5f);
//                fadein1.setDuration(500);
//
//                animatorSet2.play(fadein1).after(fadeout1);
//
//                animatorSet2.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationStart(Animator animation, boolean isReverse) {
//                        animatorSet2.setDuration(1);
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//
//                        animatorSet2.start();
//                    }
//                });//animatorSet.setCurrentPlayTime(1000);
//                animatorSet2.start();
               // r2.setBackgroundColor(0);

                //animatorSet.end();

                break;

            case R.id.login_button:
                    b1.setBackgroundResource(R.drawable.btn_afterpressed);
//                Intent intent = new Intent(this,MainActivity.class);
//                startActivity(intent);
                break;

        }

    }
}
