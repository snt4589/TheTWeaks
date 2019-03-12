package com.thetweaks.snt.thetweaks.adapters;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.thetweaks.snt.thetweaks.R;
import com.thetweaks.snt.thetweaks.explorerData.Feed;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {
    private List<Feed> feedsList;
    OnPostListener onPostListener;
    StorageReference mstorage;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView category, location, postContent, profileName, date, tweakViews,topic;
        public ImageView postImage;
        OnPostListener onPostListener;

        public MyViewHolder(View view,OnPostListener onPostListener) {
            super(view);
            category = (TextView) view.findViewById(R.id.category);
            location = (TextView) view.findViewById(R.id.location);
            postImage = (ImageView) view.findViewById(R.id.post_image);
            postContent = (TextView) view.findViewById(R.id.post_content);
            profileName = (TextView) view.findViewById(R.id.Profile_name);
            date = (TextView) view.findViewById(R.id.post_date);
            tweakViews = (TextView) view.findViewById(R.id.post_view);
            topic = (TextView) view.findViewById(R.id.feed_topic);
            this.onPostListener = onPostListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onPostListener.onPostClick(getAdapterPosition());

        }
    }

    public FeedAdapter(List<Feed> feedsList , OnPostListener onPostListener) {
        this.feedsList = feedsList;
        this.onPostListener=onPostListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_item, parent, false);

        return new MyViewHolder(itemView,onPostListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mstorage = FirebaseStorage.getInstance().getReference();
        Feed feed = feedsList.get(position);
        holder.category.setText(feed.getCategory());
        holder.location.setText(feed.getLocation());
        ImageView imageView = holder.postImage;

        //Glide.with(context)
          //      .load(spacePhoto.getUrl())
            //    .into(imageView);
        //Glide.with(this).load(mstorage.child(feed.getImageLink()).getDownloadUrl()).into(holder.postImage);
        //holder.postImage.setImageDrawable(createDrawableFromURL(feed.getImageLink()));
        holder.postContent.setText(feed.getPost());
        holder.profileName.setText(feed.getProfilePicLink());
        holder.date.setText(feed.getDate());
        holder.tweakViews.setText(feed.getViewsCount());
        holder.topic.setText(feed.getTopic());
    }

    private Drawable createDrawableFromURL(String imageUrl) {
        Drawable image = null;

        try {
            URL url = new URL(imageUrl);
            InputStream is = (InputStream)url.getContent();
            image = Drawable.createFromStream(is, "src");
            Log.e("hey its running", "hey no2");

        }catch (MalformedURLException e) {
            System.out.println("ERROR" + e.toString());
            Log.e("hey its running", "hey now brown2");

            image = null;
        } catch (IOException e) {

            image = null;
        }
        return image;

    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    public interface OnPostListener{
        void onPostClick(int position);
    }
}
