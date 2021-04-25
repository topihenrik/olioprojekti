package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Quotes quoteClass = Quotes.getInstance();
    TextView textWelcome, quotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        loginStatusChecker();
        textWelcome = findViewById(R.id.textWelcome);
        textWelcome.setText("Welcome, " + DataHandler.getInstance().getAccount().getFirstName() + "!");
        TextView quotes = (TextView) findViewById(R.id.motivationalQuote);
        quotes.setText(quoteClass.getRandomQuote());

    }

    @Override
    public void onResume() {
        super.onResume();
        loginStatusChecker();
    }

    public void loadSwaggerApiActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SwaggerApiActivity.class);
        startActivity(intent);
    }

    public void loadWeightLossActivity(View v){
        Intent intent = new Intent(MainActivity.this, WeightlossActivity.class);
        startActivity(intent);
    }

    public void loadWaterCalcActivity(View view) {
        Intent intent = new Intent(MainActivity.this, WaterCalculatorActivity.class);
        startActivity(intent);

    }

    public void loadLoginActivity(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        DataHandler.getInstance().setAccount(null);
        startActivity(intent);
    }

    public void loadTHLActivity(View v) {
        Intent intent = new Intent(MainActivity.this, THLActivity.class);
        startActivity(intent);
    }

    public void loadInputLogActivity(View v) {
        Intent intent = new Intent(MainActivity.this, InputLogActivity.class);
        startActivity(intent);
    }

    public void loadSettingsActivity(View v) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void loginStatusChecker() {
        if (DataHandler.getInstance().getAccount() == null) {
            Toast.makeText(MainActivity.this, "Login to continue!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

}
