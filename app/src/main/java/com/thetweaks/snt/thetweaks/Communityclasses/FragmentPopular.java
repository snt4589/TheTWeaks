package com.thetweaks.snt.thetweaks.Communityclasses;

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

import java.util.ArrayList;
import java.util.List;

public class FragmentPopular extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<members> lstmembers;
    public FragmentPopular(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.popular_fragment,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.popular_recycler);
        popularRecycler popularRecycler = new popularRecycler(getContext(),lstmembers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(popularRecycler);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstmembers = new ArrayList<>();
        lstmembers.add(new members("Name","location","designation",R.drawable.community,"200"));
    }
}
