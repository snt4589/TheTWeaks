package com.thetweaks.snt.thetweaks.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.thetweaks.snt.thetweaks.R;

import java.util.HashMap;
import java.util.Map;


public class ChatActivity extends AppCompatActivity {

    LinearLayout layout;
    RelativeLayout layout2;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;
    Firebase refrence1, refrence2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        layout = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (RelativeLayout) findViewById(R.id.layout2);
        sendButton = (ImageView) findViewById(R.id.sendButton);
        messageArea = (EditText) findViewById(R.id.messageArea);
        scrollView = (ScrollView) findViewById(R.id.scrollView);


        Firebase.setAndroidContext(this);

        refrence1 = new Firebase(getResources().getString(R.string.db_messages) + com.thetweaks.snt.thetweaks.Activities.UserDetails.username + "_" + com.thetweaks.snt.thetweaks.Activities.UserDetails.chatWith);
        refrence2 = new Firebase(getResources().getString(R.string.db_messages) + com.thetweaks.snt.thetweaks.Activities.UserDetails.chatWith + "_" + com.thetweaks.snt.thetweaks.Activities.UserDetails.username);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();

                if (!messageText.equals("")) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("message", messageText);
                    map.put("user", com.thetweaks.snt.thetweaks.Activities.UserDetails.username);
                    refrence1.push().setValue(map);
                    refrence2.push().setValue(map);
                    messageArea.setText("");
                }
            }
        });

        refrence1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map map = dataSnapshot.getValue(Map.class);
                String message = map.get("message").toString();
                String userName = map.get("user").toString();

                if (userName.equals(com.thetweaks.snt.thetweaks.Activities.UserDetails.username)) {
                    addMessageBox("You:-\n" + message, 1);
                } else {
                    addMessageBox(com.thetweaks.snt.thetweaks.Activities.UserDetails.chatWith + ":-\n" + message, 2);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addMessageBox(String message, int type) {
        TextView textView = new TextView(ChatActivity.this);
        textView.setText(message);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp2.weight = 1.0f;

        if (type == 1) {
            lp2.gravity = Gravity.LEFT;
            textView.setBackgroundColor(getResources().getColor(R.color.white));
            textView.setBackgroundResource(R.drawable.rounded_corners);
        } else {
            lp2.gravity = Gravity.RIGHT;
            textView.setBackgroundColor(getResources().getColor(R.color.sent_chat));
            textView.setBackgroundResource(R.drawable.rounded_corners);
        }
        textView.setLayoutParams(lp2);
        layout.addView(textView);
        scrollView.fullScroll(View.FOCUS_DOWN);
    }


}

