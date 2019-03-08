package com.thetweaks.snt.thetweaks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.category;

import java.util.List;


public class categoryadapter extends RecyclerView.Adapter<categoryadapter.MyViewHolder> {
    private List<category> categoryList;


    public categoryadapter(List<category> categoryList) {
        this.categoryList = categoryList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categoryrecycler,viewGroup,false);
        MyViewHolder vholder = new MyViewHolder(v);

        return vholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //category category = categoryList.get(i);
        myViewHolder.auth_name.setText(categoryList.get(i).getPost_author());
        myViewHolder.date.setText(categoryList.get(i).getPost_date());
        myViewHolder.detail.setText(categoryList.get(i).getPost_details());
        myViewHolder.upvote.setText(categoryList.get(i).getUpvote());
        myViewHolder.downvote.setText(categoryList.get(i).getDownvote());
        myViewHolder.auth_detail.setText(categoryList.get(i).getAuthor_details());
        myViewHolder.topic.setText(categoryList.get(i).getTopic());



    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView auth_name;
        public TextView detail;
        public TextView upvote;
        public TextView downvote;
        public TextView auth_detail;
        public ImageView image;
        public TextView topic;
        public TextView date;


        public MyViewHolder(View view){
            super(view);
            auth_name = (TextView) view.findViewById(R.id.post_author1);
            date = (TextView) view.findViewById(R.id.post_date1);
            topic = (TextView) view.findViewById(R.id.Topic1);
            detail = (TextView) view.findViewById(R.id.post_content1);
            upvote = (TextView) view.findViewById(R.id.Upvote1);
            downvote = (TextView) view.findViewById(R.id.dwnvote1);
            auth_detail = (TextView) view.findViewById(R.id.auth_detail);
            image = (ImageView) view.findViewById(R.id.post_image1);




        }

    }
}
