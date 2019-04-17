package com.thetweaks.snt.thetweaks.Communityclasses;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.Activities.ProfileActivity;
import com.thetweaks.snt.thetweaks.R;

import java.util.List;

public class commRecycler extends RecyclerView.Adapter<commRecycler.communityAdapter> {
    Context mContext;
    List<members> mData;

    public commRecycler(Context mContext, List<members> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public communityAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.communityrecycler_data,viewGroup,false);
        communityAdapter communityadapter = new communityAdapter(v);
        return communityadapter;
    }

    @Override
    public void onBindViewHolder(@NonNull communityAdapter communityAdapter, int i) {
communityAdapter.name1.setText(mData.get(i).getName());
    communityAdapter.name2.setText(mData.get(i).getName1());
    communityAdapter.loc1.setText(mData.get(i).getLocation());
    communityAdapter.loc2.setText(mData.get(i).getLocation1());
    communityAdapter.des1.setText(mData.get(i).getDesignation());
    communityAdapter.des2.setText(mData.get(i).getDesignation1());
    communityAdapter.profile1.setImageResource(mData.get(i).getPhoto());
    communityAdapter.profile2.setImageResource(mData.get(i).getPhoto1());
    communityAdapter.layout2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,ProfileActivity.class);
            mContext.startActivity(intent);
        }
    });
    communityAdapter.layout1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, ProfileActivity.class);
            mContext.startActivity(intent);

        }
    });


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class communityAdapter extends RecyclerView.ViewHolder{

        private TextView name1;
        private TextView loc1;
        private TextView des1;
        private ImageView profile1;
        private TextView name2;
        private TextView loc2;
        private TextView des2;
        private ImageView profile2;
        private ConstraintLayout layout1 ,layout2;
        public communityAdapter(@NonNull View itemView) {
            super(itemView);

            name1 = (TextView)itemView.findViewById(R.id.commname1);
            name2 = (TextView)itemView.findViewById(R.id.commname2);
            loc1 = (TextView)itemView.findViewById(R.id.location_id1);
            loc2 = (TextView)itemView.findViewById(R.id.location_id2);
            des1 = (TextView)itemView.findViewById(R.id.desig1);
            des2 = (TextView)itemView.findViewById(R.id.desg2);
            profile1 = (ImageView)itemView.findViewById(R.id.pro1);
            profile2 = (ImageView)itemView.findViewById(R.id.pro2);
            layout1=(ConstraintLayout)itemView.findViewById(R.id.layout1);
            layout2=(ConstraintLayout)itemView.findViewById(R.id.layout2);

        }
    }
}
