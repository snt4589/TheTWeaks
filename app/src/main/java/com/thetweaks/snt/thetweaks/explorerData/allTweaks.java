package com.thetweaks.snt.thetweaks.explorerData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thetweaks.snt.thetweaks.R;

import java.util.ArrayList;
import java.util.List;

public class allTweaks extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<User> mUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_tweaks, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.post_recycler);

        RecyclerviewAdapter recyclerAdapter = new RecyclerviewAdapter(getContext(), mUser);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setAdapter(recyclerAdapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser = new ArrayList<>();
        // add new post here
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



