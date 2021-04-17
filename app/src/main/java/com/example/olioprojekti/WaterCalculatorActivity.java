package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.gson.Gson;
import java.util.ArrayList;

public class WaterCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int spinnerSelectionInt;
    static ArrayList<WaterData> waterDataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_calculator);
        Spinner waterSpinner = findViewById(R.id.wtrSizeSpinner);
        ArrayAdapter<CharSequence> waterAdapater = ArrayAdapter.createFromResource(this, R.array.waterSizes, android.R.layout.simple_spinner_item);
        waterAdapater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterSpinner.setAdapter(waterAdapater);
        waterSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerSelectionInt = Integer.parseInt(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void jsonSave(View v) {
        Gson gson = new Gson();
        WaterData waterData = new WaterData();
        waterData.WaterData(spinnerSelectionInt);
        waterDataArrayList.add(waterData);
        String json = gson.toJson(waterDataArrayList);
        Log.d("JSON water data", json);
    }

}