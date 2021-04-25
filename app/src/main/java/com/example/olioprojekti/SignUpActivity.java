package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    String jsonAccounts;

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


    // User has filled some information and presses the "SIGN UP" button.
    public void registerClick (View view) {
        boolean failCheck = false;

        //Checks if user given information is in right format.
        if(!(TextFormChecker.checkFirstNameFormat(editFirstName.getText().toString()))) {
            textFailFirstName.setText("Use alphabets!");
            failCheck = true;
        } else {
            textFailFirstName.setText("");
        }

        if(!(TextFormChecker.checkLastNameFormat(editLastName.getText().toString()))) {
            textFailLastName.setText("Use alphabets!");
            failCheck = true;
        } else {
            textFailLastName.setText("");
        }

        if (!(TextFormChecker.checkPasswordFormat(editPassword.getText().toString()))) {
            textFailPassword.setText("Password not strong enough!");
            failCheck = true;
        } else {
            textFailPassword.setText("");
        }

        if (!(TextFormChecker.checkWeightFormat(editWeight.getText().toString()))) {
            textFailWeight.setText("Use numbers!");
            failCheck = true;
        } else {
            textFailWeight.setText("");
        }

        if (!(TextFormChecker.checkHeightFormat(editHeight.getText().toString()))) {
            textFailHeight.setText("Use numbers!");
            failCheck = true;
        } else {
            textFailHeight.setText("");
        }

        if (!(TextFormChecker.checkUsernameFormat(editUsername.getText().toString(), jsonAccounts))) {
            if (editUsername.getText().toString().equals("")) {
                textFailUserName.setText("Invalid username!");
            } else {
                textFailUserName.setText("Username is already taken!");
            }
            failCheck = true;
        } else {
            textFailUserName.setText("");
        }

        String regionID;
        if ((regionID = TextFormChecker.getRegionID(editRegion.getText().toString(), this)) == null) {
            textFailRegion.setText("Region is not correct.");
            failCheck = true;
        } else {
            textFailRegion.setText("");
        }

        if (failCheck) {
            return;
        }

        //Adds users account to "data.json" where it can be accessed as needed.

        try {
            if (!(jsonAccounts == "")) {
                Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();
                arrayList = gson.fromJson(jsonAccounts, userListType);
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

