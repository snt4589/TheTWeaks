package com.thetweaks.snt.thetweaks.Communityclasses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.R;

import java.util.ArrayList;
import java.util.List;

public class fragmentCommunity extends Fragment {


    View v;
    private List<members> lstmembers;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private communityAdapter adapter;

    public fragmentCommunity(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.community_fragment,container,false);
        tabLayout=(TabLayout)v.findViewById(R.id.category_tab);
        viewPager=(ViewPager)v.findViewById(R.id.category_viewer);
        adapter=new communityAdapter(getFragmentManager());
        adapter.AddFragment(new bothFragment(),"Both");
      adapter.AddFragment(new ProfessionFragment(),"Profession Based");
       adapter.AddFragment(new LocationFragment(),"Location Based");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
