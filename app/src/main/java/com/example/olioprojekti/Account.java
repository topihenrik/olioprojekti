package com.example.olioprojekti;

import java.util.ArrayList;

public class Account {
    private String firstName, lastName, username, email, password, region, weight, height, regionID;
    byte[] salt;
    ArrayList<WaterData> waterDataArrayList = new ArrayList<>();
    ArrayList<WeightData> weightDataArrayList = new ArrayList<>();

    public Account(String firstName, String lastName, String username, String email, String password, String region, String regionID, String weight, String height, byte[] salt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.region = region;
        this.regionID = regionID;
        this.weight = weight;
        this.height = height;
        this.salt = salt;
    }

    public String getUserName() {
        return username;
    }

    public String getHeight() {
        return height;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }


    public void setWaterDataArrayList(ArrayList<WaterData> waterDataArrayList) {
        this.waterDataArrayList = waterDataArrayList;
        return;
    }

    public ArrayList<WaterData> getWaterDataArrayList() {
        return waterDataArrayList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRegionID() { return regionID; }

    public String getRegion() { return region; }

    public void setWeightDataArrayList(ArrayList<WeightData> weightDataArrayList) {
        this.weightDataArrayList = weightDataArrayList;
        return;
    }

    public ArrayList<WeightData> getWeightDataArrayList() { return weightDataArrayList; }



}
