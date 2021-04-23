package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class THLActivity extends AppCompatActivity {
    THLData thlData = new THLData();
    TextView thlSmokerText, thlAlcoholText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_h_l);
        JSONObject thlDataSmokerObject = thlData.jsonSmokerArray();
        JSONObject thlDataAlcoholObject = thlData.jsonAlcoholArray();
        thlSmokerText = (TextView) findViewById(R.id.thlSmokerText);
        thlAlcoholText = (TextView) findViewById(R.id.thlAlcoholText);

        try {
            if (thlDataSmokerObject != null) {
                thlSmokerText.setText("Alueellasi " + thlDataSmokerObject.getString("value") + "% asukkaista käyttää päivittäin tupakkaa.");
            } else {
                thlSmokerText.setText("Alueelta ei löytynyt tietoja tupakankäytöstä.");
            }
            if (thlDataAlcoholObject != null) {
                thlAlcoholText.setText("Alkoholinmyynti asuinalueellasi on " + thlDataAlcoholObject.getString("value") + " annosta per asukas.");
            } else {
                thlAlcoholText.setText("Alueeltasi ei löytynyt tietoja alkoholinkäytöstä.");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}