package com.example.olioprojekti;

public class WeightData {
    String weight;
    String date;
    public WeightData(String date, String weight){
        this.date = date;
        this.weight = weight;
    }

    public String getWeight() { return weight; }

    public String getDate() { return date; }
}
