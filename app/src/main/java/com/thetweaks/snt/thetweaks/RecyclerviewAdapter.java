package com.thetweaks.snt.thetweaks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {


    Context mContext;
    private List<User> mUser;

    public RecyclerviewAdapter(Context mContext, List<User> mUser) {
        this.mContext = mContext;
        this.mUser = mUser;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.explore_recycler, viewGroup, false);
        MyViewHolder vholder = new MyViewHolder(v);

        return vholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.downvote.setText(mUser.get(i).getDownvote());
        myViewHolder.upvote.setText(mUser.get(i).getUpvote());
        myViewHolder.views.setText(mUser.get(i).getViews());
        myViewHolder.post.setText(mUser.get(i).getPostDetails());
        myViewHolder.date.setText(mUser.get(i).getDate());
        myViewHolder.studentinfo.setText(mUser.get(i).getStudentDetail());
        myViewHolder.userdetail.setText(mUser.get(i).getUserName());


    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView date;

        private TextView post;
        private TextView userdetail;
        private TextView views;
        private TextView upvote;
        private TextView downvote;
        private ImageView postView;
        private TextView studentinfo;


        public MyViewHolder(View itemView) {
            super(itemView);

            date = (TextView) itemView.findViewById(R.id.dateOfPost);
            post = (TextView) itemView.findViewById(R.id.post_detail);
            views = (TextView) itemView.findViewById(R.id.views);
            upvote = (TextView) itemView.findViewById(R.id.upvote);
            downvote = (TextView) itemView.findViewById(R.id.downvote);
            studentinfo = (TextView) itemView.findViewById(R.id.student_info);
            userdetail = (TextView) itemView.findViewById(R.id.Name);
        }
    }

}
