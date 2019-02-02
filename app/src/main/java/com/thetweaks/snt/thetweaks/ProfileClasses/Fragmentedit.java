package com.thetweaks.snt.thetweaks.ProfileClasses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thetweaks.snt.thetweaks.R;

public class Fragmentedit extends Fragment {
    View v;
    public Fragmentedit() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.edit_fragment,container,false);
        return v;
    }
}
