package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

public class SwaggerApiActivity extends AppCompatActivity {

    SwaggerApi sa = new SwaggerApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_swagger_api);
    }


    public void swgXMLButton(View view) {
        sa.readXML();
        return;
    }
}


