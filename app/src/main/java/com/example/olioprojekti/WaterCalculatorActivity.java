package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class WaterCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}