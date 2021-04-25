package com.example.olioprojekti;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DietData {
    public String getDairy() {
        return Dairy;
    }

    public String getMeat() {
        return Meat;
    }

    public String getPlant() {
        return Plant;
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public String getTotal() {
        return Total;
    }

    public String getDate() {
        return Date;
    }

    private String Dairy;
    private String Meat;
    private String Plant;
    private String Restaurant;
    private String Total;
    private String Date;

    public void initDate() {
        java.util.Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedDate = df.format(currentTime);
        this.Date = formattedDate;
    }

}
