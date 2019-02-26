package com.thetweaks.snt.thetweaks.explorerData;

public class Feed {
    private String category, location, imageLink, post, profilePicLink, date;
    int viewsCount;

    public Feed() {

    }
    public Feed(String category, String location, String imageLink, String post,
                String profilePicLink, int viewsCount, String date) {
        this.category = category;
        this.location = location;
        this.imageLink = imageLink;
        this.post = post;
        this.profilePicLink = profilePicLink;
        this.viewsCount = viewsCount;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageLink() {
        return imageLink;
    }
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public String getProfilePicLink() {
        return profilePicLink;
    }
    public void setProfilePicLink(String profilePicLink) {
        this.profilePicLink = profilePicLink;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public int getViewsCount(){
        return viewsCount;
    }
    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }


}
