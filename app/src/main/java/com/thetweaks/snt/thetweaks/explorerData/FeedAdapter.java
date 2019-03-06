package com.thetweaks.snt.thetweaks.explorerData;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.thetweaks.snt.thetweaks.R;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {
    private List<Feed> feedsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category, location, postContent, profileName, date, tweakViews,topic;
        public ImageView profileImg;

        public MyViewHolder(View view) {
            super(view);
            category = (TextView) view.findViewById(R.id.category);
            location = (TextView) view.findViewById(R.id.location);
            postContent = (TextView) view.findViewById(R.id.post_content);
            profileName = (TextView) view.findViewById(R.id.Profile_name);
            date = (TextView) view.findViewById(R.id.post_date);
            tweakViews = (TextView) view.findViewById(R.id.post_view);
            topic = (TextView) view.findViewById(R.id.feed_topic);
        }
    }

    public FeedAdapter(List<Feed> feedsList) {
        this.feedsList = feedsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Feed feed = feedsList.get(position);
        holder.category.setText(feed.getCategory());
        holder.location.setText(feed.getLocation());
        holder.postContent.setText(feed.getPost());
        holder.profileName.setText(feed.getProfilePicLink());
        holder.date.setText(feed.getDate());
        holder.tweakViews.setText(feed.getViewsCount());
        holder.topic.setText(feed.getTopic());
    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }
}
