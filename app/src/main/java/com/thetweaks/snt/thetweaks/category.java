package com.thetweaks.snt.thetweaks;

public class category {
    public String post_author;
    public String post_details;
    public String post_date;
    public String upvote;
    public String downvote;
    public String topic;
    public String author_details;
    public String post_Image;

    public category(String post_author, String post_details, String post_date, String upvote, String downvote, String topic ,String author_details, String post_Image) {
        this.post_author = post_author;
        this.post_details = post_details;
        this.post_date = post_date;
        this.upvote = upvote;
        this.downvote = downvote;
        this.topic = topic;
        this.author_details = author_details;
        this.post_Image = post_Image;
    }

    public String getPost_author() {
        return post_author;
    }

    public void setPost_author(String post_author) {
        this.post_author = post_author;
    }

    public String getPost_details() {
        return post_details;
    }

    public void setPost_details(String post_details) {
        this.post_details = post_details;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor_details() {
        return author_details;
    }

    public void setAuthor_details(String author_details) {
        this.author_details = author_details;
    }

    public String getPost_Image() {
        return post_Image;
    }

    public void setPost_Image(String post_Image) {
        this.post_Image = post_Image;
    }
}
