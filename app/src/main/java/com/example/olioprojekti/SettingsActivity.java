package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SettingsActivity extends AppCompatActivity {
    //Account account = DataHandler.getInstance().getAccount();

    TextView stTextFirstName, stTextLastName, stTextUsername, stTextEmail, stTextRegion, stTextWeight, stTextHeight;
    EditText stEditFirstName, stEditLastName, stEditUsername, stEditEmail, stEditRegion, stEditWeight, stEditHeight;

    private static final String FILE_NAME = "data.json";
    String jsonAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        stTextFirstName = findViewById(R.id.stTextFirstName);
        stTextFirstName.setText("First name: " + DataHandler.getInstance().getAccount().getFirstName());

        stTextLastName = findViewById(R.id.stTextLastName);
        stTextLastName.setText("Last name: " + DataHandler.getInstance().getAccount().getLastName());

        stTextEmail = findViewById(R.id.stTextEmail);
        stTextEmail.setText("Email: " + DataHandler.getInstance().getAccount().getEmail());

        stTextRegion = findViewById(R.id.stTextRegion);
        stTextRegion.setText("Municipality: " + DataHandler.getInstance().getAccount().getRegion());

        stTextWeight = findViewById(R.id.stTextWeight);
        stTextWeight.setText("Weight: " + DataHandler.getInstance().getAccount().getWeight());

        stTextHeight = findViewById(R.id.stTextHeight);
        stTextHeight.setText("Height: " + DataHandler.getInstance().getAccount().getHeight());


        stEditFirstName = findViewById(R.id.stEditFirstName);
        stEditLastName = findViewById(R.id.stEditLastName);
        stEditEmail = findViewById(R.id.stEditEmail);
        stEditRegion = findViewById(R.id.stEditRegion);
        stEditWeight = findViewById(R.id.stEditWeight);
        stEditHeight = findViewById(R.id.stEditHeight);

        // LOAD ACCOUNT JSON ARRAYLIST INTO "jsonAccounts" AS STRING FROM "data.json" FILE.
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            jsonAccounts = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // The following methods update user information if the information is in correct format.

    public void saveFirstName(View view) {
        if(TextFormChecker.checkFirstNameFormat(stEditFirstName.getText().toString())) {
            DataHandler.getInstance().getAccount().setFirstName(stEditFirstName.getText().toString());
            DataHandler.getInstance().updateAccount(this);
            stTextFirstName.setText("First name: " + DataHandler.getInstance().getAccount().getFirstName());
        }
    }

    public void saveLastName(View view) {
        if(TextFormChecker.checkLastNameFormat(stEditLastName.getText().toString())) {
            DataHandler.getInstance().getAccount().setLastName(stEditLastName.getText().toString());
            DataHandler.getInstance().updateAccount(this);
            stTextLastName.setText("Last name: " + DataHandler.getInstance().getAccount().getLastName());
        }
    }

    public void saveEmail(View view) {
        DataHandler.getInstance().getAccount().setEmail(stEditEmail.getText().toString());
        DataHandler.getInstance().updateAccount(this);
        stTextEmail.setText("Email: " + DataHandler.getInstance().getAccount().getEmail());
    }

    public void saveRegion(View view) {
        String regionID;
        if ((regionID = TextFormChecker.getRegionID(stEditRegion.getText().toString(), this)) == null) {
            Log.d("Hello", "Hello");
        } else {
            DataHandler.getInstance().getAccount().setRegion(stEditRegion.getText().toString());
            DataHandler.getInstance().getAccount().setRegionID(regionID);
            DataHandler.getInstance().updateAccount(this);
            stTextRegion.setText("Municipality: " + DataHandler.getInstance().getAccount().getRegion());
        }
    }

    public void saveWeight(View view) {
        if (TextFormChecker.checkWeightFormat(stEditWeight.getText().toString())) {
            DataHandler.getInstance().getAccount().setWeight(stEditWeight.getText().toString());
            DataHandler.getInstance().updateAccount(this);
            stTextWeight.setText("Weight: " + DataHandler.getInstance().getAccount().getWeight());
        }
    }

    public void saveHeight(View view) {
        if (TextFormChecker.checkHeightFormat(stEditHeight.getText().toString())) {
            DataHandler.getInstance().getAccount().setHeight(stEditHeight.getText().toString());
            DataHandler.getInstance().updateAccount(this);
            stTextHeight.setText("Height: " + DataHandler.getInstance().getAccount().getHeight());
        }
    }
}