package com.thetweaks.snt.thetweaks.Activities;

import com.google.firebase.auth.FirebaseAuth;

public class UserDetails {
    static String username = FirebaseAuth.getInstance().getCurrentUser().toString();
    static String password = "";
    static String chatWith = "";
}
