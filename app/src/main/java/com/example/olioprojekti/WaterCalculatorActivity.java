package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
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

    public void saveWaterData(View v) {
        WaterData waterData = new WaterData();
        waterData.WaterData(spinnerSelectionInt);
        waterDataArrayList.add(waterData);
        DataHandler.getInstance().getAccount().setWaterDataArrayList(waterDataArrayList);
        DataHandler.getInstance().updateAccount(this);
        Toast.makeText(WaterCalculatorActivity.this, "Data added!", Toast.LENGTH_SHORT).show();
    }

}