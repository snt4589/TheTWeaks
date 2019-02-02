package com.thetweaks.snt.thetweaks.ProfileClasses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.explorerData.RecyclerviewAdapter;
import com.thetweaks.snt.thetweaks.explorerData.User;

import java.util.ArrayList;
import java.util.List;

public class Fragmenttweaks extends Fragment {
            View v;
            private RecyclerView recyclerView;
            private List<User> mUser;

    public Fragmenttweaks() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.tweak_fragment,container,false);
    recyclerView=(RecyclerView)rootView.findViewById(R.id.profile_recycler);
     RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(getContext(),mUser);
     recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
     recyclerView.setAdapter(recyclerviewAdapter);
     return rootView;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    mUser = new ArrayList<>();

        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));
        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));
        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));
        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));
        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));
        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));
        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));

        mUser.add(new User("deepak Singh", "Apple co-founder Steve Wozniak said Blockchain platform Ethereum technology could be the next Apple", "200", "0", "20 Jan", "Media", "123 Views"));


    }
}
