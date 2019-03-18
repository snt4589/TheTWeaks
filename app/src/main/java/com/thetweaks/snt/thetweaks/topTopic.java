package com.thetweaks.snt.thetweaks;

public class topTopic {
    String topic;
    String category;
    String name;
    String image;


    public topTopic(String topic, String category, String name, String image) {
        this.topic = topic;
        this.category = category;
        this.name = name;
        this.image = image;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
