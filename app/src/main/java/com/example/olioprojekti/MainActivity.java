package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        textWelcome = findViewById(R.id.textWelcome);
        textWelcome.setText("Welcome, " + DataHandler.getInstance().getAccount().firstName + "!");

    }


    Quotes quotes = Quotes.getInstance();


    public void QuoteAPIText(View v){
        quotes.readJSON();
    }




    public void loadWeightLossActivity(View v){
        Intent intent = new Intent(MainActivity.this, Weightloss_Activity.class);
        startActivity(intent);
    }

    public void loadWaterCalcActivity(View view) {
        Intent intent = new Intent(MainActivity.this, WaterCalculatorActivity.class);
        startActivity(intent);

    }

    public void loadLoginActivity(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
