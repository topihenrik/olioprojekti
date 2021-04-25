package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {
    private static final String FILE_NAME = "data.json";
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

        // CREATE "data.json" IF IT DOESN'T EXIST. IF THE FILE EXISTS THEN NOTHING INTERESTING HAPPENS.
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
    }

    public void loadMainActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void loadRegisterActivity(View v) {
        //finish();
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