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

    // Loads user input from Water/Weight Calculator into ScrollView.
    public ArrayList<String> loadData(ArrayList<String> dataList) {
        String tempData;
        dataList.add("Your WaterCalculator data: ");
        
        for (WaterData x : DataHandler.getInstance().getAccount().getWaterDataArrayList()) {
            tempData = "Date: " + x.getDate() + ";" + x.getWaterConsumed() + "ml";
            dataList.add(tempData);
        }

        dataList.add("Your Weightloss data: ");

        for (WeightData x : DataHandler.getInstance().getAccount().getWeightDataArrayList()) {
            tempData = "Date: " + x.getDate() + ";" + x.getWeight() + "kg";
            dataList.add(tempData);
        }

        dataList.add("Your ClimateDiet data:");

        for (DietData x : DataHandler.getInstance().getAccount().getDietDataArrayList()) {
            tempData = "Dairy: " + Math.round(Double.parseDouble(x.getDairy())*100.0)/100.0 + ";" + "Meat: "
                    + Math.round(Double.parseDouble(x.getMeat())*100.0)/100.0 + ";" + "Plant: "
                    + Math.round(Double.parseDouble(x.getPlant())*100.0)/100.0 + ";" + "Restaurant: "
                    + Math.round(Double.parseDouble(x.getRestaurant())*100.0)/100.0 + ";" + "Date: "
                    + x.getDate();
            dataList.add(tempData);
        }

        return dataList;
    }
}