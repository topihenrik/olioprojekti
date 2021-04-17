package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    Quotes asd = Quotes.getInstance();
    FatData asdas = new FatData();

    public void apina(View v){
        asd.readJSON();
    }


    public void monke(View v){
        asdas.method();
    }

    public void loadActivity(View v){
        Intent intent = new Intent(MainActivity.this, Weightloss_Activity.class);
        startActivity(intent);
    }

    public void loadWaterCalc(View view) {
        Intent intent = new Intent(MainActivity.this, WaterCalculatorActivity.class);
        startActivity(intent);

    }

    public void loadLoginActivity(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
