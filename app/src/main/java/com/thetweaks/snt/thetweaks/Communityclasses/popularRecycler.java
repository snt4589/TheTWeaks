package com.thetweaks.snt.thetweaks.Communityclasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.R;


import java.util.List;

public class popularRecycler extends RecyclerView.Adapter<popularRecycler.popularAdapter> {
    Context mContext;
    List<members> mData;

    public popularRecycler(Context mContext, List<members> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public popularAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.popular_recycler,viewGroup,false);
        popularAdapter popularAdapter = new popularAdapter(v);
        return popularAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull popularAdapter popularAdapter, int i) {
    popularAdapter.name.setText(mData.get(i).getName());
    popularAdapter.desg.setText(mData.get(i).getDesignation());
    popularAdapter.loc.setText(mData.get(i).getLocation());
    popularAdapter.views.setText(mData.get(i).getView());
    popularAdapter.img.setImageResource(mData.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class popularAdapter extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView loc;
        private TextView desg;
        private TextView views;
        private ImageView img;



        public popularAdapter(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.commName);
            loc = (TextView)itemView.findViewById(R.id.comm_location);
            desg = (TextView)itemView.findViewById(R.id.commDesg);
            views = (TextView)itemView.findViewById(R.id.commView);
            img = (ImageView)itemView.findViewById(R.id.img);
        }
    }

}
