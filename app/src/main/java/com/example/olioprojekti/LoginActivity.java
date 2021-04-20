package com.example.olioprojekti;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private static final String FILE_NAME = "data.json";
    //Account accountInUse = new Account();
    AccountManager am = AccountManager.getInstance();
    EditText username, password;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.editUsername2);
        password = (EditText) findViewById(R.id.editPassword2);
        context = LoginActivity.this;
    }

    public void loadMainActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
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
            Log.d("Login; JSON content:", json);
            Account accountInUse = am.login(username.getText().toString(), password.getText().toString(), json);
            if (accountInUse != null) {
                Toast.makeText(LoginActivity.this, "Logged in!", Toast.LENGTH_LONG).show();
                DataHandler.getInstance().setAccount(accountInUse);
                loadMainActivity();
            } else {
                Toast.makeText(LoginActivity.this, "Wrong Username or Password!", Toast.LENGTH_LONG).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}