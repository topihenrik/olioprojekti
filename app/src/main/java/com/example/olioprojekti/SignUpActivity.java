package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class SignUpActivity extends AppCompatActivity {
    AccountManager am = AccountManager.getInstance();
    Context context = null;
    Gson gson = new Gson();
    EditText editFirstName, editLastName, editEmail, editUsername, editPassword, editHeight, editWeight, editAddress;
    private static final String FILE_NAME = "data.json";

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
        editAddress = findViewById(R.id.editAddress);
        Button button = (Button) findViewById(R.id.buttonWeightLoss);
        context = SignUpActivity.this;
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            fos.write("".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBackToLoginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(goBackToLoginIntent);
            }
        });
    }

    public void registerClick (View view) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = context.openFileInput(FILE_NAME);
            String output = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            String json = sb.toString();
            Type userListType = new TypeToken<ArrayList<Account>>(){}.getType();

            Account account = am.register(editFirstName.getText().toString(), editLastName.getText().toString(), editEmail.getText().toString(), editUsername.getText().toString(), editPassword.getText().toString(), editHeight.getText().toString(), editWeight.getText().toString(), editAddress.getText().toString());
            ArrayList<Account> arrayList = gson.fromJson(json, userListType);

            FileOutputStream fos = null;
            String credentials = gson.toJson(arrayList);
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(credentials.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

