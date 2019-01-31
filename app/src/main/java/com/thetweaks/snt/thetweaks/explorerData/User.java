package com.thetweaks.snt.thetweaks.explorerData;

public class User {
    private String userName;
    private String postDetails;
    private String upvote;
    private String downvote;
    private String date;
    private String studentDetail;
    private String views;
    private String topic;

    public User(String name, String post, String up, String down, String date, String stndetail, String views) {
        userName = name;
        postDetails = post;
        upvote = up;
        downvote = down;
        date = date;
        studentDetail = stndetail;
        views = views;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(String postDetails) {
        this.postDetails = postDetails;
    }

    public String getUpvote() {
        return upvote;
    }

    public void setUpvote(String upvote) {
        this.upvote = upvote;
    }

    public String getDownvote() {
        return downvote;
    }

    public void setDownvote(String downvote) {
        this.downvote = downvote;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(String studentDetail) {
        this.studentDetail = studentDetail;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}

