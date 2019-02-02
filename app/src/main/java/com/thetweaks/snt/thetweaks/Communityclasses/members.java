package com.thetweaks.snt.thetweaks.Communityclasses;

public class members {
    private String Name;
    private String location;
    private String Designation;
    private int photo;
    private String Name1;
    private String location1;
    private String Designation1;
    private int photo1;
    private String view;

    public members() {
    }

    public members(String name, String location, String designation, int photo, String name1, String location1, String designation1, int photo1) {
        Name = name;
        this.location = location;
        Designation = designation;
        this.photo = photo;
        Name1 = name1;
        this.location1 = location1;
        Designation1 = designation1;
        this.photo1 = photo1;
    }

    public members(String name, String location, String designation, int photo, String view) {
        Name = name;
        this.location = location;
        Designation = designation;
        this.photo = photo;
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getDesignation1() {
        return Designation1;
    }

    public void setDesignation1(String designation1) {
        Designation1 = designation1;
    }

    public int getPhoto1() {
        return photo1;
    }

    public void setPhoto1(int photo1) {
        this.photo1 = photo1;
    }
}
