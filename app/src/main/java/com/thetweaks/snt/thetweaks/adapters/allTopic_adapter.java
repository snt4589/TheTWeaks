package com.thetweaks.snt.thetweaks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.allTopics;
import com.thetweaks.snt.thetweaks.topTopic;

import java.util.List;

public class allTopic_adapter extends RecyclerView.Adapter<allTopic_adapter.MyViewHolder> {
private List<topTopic> allTopicList;
public allTopic_adapter(List<topTopic> allTopicList){this.allTopicList = allTopicList;}


    @NonNull
    @Override
    public allTopic_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v;
    v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alltopic_recycler,viewGroup,false);
    MyViewHolder viewHolder = new MyViewHolder(v);
    return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull allTopic_adapter.MyViewHolder myViewHolder, int i) {

    myViewHolder.allCategory.setText(allTopicList.get(i).getCategory());
    myViewHolder.allname.setText(allTopicList.get(i).getName());
    myViewHolder.title.setText(allTopicList.get(i).getTopic());
    }

    @Override
    public int getItemCount() {
        return allTopicList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView allname;
        public TextView title;
        public TextView allCategory;


        public MyViewHolder(View view){
            super(view);
            allname=(TextView)view.findViewById(R.id.allTopicName);
            title=(TextView)view.findViewById(R.id.allTopicTitle);
            allCategory=(TextView)view.findViewById(R.id.alltopicCategory);
        }


    }
}
