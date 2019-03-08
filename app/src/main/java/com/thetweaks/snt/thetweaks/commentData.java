package com.thetweaks.snt.thetweaks;

public class commentData {
    private String name;
    private String date;
    private String comment;
    private String image;

    public commentData(String name, String date, String comment, String image) {
        this.name = name;
        this.date = date;
        this.comment = comment;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
