package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class THLActivity extends AppCompatActivity {
    THLData thlData = new THLData();
    TextView thlSmokerText, thlAlcoholText, textUserRegion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_h_l);
        JSONObject thlDataSmokerObject = thlData.jsonSmokerArray();
        JSONObject thlDataAlcoholObject = thlData.jsonAlcoholArray();
        thlSmokerText = (TextView) findViewById(R.id.thlSmokerText);
        thlAlcoholText = (TextView) findViewById(R.id.thlAlcoholText);
        textUserRegion = findViewById(R.id.textUserRegion);
        textUserRegion.setText("Your municipality is " + DataHandler.getInstance().getAccount().getRegion());

        try {
            if (thlDataSmokerObject != null) {
                thlSmokerText.setText("In your area " + thlDataSmokerObject.getString("value") + "% of the population uses cigarettes daily.");
            } else {
                thlSmokerText.setText("There is no information related to cigarette use in your area.");
            }
            if (thlDataAlcoholObject != null) {
                thlAlcoholText.setText("Alcohol usage in your area is " + thlDataAlcoholObject.getString("value") + " servings per inhabitant");
            } else {
                thlAlcoholText.setText("There is no information related to alcohol usage in your area.");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}