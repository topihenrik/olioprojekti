package com.example.olioprojekti;

import java.util.ArrayList;

public class Account {


    private String firstName;
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() {
        return firstName;
    }

    private String lastName;
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    private String username;
    public void setUsername(String username) { this.username = username; }
    public String getUsername() {
        return username;
    }

    private String email;
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    private String password;
    public String getPassword() {
        return password;
    }


    private String region;
    public void setRegion(String region) { this.region = region; }
    public String getRegion() { return region; }

    private String regionID;
    public void setRegionID(String regionID) { this.regionID = regionID; }
    public String getRegionID() { return regionID; }


    private String weight;
    public void setWeight(String weight) { this.weight = weight; }
    public String getWeight() { return weight; }

    private String height;
    public void setHeight(String height) { this.height = height; }
    public String getHeight() {
        return height;
    }

    byte[] salt;
    public byte[] getSalt() {
        return salt;
    }


    ArrayList<WaterData> waterDataArrayList = new ArrayList<>();
    public void setWaterDataArrayList(ArrayList<WaterData> waterDataArrayList) { this.waterDataArrayList = waterDataArrayList; }
    public ArrayList<WaterData> getWaterDataArrayList() {
        return waterDataArrayList;
    }

    ArrayList<WeightData> weightDataArrayList = new ArrayList<>();
    public void setWeightDataArrayList(ArrayList<WeightData> weightDataArrayList) { this.weightDataArrayList = weightDataArrayList; }
    public ArrayList<WeightData> getWeightDataArrayList() { return weightDataArrayList; }

    ArrayList<DietData> dietDataArrayList = new ArrayList<>();
    public void setDietDataArrayList(ArrayList<DietData> dietDataArrayList) { this.dietDataArrayList = dietDataArrayList;}
    public ArrayList<DietData> getDietDataArrayList() { return dietDataArrayList; }

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



















}
