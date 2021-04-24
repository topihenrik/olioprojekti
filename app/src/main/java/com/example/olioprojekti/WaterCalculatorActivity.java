package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WaterCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int spinnerSelectionInt;
    static ArrayList<WaterData> waterDataArrayList = new ArrayList<>();
    String ageCategory = "Adult"; // USED FOR TESTING. ALL AGE CATEGORIES ARE: CHILD, ADULT, ELDERLY
    int waterDrankToday = 0;
    TextView textDrankToday, textWaterRecommendation, textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_calculator);
        Spinner waterSpinner = findViewById(R.id.wtrSizeSpinner);
        ArrayAdapter<CharSequence> waterAdapater = ArrayAdapter.createFromResource(this, R.array.waterSizes, android.R.layout.simple_spinner_item);
        waterAdapater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterSpinner.setAdapter(waterAdapater);
        waterSpinner.setOnItemSelectedListener(this);
        textDrankToday = findViewById(R.id.wtrWaterDrankToday);
        textWaterRecommendation = findViewById(R.id.wtrRecommendation);
        textWelcome = findViewById(R.id.wtrWelcomeText);
        waterDataArrayList = DataHandler.getInstance().getAccount().getWaterDataArrayList();
        textWelcome.setText("Welcome, " + DataHandler.getInstance().getAccount().getFirstName() + "!");
        waterNeed();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerSelectionInt = Integer.parseInt(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveWaterData(View v) {
        WaterData waterData = new WaterData();
        waterData.WaterData(spinnerSelectionInt);
        waterDataArrayList.add(waterData);
        DataHandler.getInstance().getAccount().setWaterDataArrayList(waterDataArrayList);
        DataHandler.getInstance().updateAccount(this);
        Toast.makeText(WaterCalculatorActivity.this, "Data added!", Toast.LENGTH_SHORT).show();
        waterNeed();
    }

    public void waterNeed() {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedCurrentDate = df.format(currentTime);


         //DataHandler.getInstance().getAccount().getWaterDataArrayList(waterDataArrayList);
         if(waterDataArrayList.size() > 0) {
             for (WaterData x: waterDataArrayList) {
                 if(x.getDate().equals(formattedCurrentDate)) {
                     waterDrankToday = waterDrankToday + x.getWaterConsumed();
                 }
             }
         }

        textDrankToday.setText(waterDrankToday + " milliliters of water drank today.");
        if(waterDrankToday == 0) {
            return;
        }

        if (ageCategory.equals("Child")) {
            if(waterDrankToday < 1000) {
                textWaterRecommendation.setText("You have to drink more water.");
            } else if (waterDrankToday > 1500) {
                textWaterRecommendation.setText("You have drank too much water.");
            } else {
                textWaterRecommendation.setText("You have drank enough water.");
            }
        } else if (ageCategory.equals("Adult")) {
            if(waterDrankToday < 2000) {
                textWaterRecommendation.setText("You have to drink more water.");
            } else if (waterDrankToday > 3000) {
                textWaterRecommendation.setText("You have drank too much water.");
            } else {
                textWaterRecommendation.setText("You have drank enough water.");
            }
        } else if (ageCategory.equals("Elderly")) {
            if(waterDrankToday < 1000) {
                textWaterRecommendation.setText("You have to drink more water.");
            } else if (waterDrankToday > 1500) {
                textWaterRecommendation.setText("You have drank too much water.");
            } else {
                textWaterRecommendation.setText("You have drank enough water.");
            }
        }
        return;
    }

}