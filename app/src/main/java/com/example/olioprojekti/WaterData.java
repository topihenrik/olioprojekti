package com.example.olioprojekti;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WaterData {
    private String date;
    private int waterconsumed;

    public void WaterData(int waterconsumed) {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedDate = df.format(currentTime);
        this.date = formattedDate;
        Log.d("Päivämäärä data", this.date);
        this.waterconsumed = waterconsumed;
    }

}
