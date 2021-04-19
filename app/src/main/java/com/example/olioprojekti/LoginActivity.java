package com.example.olioprojekti;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginActivity extends AppCompatActivity {
    private static final String FILE_NAME = "data.json";
    AccountManager am = AccountManager.getInstance();
    EditText username, password;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.backToMain);
        username = (EditText) findViewById(R.id.editUsername2);
        password = (EditText) findViewById(R.id.editPassword2);
        context = LoginActivity.this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBackToMainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(goBackToMainIntent);
            }
        });
    }

    public void loadRegisterActivity(View v) {
        finish();
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void loginButton(View v) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = context.openFileInput(FILE_NAME);
            String output = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            String json = sb.toString();
            System.out.println(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}