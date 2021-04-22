package com.example.olioprojekti;

import java.util.ArrayList;

public class Account {
    String firstName, lastName, username, email, password, address, weight, height;
    byte[] salt;
    ArrayList<WaterData> waterDataArrayList = new ArrayList<>();
    ArrayList<WeightData> weightDataArrayList = new ArrayList<>();

    public Account(String firstName, String lastName, String username, String email, String password, String address, String weight, String height, byte[] salt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.salt = salt;
    }

    public String getUserName() {
        return username;
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

    public void setWeightDataArrayList(ArrayList<WeightData> weightDataArrayList) {
        this.weightDataArrayList = weightDataArrayList;
        return;
    }



}
