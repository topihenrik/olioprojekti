package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class InputLogActivity extends AppCompatActivity {
    ListView logListView;
    ArrayList<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_log);
        logListView = findViewById(R.id.logListView);
        loadData(dataList);
        ArrayAdapter logListViewAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList);
        logListView.setAdapter(logListViewAdapter);
    }

    public ArrayList<String> loadData(ArrayList<String> dataList) {
        String tempData;
        dataList.add("Your WaterCalculator data: ");
        
        for (WaterData x : DataHandler.getInstance().getAccount().getWaterDataArrayList()) {
            tempData = x.getDate() + ";" + x.getWaterConsumed();
            dataList.add(tempData);
        }

        dataList.add("Your WeightCalculator data: ");

        for (WeightData x : DataHandler.getInstance().getAccount().getWeightDataArrayList()) {
            tempData = x.getDate() + ";" + x.getWeight();
            dataList.add(tempData);
        }


        return dataList;
    }
}