package com.thetweaks.snt.thetweaks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.commentData;

import java.util.List;

public class comment_adapter extends RecyclerView.Adapter<comment_adapter.MyViewHolder> {
private List<commentData>commentData;
 public comment_adapter(List<commentData> commentData){
     this.commentData = commentData;
 }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
     View v;
     v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewpost_data,viewGroup,false);
     MyViewHolder viewHolder = new MyViewHolder(v);
     return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.comment.setText(commentData.get(i).getComment());
        myViewHolder.commentdate.setText(commentData.get(i).getDate());
        myViewHolder.commentName.setText(commentData.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return commentData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView commentName;
        public TextView commentdate;
        public TextView comment;
        public ImageView commentImage;



        public MyViewHolder(View view){
            super(view);
            commentName=(TextView)view.findViewById(R.id.CommentName);
            commentdate=(TextView)view.findViewById(R.id.CommentDate);
            comment=(TextView)view.findViewById(R.id.Comment);
            commentImage=(ImageView)view.findViewById(R.id.CommentImage);


        }

    }
}
