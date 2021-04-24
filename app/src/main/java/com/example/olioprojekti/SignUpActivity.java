package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    AccountManager am = AccountManager.getInstance();
    Context context = null;
    Gson gson = new Gson();
    EditText editFirstName, editLastName, editEmail, editUsername, editPassword, editHeight, editWeight, editRegion;
    TextView textFailWeight, textFailHeight, textFailPassword, textFailFirstName, textFailLastName, textFailUserName, textFailRegion;
    private static final String FILE_NAME = "data.json";
    ArrayList<Account> arrayList = new ArrayList<>();
    String json, regionJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editHeight = findViewById(R.id.editHeight2);
        editWeight = findViewById(R.id.editWeight);
        editRegion = findViewById(R.id.editRegion);

        textFailWeight = findViewById(R.id.textFailWeight);
        textFailHeight = findViewById(R.id.textFailHeight);
        textFailPassword = findViewById(R.id.textFailPassword);
        textFailFirstName = findViewById(R.id.textFailFirstName);
        textFailLastName = findViewById(R.id.textFailLastName);
        textFailUserName = findViewById(R.id.textFailUserName);
        textFailRegion = findViewById(R.id.textFailRegion);
        Button button = (Button) findViewById(R.id.buttonWeightLoss);
        context = SignUpActivity.this;

        // LOAD ACCOUNT JSON ARRAYLIST INTO "json" AS STRING FROM "data.json" FILE.
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
            json = sb.toString();

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

        // LOAD LIST OF REAGIONS from regionlist.json.
        try {
            InputStream is = this.getAssets().open("regionlist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            regionJson = new String(buffer, "UTF-8");
            //Log.d("regionJson", regionJson);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBackToLoginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(goBackToLoginIntent);
            }
        });
    }

    public void loadLoginActivity() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    // CHECKS IF USERNAME HAS ALREADY BEEN TAKEN.
    public boolean isUserNameTaken(String username, String jsonAccounts) {
        if (!(jsonAccounts == "")) {
            Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();
            arrayList = gson.fromJson(jsonAccounts, userListType);
        }

        for (Account x : arrayList) {
            if (username.equals(x.getUserName())) {
                Log.d("TakenStatus:", "USERNAME IS TAKEN!");
                return true;
            }
            Log.d("TakenStatus:", "USERNAME IS NOT TAKEN!");

        }
        return false;

    }

    public String isRegionAcceptable(String region) {
        JSONArray jsonArray  = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(regionJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if(region.equals(jsonObject.getString("classificationItemName"))) {
                    return jsonObject.getString("code").replaceAll("\u0027", "");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    // USER HAS FILLED SOME INFORMATION AND PRESSES THE "SIGN UP" BUTTON.
    public void registerClick (View view) {
        boolean failcheck = false;

        //Check if information is in right format.
        if(!(editFirstName.getText().toString().matches("[a-zA-Z]+"))) {
            textFailFirstName.setText("Use alphabets!");
            failcheck = true;
        } else {
            textFailFirstName.setText("");
        }

        if(!(editLastName.getText().toString().matches("[a-zA-Z]+"))) {
            textFailLastName.setText("Use alphabets!");
            failcheck = true;
        } else {
            textFailLastName.setText("");
        }

        if (!(editPassword.getText().toString().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$"))) {
            textFailPassword.setText("Password not strong enough!");
            failcheck = true;
        } else {
            textFailPassword.setText("");
        }

        if (!(editWeight.getText().toString().matches("^[0-9]*$")) || (editWeight.getText().toString().equals(""))) {
            textFailWeight.setText("Use numbers!");
            failcheck = true;
        } else {
            textFailWeight.setText("");
        }

        if (!(editHeight.getText().toString().matches("^[0-9]*$")) || (editHeight.getText().toString().equals(""))) {
            textFailHeight.setText("Use numbers!");
            failcheck = true;
        } else {
            textFailHeight.setText("");
        }

        if (isUserNameTaken(editUsername.getText().toString(), json)) {
            textFailUserName.setText("Username is already taken!");
            failcheck = true;
        } else {
            textFailUserName.setText("");
        }

        String regionID;
        if ((regionID = isRegionAcceptable(editRegion.getText().toString())) == null) {
            textFailRegion.setText("Region is not correct.");
            failcheck = true;
        } else {
            textFailRegion.setText("");
        }

        if (failcheck) {
            return;
        }

        try {
            if (!(json == "")) {
                Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();
                arrayList = gson.fromJson(json, userListType);
            }

            Account account = am.register(editFirstName.getText().toString(), editLastName.getText().toString(), editUsername.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString(), editRegion.getText().toString(), regionID, editWeight.getText().toString(), editHeight.getText().toString());
            arrayList.add(account);

            FileOutputStream fos = null;
            String credentials = gson.toJson(arrayList);
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(credentials.getBytes());
            fos.close();
            Toast.makeText(SignUpActivity.this, "Account created!", Toast.LENGTH_LONG).show();
            loadLoginActivity();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

